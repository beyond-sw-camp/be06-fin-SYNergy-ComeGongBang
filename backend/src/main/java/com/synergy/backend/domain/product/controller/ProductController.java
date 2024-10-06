package com.synergy.backend.domain.product.controller;

import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.request.CategoryProductListReq;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<List<ProductListRes>> search(String keyword, Integer page, Integer size){
        List<ProductListRes> result = productService.search(keyword, page, size);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/search/category")
    public BaseResponse<List<ProductListRes>> searchCategory(@RequestBody CategoryProductListReq req, @AuthenticationPrincipal CustomUserDetails customUserDetails){
        Long memberIdx = null;
        if(customUserDetails!=null){
            memberIdx = customUserDetails.getIdx();
        }
        List<ProductListRes> result = productService.searchCategory(req, memberIdx);
        return new BaseResponse<>(result);
    }
    @GetMapping("/search/hashtag")
    public BaseResponse<List<ProductListRes>> searchHashTag(Long hashtagIdx,@AuthenticationPrincipal CustomUserDetails customUserDetails, Integer page, Integer size){
        Long memberIdx = null;
        if(customUserDetails!=null){
            memberIdx = customUserDetails.getIdx();
        }
        List<ProductListRes> result = productService.searchHashTag(hashtagIdx,memberIdx, page, size);
        return new BaseResponse<>(result);
    }
    @GetMapping("/detail/{productIdx}")
    public BaseResponse<ProductInfoRes> getProductInfo(@PathVariable Long productIdx, @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        Long memberIdx = null;
        if(customUserDetails!=null){
            memberIdx = customUserDetails.getIdx();
        }

        ProductInfoRes result = productService.getProductInfo(productIdx, memberIdx);

        return new BaseResponse<>(result);
    }
}
