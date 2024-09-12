package com.synergy.backend.domain.atelier.repository;


import com.synergy.backend.domain.atelier.model.entity.Atelier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Long> {
}
