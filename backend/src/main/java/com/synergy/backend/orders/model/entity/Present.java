package com.synergy.backend.orders.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import com.synergy.backend.member.model.entity.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "present")
public class Present extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String message;
    private String address;
    private String addressDetail;

    @ManyToOne
    @JoinColumn(name = "from_member_idx")
    private Member fromMember;

    @ManyToOne
    @JoinColumn(name = "to_member_idx")
    private Member toMember;

    @ManyToOne
    @JoinColumn(name = "order_idx")
    private Orders order;

}
