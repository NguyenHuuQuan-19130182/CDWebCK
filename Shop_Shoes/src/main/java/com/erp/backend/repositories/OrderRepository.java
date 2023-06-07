package com.erp.backend.repositories;

import com.erp.backend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("select  o from Order o join ShippingInfo s on s.id = o.shippingInfo.id where o.id = ?1")
    public Order getOrderById(long id);

}
