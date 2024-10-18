package com.synergy.backend.domain.product.controller;

import com.synergy.backend.domain.product.model.response.ProductListRes;
import com.synergy.backend.domain.product.service.ElasticProductService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.security.CustomUserDetails;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/elastic")
public class ElasticProductController {

    private final ElasticProductService elasticProductService;

    @GetMapping("/search/multimatch")
    public BaseResponse<List<ProductListRes>> searchByMultiMatch(String query, @AuthenticationPrincipal
                                                                 CustomUserDetails customUserDetails) throws IOException {
        Long memberIdx = null;
        if(customUserDetails!=null){
            memberIdx=customUserDetails.getIdx();
        }
        return new BaseResponse<>(elasticProductService.search(query, memberIdx));
    }


}
