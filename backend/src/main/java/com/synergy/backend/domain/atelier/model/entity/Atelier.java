package com.synergy.backend.domain.atelier.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "atelier")
public class Atelier extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    private String oneLineDescription;
    private String address;
    private String addressDetail;
    private Integer follower;
    private String title;
    private String content;
    private String profileImage;

}