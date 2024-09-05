package com.synergy.backend.atelier.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
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