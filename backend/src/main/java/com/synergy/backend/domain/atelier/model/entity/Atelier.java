package com.synergy.backend.domain.atelier.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String profileImage;
    private String name;
    @Setter
    private Double averageScore;
    @Setter
    private int havingProductsReviewCount;
    @Setter
    private int havingProductsLikeCount;
    private Integer havingFollowerCount;
    private String oneLineDescription;

    // 공방 주소 (보류)
    private String address;
    private String addressDetail;

    // 공방 프로필 (보류)
    private String title;
    private String content;

    //공방 팔로우 수 카운트
    public void increaseFollowCount(){
        this.havingFollowerCount++;
    }

    public void decreaseFollowCount(){
        this.havingFollowerCount--;
    }


    //공방 찜하기 수 카운트
    public void increaseLikedCount(){
        this.havingProductsLikeCount++;
    }

    public void decreaseLikedCount(){
        if(this.havingProductsLikeCount != 0){
            this.havingProductsLikeCount--;
        }
    }
}