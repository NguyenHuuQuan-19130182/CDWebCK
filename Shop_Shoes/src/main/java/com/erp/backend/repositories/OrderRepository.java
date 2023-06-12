package com.erp.backend.repositories;

import com.erp.backend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("select  o from Order o where o.account.id = ?1")
    public List<Order> getOrderByUser(Long id);

    @Query("select  o from Order o where o.state =?1")
    List<Order> getOrderByState(String state);

}
