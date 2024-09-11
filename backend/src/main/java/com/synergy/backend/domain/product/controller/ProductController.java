package com.synergy.backend.domain.product.controller;

import com.synergy.backend.domain.product.service.ProductService;
import com.synergy.backend.domain.product.model.dto.response.SearchProductRes;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<List<SearchProductRes>> search(Long categoryIdx, Integer page, Integer size){
        List<SearchProductRes> result = productService.search(categoryIdx, page, size);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/search/hashtag")
    public ResponseEntity<List<SearchProductRes>> searchHashTag(Long hashtagIdx, Integer page, Integer size){
        List<SearchProductRes> result = productService.searchHashTag(hashtagIdx, page, size);
        return ResponseEntity.ok(result);
    }
}
