package com.synergy.backend.domain.atelier.repository;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.model.entity.AtelierProfileImages;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AtelierProfileImagesRepository extends JpaRepository<AtelierProfileImages, Long> {

    @Query("SELECT api.imageUrl "
            + "FROM AtelierProfileImages api "
            + "LEFT JOIN Atelier a ON api.atelier = a "
            + "WHERE api.atelier = :atelier")
    List<String> findAllByAtelier(Atelier atelier);
}