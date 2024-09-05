package com.synergy.backend.member.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member_email_auth")
public class MemberEmailAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String uuid;
    private String email;
}