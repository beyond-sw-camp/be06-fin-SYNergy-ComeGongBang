package com.synergy.backend.global.security.jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

//TODO : 기존 RDB 방식 : 삭제
@Entity
@NoArgsConstructor
@Getter
public class BlackListToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String token;

    public BlackListToken(String token) {
        this.token = token;
    }
}
