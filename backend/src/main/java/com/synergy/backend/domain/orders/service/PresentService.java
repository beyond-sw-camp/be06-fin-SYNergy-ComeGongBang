package com.synergy.backend.domain.orders.service;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.model.entity.Present;
import com.synergy.backend.domain.orders.model.response.PresentProductRes;
import com.synergy.backend.domain.orders.model.response.PresentRes;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import com.synergy.backend.domain.orders.repository.PresentRepository;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PresentService {
    private final PresentRepository presentRepository;
    private final OrderRepository orderRepository;
    
    public List<PresentRes> giveList(Member member){
        List<Present> results = presentRepository.findAllByFromMemberWithMember(member);
        List<PresentRes> presents = new ArrayList<>();

        for (Present present : results) {
            List<PresentProductRes> products = new ArrayList<>();

            List<Orders> orders = orderRepository.findAllByPresentIdxWithProductAndAtelier(present.getIdx());
            for (Orders order : orders) {
                products.add(PresentProductRes.builder()
                        .state(order.getDeliveryState())
                        .productIdx(order.getIdx())
                        .productName(order.getProduct().getName())
                        .atelierIdx(order.getProduct().getAtelier().getIdx())
                        .atelierName(order.getProduct().getAtelier().getName())
                        .imageUrl(order.getProduct().getThumbnailUrl())
                        .build());
            }

            presents.add(PresentRes.builder()
                    .member(present.getToMember().getNickname())
                    .count(orders.size())
                    .date(present.getCreatedAt())
                    .products(products)
                    .build()
            );
        }

        return presents;
    }

    public List<PresentRes> takeList(Member member){
        List<Present> results = presentRepository.findAllByToMember(member);
        List<PresentRes> presents = new ArrayList<>();

        for (Present present : results) {
            List<PresentProductRes> products = new ArrayList<>();

            List<Orders> orders = orderRepository.findAllByPresentIdxWithProductAndAtelier(present.getIdx());
            for (Orders order : orders) {
                products.add(PresentProductRes.builder()
                        .state(order.getDeliveryState())
                        .productIdx(order.getIdx())
                        .productName(order.getProduct().getName())
                        .atelierIdx(order.getProduct().getAtelier().getIdx())
                        .atelierName(order.getProduct().getAtelier().getName())
                        .imageUrl(order.getProduct().getThumbnailUrl())
                        .build());
            }

            presents.add(PresentRes.builder()
                    .member(present.getFromMember().getNickname())
                    .count(orders.size())
                    .date(present.getCreatedAt())
                    .products(products)
                    .build()
            );
        }

        return presents;
    }
}
