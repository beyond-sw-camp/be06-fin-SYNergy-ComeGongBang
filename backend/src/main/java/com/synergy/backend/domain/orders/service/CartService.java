package com.synergy.backend.domain.orders.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.model.entity.Cart;
import com.synergy.backend.domain.orders.model.entity.OptionInCart;
import com.synergy.backend.domain.orders.model.request.*;
import com.synergy.backend.domain.orders.model.response.*;
import com.synergy.backend.domain.orders.model.type.CartType;
import com.synergy.backend.domain.orders.repository.CartRepository;
import com.synergy.backend.domain.orders.repository.OptionInCartRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.entity.ProductMajorOptions;
import com.synergy.backend.domain.product.model.entity.ProductSubOptions;
import com.synergy.backend.domain.product.repository.ProductMajorOptionsRepository;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.domain.product.repository.ProductSubOptionsRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.util.AesUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartService {

    private final MemberRepository memberRepository;

    private final CartRepository cartRepository;
    private final OptionInCartRepository optionInCartRepository;

    private final ProductRepository productRepository;
    private final ProductMajorOptionsRepository majorOptionsRepository;
    private final ProductSubOptionsRepository subOptionsRepository;

    private final Gson gson;
    private final AesUtil aesUtil;

    //리스트 직렬화
    public String serializeCartIdxList(List<Long> cartIdxList) {
        return new Gson().toJson(cartIdxList);
    }

    //[장바구니] 상품 추가
    @Transactional
    public void addCart(Long memberIdx, List<AddCartReq> reqs) throws BaseException {

        List<AddCartReq> newCarts = new ArrayList<>();
        for (AddCartReq req : reqs) {
            //중복
            Optional<Cart> duplicateCart = cartRepository
                    .findByProductIdxAndMemberIdxAndOptionSummaryAndCartType(
                            req.getProductIdx(), memberIdx, req.getOptionSummary(), CartType.DEFAULT);

            if (duplicateCart.isPresent()) {
                Cart existingCart = duplicateCart.get();
                existingCart.updateCount(existingCart.getCount() + req.getCount());
                cartRepository.save(existingCart);
            } else {
                newCarts.add(req);
            }
        }
        if (!newCarts.isEmpty()) {
            addCartCommon(memberIdx, newCarts, CartType.DEFAULT);
        }
    }


    //[바로 구매하기] 상품 추가 후 암호화 코드 반환 cartTpye 설정해야함
    @Transactional
    public String addCartForPurchase(Long memberIdx, List<AddCartReq> reqs) throws Exception {
        List<Long> cartIdxList = addCartCommon(memberIdx, reqs, CartType.DIRECT_PURCHASE);
        String encrypt = aesUtil.encrypt(serializeCartIdxList(cartIdxList));
        return Base64.getUrlEncoder().encodeToString(encrypt.getBytes());
    }

    //장바구니 추가 공통 컴포넌트
    @Transactional
    public List<Long> addCartCommon(Long memberIdx, List<AddCartReq> reqs, CartType cartType) throws BaseException {
        Member member = memberRepository.findById(memberIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        List<Long> cartIdxList = new ArrayList<>();

        for (AddCartReq req : reqs) {
            Product product = productRepository.findById(req.getProductIdx()).orElseThrow(() ->
                    new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

            //먼저 카트에 저장하고
            Integer price = product.getPrice();
            Cart cart = cartRepository.save(req.toEntity(member, product, price, cartType));
            cartIdxList.add(cart.getIdx());

            for (AddCartOption option : req.getAddCartOptions()) {
                ProductMajorOptions majorOption
                        = majorOptionsRepository.findById(option.getMajorOption()).orElseThrow(() ->
                        new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT_MAJOR_OPTIONS));

                ProductSubOptions subOption
                        = subOptionsRepository.findById(option.getSubOption()).orElseThrow(() ->
                        new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT_SUB_OPTIONS));

                price += subOption.getAddPrice();
                optionInCartRepository.save(OptionInCart
                        .builder()
                        .cart(cart)
                        .majorOption(majorOption)
                        .subOption(subOption)
                        .build());
            }

            //옵션별 추가 가격 계산한 가격을 업데이트
            cart.updatePrice(price);
        }
        return cartIdxList;
    }

    //복호화 후 해당 cartIdx 리스트로 목록 반환
    @Transactional
    public CartRes getCartByEncrypt(String encrypt, Long idx) throws Exception {

        byte[] decodedBytes = Base64.getUrlDecoder().decode(encrypt);
        String decodedValue = new String(decodedBytes, StandardCharsets.UTF_8);
        String decrypt = aesUtil.decrypt(decodedValue);
        Type listType = new TypeToken<List<Long>>() {
        }.getType();
        List<Long> list = gson.fromJson(decrypt, listType);

        return getCart(new CartListReq(list), idx);
    }


    //목록 반환
    @Transactional
    public CartRes getCart(CartListReq req, Long userIdx) {
        List<CartDTO> cartList;

        if (req.getCartIdxList() == null) {
            cartList = cartRepository.findByUserIdx(userIdx, CartType.DEFAULT);
        } else {
            cartList = cartRepository.findByUserIdxAndCartIdx(userIdx, req.getCartIdxList());
        }

        Map<Long, AtelierListRes> atelierList = new HashMap<>();

        for (CartDTO dto : cartList) {
            //공방 별로 각각 저장
            AtelierListRes atelierListRes
                    = atelierList.computeIfAbsent(dto.getAtelierIdx(), idx ->
                    AtelierListRes
                            .builder()
                            .atelierIdx(dto.getAtelierIdx())
                            .atelierName(dto.getAtelierName())
                            .productList(new ArrayList<>())
                            .build()
            );

            //공방의 상품을 저장
            CartProductListRes cartProductListRes
                    = atelierListRes.getProductList().stream()
                    .filter(p ->
                            p.getProductIdx().equals(dto.getProductIdx()))
                    .findFirst()
                    .orElse(null);

            if (cartProductListRes == null) {
                cartProductListRes = CartProductListRes
                        .builder()
                        .productName(dto.getProductName())
                        .productIdx(dto.getProductIdx())
                        .productUrl(dto.getProductUrl())
                        .optionList(new ArrayList<>())
                        .build();
                atelierListRes.getProductList().add(cartProductListRes);
            }


            OptionListRes optionList = cartProductListRes.getOptionList().stream()
                    .filter(option -> option.getCartIdx().equals(dto.getCartIdx()))
                    .findFirst()
                    .orElse(OptionListRes.builder()
                            .cartIdx(dto.getCartIdx())
                            .orderMessage(dto.getOrderMessage())
                            .price(dto.getPrice())
                            .count(dto.getCount())
                            .subOptionsList(new ArrayList<>())
                            .build());

            SubOptionsRes subOption = SubOptionsRes.builder()
                    .majorOptionName(dto.getMajorOptionName())
                    .majorOptionIdx(dto.getMajorOptionIdx())
                    .subOptionIdx(dto.getSubOptionIdx())
                    .subOptionName(dto.getSubOptionName())
                    .build();

            optionList.getSubOptionsList().add(subOption);
            if (!cartProductListRes.getOptionList().contains(optionList)) {
                cartProductListRes.getOptionList().add(optionList);
            }
        }
        return new CartRes(new ArrayList<>(atelierList.values().stream().toList()));
    }

    //수량 변경
    @Transactional
    public void updateCount(UpdateCartCountReq req) throws BaseException {
        Cart cart = cartRepository.findById(req.getCartIdx()).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_CART));
        cart.updateCount(req.getCount());
    }

    //장바구니 검증
    @Transactional
    public void verifyProduct(VerifyCartReq req) throws BaseException {

        List<Cart> cartsByProductIdx = cartRepository.getCartsByProductIdx(req.getProductIdx());
        for (Cart cart : cartsByProductIdx) {
            //장바구니 검증
            List<OptionInCart> optionList = optionInCartRepository.findByCartIdx(cart.getIdx());

            // 상품 검증
            productRepository.findById(cart.getProduct().getIdx()).orElseThrow(() ->
                    new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));
            // TODO cart에 담긴 createdAt, modifiedAt 보다 subOption의 modifiedAt이 느리면 상품 정보 변경 aler

            // 재고 검증
            for (OptionInCart option : optionList) {
                Optional<ProductSubOptions> byId = subOptionsRepository.findById(option.getSubOption().getIdx());
                if (byId.isEmpty()) {
                    throw new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT_SUB_OPTIONS);
                }
                ProductSubOptions productSubOptions = byId.get();
                if (productSubOptions.getInventory() < option.getSubOption().getInventory()) {
                    throw new BaseException(BaseResponseStatus.OUT_OF_STOCK);
                }
            }
        }
    }

    //요청 메세지 저장
    @Transactional
    public void saveOrderMessage(orderMessageReq req, Long idx) throws BaseException {

        if (!memberRepository.existsById(idx)) {
            throw new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER);
        }
        List<Long> cartList = req.getCartIdx();
        for (Long i : cartList) {
            Cart cart = cartRepository.findById(i).orElseThrow(() ->
                    new BaseException(BaseResponseStatus.NOT_FOUND_CART));
            cart.updateOrderMessage(req.getMessage());
            cartRepository.save(cart);
        }
    }

    @Transactional
    public void deleteCartList(deleteCartListReq req, Long idx) {
        deleteCartListCommon(req.getCartIdx());

    }

    @Transactional
    public void deleteCartListDirect(deleteCartListDirectReq req, Long idx) throws Exception {
        String encrypt = req.getEncrypt();
        byte[] decodedBytes = Base64.getUrlDecoder().decode(encrypt);
        String decodedValue = new String(decodedBytes, StandardCharsets.UTF_8);
        String decrypt = aesUtil.decrypt(decodedValue);
        Type listType = new TypeToken<List<Long>>() {
        }.getType();
        List<Long> list = gson.fromJson(decrypt, listType);
        deleteCartListCommon(list);
    }


    public void deleteCartListCommon(List<Long> cartList) {
        optionInCartRepository.deleteAllByCartIdx(cartList);
        cartRepository.deleteByCartIdxList(cartList);
    }
}
