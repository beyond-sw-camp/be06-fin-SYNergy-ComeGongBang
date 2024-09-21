package com.synergy.backend.domain.orders.service;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.model.entity.Cart;
import com.synergy.backend.domain.orders.model.entity.OptionInCart;
import com.synergy.backend.domain.orders.model.request.*;
import com.synergy.backend.domain.orders.model.response.*;
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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional
    public void addCart(Long idx, AddCartReq req) throws BaseException {


        Member member = memberRepository.findById(idx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_USER));
        Product product = productRepository.findById(req.getProductIdx()).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));


        //먼저 카트에 저장하고
        Cart cart = cartRepository.save(req.toEntity(member, product));

        Integer price = req.getPrice();
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

    @Transactional
    public void updateCount(UpdateCartCountReq req) throws BaseException {
        Cart cart = cartRepository.findById(req.getCartIdx()).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_CART));
        cart.updateCount(req.getCount());
    }

    @Transactional
    public CartRes getCart(CartListReq req, Long userIdx) {
        List<CartDTO> cartList;

        if (req.getCartIdxList() == null) {
            cartList = cartRepository.findByUserIdx(userIdx);
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
            ProductListRes productListRes
                    = atelierListRes.getProductList().stream()
                    .filter(p ->
                            p.getProductIdx().equals(dto.getProductIdx()))
                    .findFirst()
                    .orElse(null);

            if (productListRes == null) {
                productListRes = ProductListRes
                        .builder()
                        .productName(dto.getProductName())
                        .productIdx(dto.getProductIdx())
                        .optionList(new ArrayList<>())
                        .build();
                atelierListRes.getProductList().add(productListRes);
            }


            OptionListRes optionList = productListRes.getOptionList().stream()
                    .filter(option -> option.getCartIdx().equals(dto.getCartIdx()))
                    .findFirst()
                    .orElse(OptionListRes.builder()
                            .cartIdx(dto.getCartIdx())
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
            if (!productListRes.getOptionList().contains(optionList)) {
                productListRes.getOptionList().add(optionList);
            }
        }

        CartRes cartRes = new CartRes(new ArrayList<>(atelierList.values().stream().toList()));
        return cartRes;
    }


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

    @Transactional
    public void saveOrderMessage(orderMessageReq req, Long idx) throws BaseException {

        if (!memberRepository.existsById(idx)) {
            throw new BaseException(BaseResponseStatus.NOT_FOUND_USER);
        }
        Cart cart = cartRepository.findById(req.getCartIdx()).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_CART));

        cart.updateOrderMessage(req.getMessage());
        cartRepository.save(cart);
    }
}
