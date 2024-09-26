package com.synergy.backend.domain.orders.service;

import com.synergy.backend.domain.orders.model.request.AddCartReq;
import com.synergy.backend.domain.orders.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddCartStrategyWithDuplication implements AddCartStrategy {

    // 중복 확인
    // 중복 아님 -> 수량 증가
    // 중복  -> 리스트에 담아 addCartCommon

    private final CartService cartService;
    private final CartRepository cartRepository;

    @Override
    public List<Long> addCart(Long memberIdx, List<AddCartReq> reqs) {

        for (AddCartReq req : reqs) {
            if (cartRepository.existsByProductIdxAndMemberIdxAndOptionSummary(
                    memberIdx, req.getProductIdx(), req.getOptionSummary())) {


            }
        }


        return;
    }
}
