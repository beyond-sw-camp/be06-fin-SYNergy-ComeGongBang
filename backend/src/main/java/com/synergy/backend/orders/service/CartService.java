package com.synergy.backend.orders.service;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.member.repository.MemberRepository;
import com.synergy.backend.orders.model.entity.Cart;
import com.synergy.backend.orders.model.entity.OptionInCart;
import com.synergy.backend.orders.model.request.AddCartOption;
import com.synergy.backend.orders.model.request.AddCartReq;
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


}
