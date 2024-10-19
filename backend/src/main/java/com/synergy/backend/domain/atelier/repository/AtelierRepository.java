package com.synergy.backend.domain.atelier.repository;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Long> {

    @Query("SELECT new com.synergy.backend.domain.product.model.response.ProductListRes( " +
            "p.idx, " +
            "p.name, " +
            "p.price, " +
            "p.thumbnailUrl, " +
            "p.averageScore, " +
            "p.atelier.name, " +
            "p.onSalePercent, " +
            "(CASE WHEN :memberIdx IS NOT NULL AND l IS NOT NULL THEN true ELSE false END), " +
            "(SELECT COUNT(lk) FROM Likes lk WHERE lk.product.idx = p.idx) " +
            ") " +
            "FROM Product p " +
            "LEFT JOIN Likes l ON p.idx = l.product.idx AND l.member.idx = :memberIdx " +
            "WHERE p.atelier.idx = :atelierIdx")
    List<ProductListRes> findAllProductsByAtelier(Long atelierIdx, Long memberIdx);
}
