package com.erp.backend.repositories;

import com.erp.backend.entities.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingInfo,Long> {
}
