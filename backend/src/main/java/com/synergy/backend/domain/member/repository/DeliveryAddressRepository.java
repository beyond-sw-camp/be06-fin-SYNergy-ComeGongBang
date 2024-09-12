package com.synergy.backend.domain.member.repository;

import com.synergy.backend.domain.member.model.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {

    List<DeliveryAddress> getAllByMemberIdx(Long idx);
}
