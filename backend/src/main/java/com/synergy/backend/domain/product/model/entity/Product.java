package com.synergy.backend.domain.product.model.entity;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.hashtag.model.entity.ProductHashtag;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

@Entity
@Getter
@Table(name = "product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atelier_idx")
    private Atelier atelier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_idx")
    private Category category;

    @Builder.Default
    @OneToMany(mappedBy = "product")
    List<ProductHashtag> productHashtagList = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    List<ProductImages> productImages = new ArrayList<>();

    private String name;
    private int price;
    private int onSalePercent;
    private String description;
    private String thumbnailUrl;
    private int deliveryFee;
    private String type;
    private String expiration;
    private String manufacturing;
    private Double averageScore;
    @Setter
    private Boolean isMemberliked;
    @Setter
    private Integer likeCounts;

    //상품 찜하기 수 카운트
    public void increaseLikedCount() {
        this.likeCounts++;
    }
    public void decreaseLikedCount(){
        if(this.likeCounts != 0){
            this.likeCounts--;
        }
    }
    public void setIsMemberliked(){
        if(isMemberliked == null || isMemberliked == true){
            isMemberliked = false;
        } else isMemberliked = !isMemberliked;
    }
}
