package com.synergy.backend.hashtag.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hashtag")
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
}