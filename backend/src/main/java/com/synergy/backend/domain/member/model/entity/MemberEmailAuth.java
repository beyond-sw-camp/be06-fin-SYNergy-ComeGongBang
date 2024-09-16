package com.synergy.backend.domain.member.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member_email_auth")
@NoArgsConstructor
public class MemberEmailAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String uuid;
    private String email;

    @Builder
    public MemberEmailAuth(String uuid, String email) {
        this.uuid = uuid;
        this.email = email;
    }

    public void changeUuid(String uuid) {
        this.uuid = uuid;
    }
}