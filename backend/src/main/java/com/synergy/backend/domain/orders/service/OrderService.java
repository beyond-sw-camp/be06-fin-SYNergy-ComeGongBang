package com.synergy.backend.domain.orders.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.model.response.OrderListRes;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.model.entity.Cart;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.model.entity.Present;
import com.synergy.backend.domain.orders.model.request.OrderConfirmReq;
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
    public Boolean confirmOrderBefore(String impUid, Long memberIdx)
            throws BaseException, IamportResponseException, IOException {
        //impuid에서 결제정보 얻기
        IamportResponse<Payment> response = iamportClient.paymentByImpUid(impUid); //사전 검증에는 uid 확인 x
        List<Long> cartIds = jsonToList(impUid, response); //카트 idx 리스트
        BigDecimal amount = response.getResponse().getAmount(); //결제 금액

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
            Product product = cart.getProduct();
            String[] options = cart.getOptionSummary().split("/");
            for (String option : options) {
                String major = option.split(":")[0].split(".")[1];
                String sub = option.split(":")[1];

                ProductSubOptions productSubOptions = productSubOptionsRepository.findSubOptionByProduct(product, major,
                        sub).orElseThrow(
                        () -> new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT)
                );

                if (productSubOptions.getInventory() < cart.getCount()) {
                    return false;
                }
            }
        }
        return true;
    }

    public String confirmOrder(OrderConfirmReq req, Long memberIdx)
            throws BaseException, IamportResponseException, IOException {

        String impUid = req.getImpUid();

        //impuid에서 결제정보 얻기
        IamportResponse<Payment> response = iamportClient.paymentByImpUid(impUid);
        CancelData cancelData = new CancelData(impUid, true);
        List<Long> cartIds = jsonToList(impUid, response); //카트 idx 리스트
        BigDecimal amount = response.getResponse().getAmount(); //결제 금액

        //카트 idx로 카트 정보 가져오기, 회원하고 일치하는지 확인
        Member member = Member.builder().idx(memberIdx).build();
        List<Cart> cartList = cartRepository.findAllByIdxAndMember(cartIds, member);

//        if(cartList.isEmpty()){
//            cancelOrder(cancelData);
//            throw new BaseException(BaseResponseStatus.NOT_FOUND_CART);
//        }
//        if(cartList.size() != cartIds.size()){
//            cancelOrder(cancelData);
//            throw new BaseException(BaseResponseStatus.INVALID_CART_INFORMATION);
//        }
//
//        String result = validation(cartList,cartIds, cancelData, amount, member);
//
//        return result;

        if(req.getPresent()==null){
            for (Cart cart : cartList) {
                //재고 조절
//            adjustInventory(cart, cancelData);


                //주문 테이블에 저장
                orderRepository.save(Orders.builder()
                        .totalPrice(cart.getPrice())
                        .member(member)
                        .product(cart.getProduct())
                        .deliveryState("발송 전")
                        .paymentState("결제 완료")
                        .build());
            }
        }else {
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
//            adjustInventory(cart, cancelData);

                //주문 테이블에 저장
                orderRepository.save(Orders.builder()
                        .totalPrice(cart.getPrice())
                        .member(member)
                        .present(present)
                        .product(cart.getProduct())
                        .deliveryState("발송 전")
                        .paymentState("결제 완료")
                        .build());
            }
        }



        //카트에서 삭제
//        optionInCartRepository.deleteAllByCartIdx(cartIds);
//        cartRepository.deleteByCartIdxList(cartIds);

        return "결제가 완료됐습니다.";

    }


    @Transactional
    public String validation(List<Cart> cartList, List<Long> cartIds, CancelData cancelData, BigDecimal amount,
                             Member member)
            throws BaseException, IamportResponseException, IOException {

        //실제 상품 금액 계산
        Integer totalPrice = 0;
        for (Cart cart : cartList) {
            totalPrice += cart.getPrice() * cart.getCount();
        }
        totalPrice = totalPrice - totalPrice * (2 / 100);

        //검증 후 조치
        if (amount.intValue() == totalPrice) { //정상 결제일 경우
            for (Cart cart : cartList) {
                //재고 조절
                adjustInventory(cart, cancelData);

                //주문 테이블에 저장
                orderRepository.save(Orders.builder()
                        .totalPrice(totalPrice)
                        .member(member)
                        .product(cart.getProduct())
                        .deliveryState("발송 전")
                        .paymentState("결제 완료")
                        .build());
            }

            //카트에서 삭제
            cartRepository.deleteByCartIdxList(cartIds);

            return "결제가 완료됐습니다.";

        } else { //비정상 결제
            //환불 처리
            cancelOrder(cancelData);

            //주문 테이블에 저장
            for (Cart cart : cartList) {
                orderRepository.save(Orders.builder()
                        .totalPrice(totalPrice)
                        .member(member)
                        .product(cart.getProduct())
                        .paymentState("환불 완료")
                        .build());
            }

            return "환불처리 됐습니다. 주문을 다시 진행해주세요.";
        }
    }

    @Transactional
    public void adjustInventory(Cart cart, CancelData cancelData)
            throws BaseException, IamportResponseException, IOException {
        Product product = cart.getProduct();
        String[] options = cart.getOptionSummary().split("/");
        for (String option : options) {
            String major = option.split(":")[0].split(".")[1];
            String sub = option.split(":")[1];

            //일치하는 상품, 옵션이 없는 경우 예외처리
            ProductSubOptions productSubOptions = productSubOptionsRepository.findSubOptionByProduct(product, major,
                    sub).orElseThrow(
                    () -> new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT)
            );

            //방법 1
            if (productSubOptions.getInventory() < cart.getCount()) {
                cancelOrder(cancelData);
                throw new BaseException(BaseResponseStatus.OUT_OF_STOCK);
            }

            Integer newInventory = productSubOptions.getInventory() - cart.getCount();
            productSubOptions.setInventory(newInventory);
            //여기서 누군가가 뭘하명 문제 -> 낙관적 락
            productSubOptionsRepository.save(productSubOptions); //Todo 저장 직전에 다른 로직에서 옵션을 건들이면? 만약 사장님이 재고를 바꾸면???

            //방법2 -> 쿼리 실행 자체에서 동시성 문제가 안생기나?
            //int updatedRows = productSubOptionsRepository.decreaseInventory(product, major, sub, cart.getCount());

            //if (updatedRows == 0) {
            //    cancelOrder(cancelData);
            //    throw new BaseException(BaseResponseStatus.OUT_OF_STOCK);
            //}
        }
    }

    private void cancelOrder(CancelData cancelData) throws IamportResponseException, IOException {
        iamportClient.cancelPaymentByImpUid(cancelData);
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
}
