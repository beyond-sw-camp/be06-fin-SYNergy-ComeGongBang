package com.synergy.backend.domain.orders.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.synergy.backend.domain.coupon.repository.CouponRepository;
import com.synergy.backend.domain.grade.repository.GradeRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.model.response.OrderListRes;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.model.entity.Cart;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.model.entity.Present;
import com.synergy.backend.domain.orders.model.request.OrderConfirmReq;
import com.synergy.backend.domain.orders.model.response.CustomData;
import com.synergy.backend.domain.orders.model.response.PreValidationRes;
import com.synergy.backend.domain.orders.model.response.isWritableRes;
import com.synergy.backend.domain.orders.repository.CartRepository;
import com.synergy.backend.domain.orders.repository.OptionInCartRepository;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import com.synergy.backend.domain.orders.repository.PresentRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.entity.ProductSubOptions;
import com.synergy.backend.domain.product.repository.ProductSubOptionsRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CouponRepository couponRepository;
    private final GradeRepository gradeRepository;
    private final ProductSubOptionsRepository productSubOptionsRepository;
    private final IamportClient iamportClient;
    private final OptionInCartRepository optionInCartRepository;
    private final PresentRepository presentRepository;
    private final MemberRepository memberRepository;

    public List<OrderListRes> orderList(Integer year, Integer page, Integer size, Long memberIdx) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Direction.DESC, "idx"));
        Page<Orders> results = orderRepository.orderList(year, pageable, memberIdx);

        List<OrderListRes> orders = new ArrayList<>();

        for (Orders result : results) {
            orders.add(OrderListRes.builder()
                    .date(result.getCreatedAt())
                    .price(result.getTotalPrice())
                    .imageUrl(result.getProduct().getThumbnailUrl())
                    .name(result.getProduct().getName())
                    .atelier(result.getProduct().getAtelier().getName())
                    .state(result.getDeliveryState()).build());
        }

        return orders;
    }

    //사전 검증 - 재고 확인
    @Transactional
    public PreValidationRes confirmOrderBefore(List<Long> cartIds, Long memberIdx)
            throws BaseException, IamportResponseException, IOException {

        //카트 idx로 카트 정보 가져오기, 회원하고 일치하는지 확인
        Member member = Member.builder().idx(memberIdx).build();
        List<Cart> cartList = cartRepository.findAllByIdxAndMember(cartIds, member);

        if (cartList.size() == 0 || cartList == null) {
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CART);
        }
        if (cartList.size() != cartIds.size()) {
            throw new BaseException(BaseResponseStatus.INVALID_CART_INFORMATION);
        }

        //재고 확인
        for (Cart cart : cartList) {
            Long productIdx = cart.getProduct().getIdx();
            String[] options = cart.getOptionSummary().split("/");
            for (String option : options) {
                String major = option.split(":")[0].split("\\.")[1];
                String sub = option.split(":")[1];

                ProductSubOptions productSubOptions = productSubOptionsRepository.findSubOptionByProduct(productIdx, major, sub).orElseThrow(
                        () -> new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT)
                );

                if (productSubOptions.getInventory() < cart.getCount()) {
                    return PreValidationRes.builder().isOrderable(false).message("상품 재고가 부족합니다.").build();
                }
            }
        }
        return PreValidationRes.builder().isOrderable(true).message("결제 가능.").build();
    }

    //가격, 재고 검증 후 주문 테이블에 저장
    @Transactional
    public String confirmOrder(OrderConfirmReq req, Long memberIdx)
            throws BaseException, IamportResponseException, IOException {

        String impUid = req.getImpUid();

        //impuid에서 결제정보 얻기
        IamportResponse<Payment> response = iamportClient.paymentByImpUid(impUid);
        CancelData cancelData = new CancelData(impUid, true);
        String sCustom = response.getResponse().getCustomData();
        CustomData customData = parseCustomData(response.getResponse().getCustomData());
        List<Long> cartIds = customData.getCartIds(); // 카트 idx 리스트
        Long couponIdx = customData.getCouponIdx(); //사용한 쿠폰 idx
        BigDecimal amount = response.getResponse().getAmount(); //결제 금액
        //List<Long> cartIds = jsonToList(impUid, response); //커스텀 데이터 가져오는 이전 방식


        // 카트+회원 검증 - 카트 idx와 회원 정보로 카트 정보 가져오기
        Member member = Member.builder().idx(memberIdx).build();
        List<Cart> cartList = cartRepository.findAllByIdxAndMember(cartIds, member);

        if(cartList.isEmpty()){
            cancelOrder(cancelData);
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CART);
        }
        if(cartList.size() != cartIds.size()){
            cancelOrder(cancelData);
            throw new BaseException(BaseResponseStatus.INVALID_CART_INFORMATION);
        }

        //상품 가격 검증
        Boolean result = validation(cartList, cartIds, couponIdx ,amount, member);

        //검증 실패시 환불 후 주문 테이블에 저장
        if(!result){
            //환불 처리
            cancelOrder(cancelData);
            //주문 테이블에 저장
            for (Cart cart : cartList) {
                addOrders(cart, amount.intValue(), member, "환불 완료", null, null);
            }
            return "비정상적인 결제. 환불 완료.";
        }

        if(req.getPresent()==null){
            //일반 결제일 경우
            for (Cart cart : cartList) {
                //재고 조절
                adjustInventory(cart, cancelData);
                //주문 테이블에 저장
                addOrders(cart, cart.getPrice(), member, "결제 완료", "배송 완료", null);
            }
        }else {
            //선물 결제일 경우
            String toMemberEmail = req.getPresent().getToMemberEmail();
            String message = req.getPresent().getMessage();
            Member toMember = memberRepository.findByEmail(toMemberEmail).orElseThrow(()-> new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

            //선물 테이블에 저장
            Present present = presentRepository.save(Present.builder()
                    .fromMember(Member.builder().idx(memberIdx).build())
                    .toMember(toMember)
                    .message(message)
                    .build());

            for (Cart cart : cartList) {
                //재고 조절
                adjustInventory(cart, cancelData);
                //주문 테이블에 저장
                addOrders(cart, cart.getPrice(),member,"결제 완료", "배송 완료", present);
            }
        }

        //카트에서 삭제
        optionInCartRepository.deleteAllByCartIdx(cartIds);
        cartRepository.deleteByCartIdxList(cartIds);

        return "결제가 완료됐습니다.";
    }


    //=========== 가격 검증 ============//
    @Transactional
    public Boolean validation(List<Cart> cartList, List<Long> cartIds, Long couponIdx, BigDecimal amount, Member member)
            throws BaseException, IamportResponseException, IOException {

        //실제 상품 금액 계산
        Integer totalPrice = 0;
        for (Cart cart : cartList) {
            Integer productPrice = cart.getProduct().getPrice();
            Integer onSalePercent = cart.getProduct().getOnSalePercent();
            Integer discountedPrice = (int) Math.floor(productPrice*(1-onSalePercent/100.0));
            Integer optionPrice = cart.getPrice() - productPrice;
            totalPrice += ((discountedPrice)+(optionPrice)) * cart.getCount();
        }

        //등급 할인 적용
        Integer gradeDiscount = gradeRepository.findDrageDiscountPercentByMember(member);
        totalPrice -= (int) Math.floor(totalPrice*gradeDiscount/100.0);

        //쿠폰 할인률
        if(couponIdx!=null){
            Integer couponDiscount = couponRepository.findCouponDiscountRate(couponIdx, member);
            if(couponDiscount==null){
                throw new BaseException(BaseResponseStatus.COUPON_NOT_FOUND);
            }
            totalPrice -= (int) Math.floor(totalPrice*couponDiscount/100.0);
        }

        //검증 후 조치
        if (amount.intValue() == totalPrice) { //정상 결제일 경우
            return true;
        } else { //비정상 결제
            return false;
        }
    }

    //=========== 주문 테이블에 저장 ===========//
    @Transactional
    public void addOrders(Cart cart, Integer totalPrice, Member member, String payementState, String deliveryState, Present present){
        //주문 테이블에 저장
        orderRepository.save(Orders.builder()
                .totalPrice(totalPrice)
                .member(member)
                .present(present)
                .product(cart.getProduct())
                .deliveryState(deliveryState)
                .paymentState(payementState)
                .build());
    }

    //=========== 재고 검증 및 업데이트 ===========//
    @Transactional
    public void adjustInventory(Cart cart, CancelData cancelData)
            throws BaseException, IamportResponseException, IOException {
        Long productIdx = cart.getProduct().getIdx();
        String[] options = cart.getOptionSummary().split("/");
        for (String option : options) {
            String major = option.split(":")[0].split("\\.")[1];
            String sub = option.split(":")[1];

            //일치하는 상품, 옵션이 없는 경우 예외처리
            ProductSubOptions productSubOptions = productSubOptionsRepository.findSubOptionByProduct(productIdx, major, sub).orElseThrow(
                    () -> new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT)
            );

            if (productSubOptions.getInventory() < cart.getCount()) {
                cancelOrder(cancelData);
                throw new BaseException(BaseResponseStatus.OUT_OF_STOCK);
            }

            productSubOptions.updateInventory(cart.getCount());
            productSubOptionsRepository.save(productSubOptions); //Todo 저장 직전에 다른 로직에서 옵션을 건들이면? 만약 사장님이 재고를 바꾸면???

            //방법2 -> 쿼리 실행 자체에서 동시성 문제가 안생기나?
//            int updatedRows = productSubOptionsRepository.decreaseInventory(product, major, sub, cart.getCount());
//            if (updatedRows == 0) {
//                cancelOrder(cancelData);
//                throw new BaseException(BaseResponseStatus.OUT_OF_STOCK);
//            }
        }
    }

    //=========== 주문 취소===========//
    private void cancelOrder(CancelData cancelData) throws IamportResponseException, IOException {
        iamportClient.cancelPaymentByImpUid(cancelData);
    }

    //=========== customdata를 객체로 ===========//
    private CustomData parseCustomData(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(jsonString, CustomData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    //=========== 후기 작성 가능한지 ===========//
    public isWritableRes isOrdered(Long memberIdx, Long productIdx) {
        Optional<Orders> result = orderRepository.findByMemberIdxAndProductIdx(memberIdx, productIdx);
        if(result.isPresent()){
            Orders orders = result.get();
            if(!orders.getDeliveryState().equals("배송 완료")){
                return isWritableRes.builder()
                        .isWritable(false)
                        .comment("배송 완료 후에 후기를 작성할 수 있습니다.").build();
            }
            return isWritableRes.builder()
                    .isWritable(true)
                    .comment("후기 작성 가능").build();
        }
        return isWritableRes.builder()
                .isWritable(false)
                .comment("상품을 구매한 회원만 후기 작성이 가능합니다.").build();
    }

    private List<Long> jsonToList(String impUid, IamportResponse<Payment> response) throws BaseException {
        // Gson을 이용해 JSON 문자열을 객체로 변환
        String customData = response.getResponse().getCustomData();

        Gson gson = new Gson();
        TypeToken<List<Long>> typeToken = new TypeToken<List<Long>>() {
        };
        List<Long> cartIds = gson.fromJson(customData, typeToken.getType());

        if (cartIds.size() == 0 || cartIds == null) {
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CART);
        }

        return cartIds;
    }
}



