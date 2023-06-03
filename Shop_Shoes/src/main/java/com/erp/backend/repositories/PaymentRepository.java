package com.erp.backend.repositories;

import com.erp.backend.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentMethod,Long> {
    Optional<PaymentMethod> findByName(String name);
}
