package com.synergy.backend.domain.orders.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import com.synergy.backend.domain.member.model.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "present")
@Getter
public class Present extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String message;
    private String address;
    private String addressDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_member_idx")
    private Member fromMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_member_idx")
    private Member toMember;

//    @ManyToOne
//    @JoinColumn(name = "order_idx")
//    private Orders order;

}
