package com.erp.backend.repositories;

import com.erp.backend.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query("select od from OrderDetail od join  Order o on o.id = od.order.id where o.account.id = ?1")
    public List<OrderDetail> getOrderDetailByUser(long userId);

}
