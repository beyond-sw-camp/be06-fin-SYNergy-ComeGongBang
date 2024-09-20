package com.synergy.backend.domain.atelier.controller;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.service.AtelierService;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.exception.BaseException;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atelier")
public class AtelierController {
    private final AtelierService atelierService;

    @GetMapping("/products")
    public BaseResponse<List<ProductListRes>> atelierProductList(Long idx) throws BaseException {
        List<ProductListRes> result = atelierService.atelierProductList(idx);

        return new BaseResponse<>(result);
    }
}
