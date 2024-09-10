package com.synergy.backend.orders.service;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.member.repository.MemberRepository;
import com.synergy.backend.orders.model.entity.Cart;
import com.synergy.backend.orders.model.entity.OptionInCart;
import com.synergy.backend.orders.model.request.AddCartOption;
import com.synergy.backend.orders.model.request.AddCartReq;
import com.synergy.backend.orders.model.response.*;
import com.synergy.backend.orders.repository.CartRepository;
import com.synergy.backend.orders.repository.OptionInCartRepository;
import com.synergy.backend.product.model.entity.Product;
import com.synergy.backend.product.model.entity.ProductMajorOptions;
import com.synergy.backend.product.model.entity.ProductSubOptions;
import com.synergy.backend.product.repository.ProductMajorOptionsRepository;
import com.synergy.backend.product.repository.ProductRepository;
import com.synergy.backend.product.repository.ProductSubOptionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Transactional
    public void addCart(Long idx, AddCartReq req) throws BaseException {


        Member member = memberRepository.findById(idx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_USER));
        Product product = productRepository.findById(req.getProductIdx()).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

        //먼저 카트에 저장하고
        Cart cart = cartRepository.save(req.toEntity(member, product));
        //해당 상품의 옵션 저장, 옵션이 동일하면 수량 증가


        for (AddCartOption option : req.getAddCartOptions()) {
            ProductMajorOptions majorOption
                    = majorOptionsRepository.findById(option.getMajorOption()).orElseThrow(() ->
                    new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT_MAJOR_OPTIONS));

            ProductSubOptions subOption
                    = subOptionsRepository.findById(option.getSubOption()).orElseThrow(() ->
                    new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT_SUB_OPTIONS));

            optionInCartRepository.save(OptionInCart
                    .builder()
                    .cart(cart)
                    .majorOption(majorOption)
                    .subOption(subOption)
                    .build());
        }
    }

    @Transactional
    public void increase(Long cartIdx) throws BaseException {
        Cart cart = cartRepository.findById(cartIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_CART));
        cart.increase();
    }

    @Transactional
    public void decrease(Long cartIdx) throws BaseException {
        Cart cart = cartRepository.findById(cartIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_CART));
        cart.decrease();
    }


    @Transactional
    public CartRes getCart(Long userIdx) {

        List<CartDTO> cartList = cartRepository.findByUserIdx(userIdx);
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
            System.out.println(atelierListRes);
            //공방의 상품을 저장

            ProductListRes productListRes
                    = atelierListRes.getProductList().stream()
                    .filter(p ->
                            p.getProductIdx().equals(dto.getProductIdx()))
                    .findFirst()
                    .orElse(null);

            if (productListRes == null) {
                productListRes = ProductListRes
                        .builder()
                        .price(dto.getPrice())
                        .count(dto.getCount())
                        .productName(dto.getProductName())
                        .productIdx(dto.getProductIdx())
                        .optionList(new ArrayList<>())
                        .build();
                atelierListRes.getProductList().add(productListRes);
            }


            OptionListRes optionList = OptionListRes.builder()
                    .optionsList(new ArrayList<>())
                    .build();

            productListRes.getOptionList().add(optionList);

            SubOptionsRes subOption = SubOptionsRes.builder()
                    .majorOptionName(dto.getMajorOptionIdx())
                    .majorOptionIdx(dto.getMajorOptionIdx())
                    .subOptionIdx(dto.getSubOptionIdx())
                    .subOptionName(dto.getSubOptionIdx())
                    .build();

            optionList.getOptionsList().add(subOption);
        }

        CartRes cartRes = new CartRes(new ArrayList<>(atelierList.values().stream().toList()));
        return cartRes;
    }




}
