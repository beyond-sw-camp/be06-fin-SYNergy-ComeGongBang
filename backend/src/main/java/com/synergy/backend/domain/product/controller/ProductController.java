package com.synergy.backend.domain.product.controller;

import com.synergy.backend.domain.product.model.response.ProductInfoRes;
import com.synergy.backend.domain.product.service.ProductService;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<List<ProductListRes>> search(Long categoryIdx, Integer page, Integer size){
        List<ProductListRes> result = productService.search(categoryIdx, page, size);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/search/hashtag")
    public ResponseEntity<List<ProductListRes>> searchHashTag(Long hashtagIdx, Integer page, Integer size){
        List<ProductListRes> result = productService.searchHashTag(hashtagIdx, page, size);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/detail/{productIdx}")
    public BaseResponse<ProductInfoRes> getProductInfo(@PathVariable Long productIdx, @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        Long memberIdx = customUserDetails.getIdx();
        System.out.println(productIdx);
        System.out.println(memberIdx);

        ProductInfoRes result = productService.getProductInfo(productIdx, memberIdx);

        return new BaseResponse<>(result);
    }
}
