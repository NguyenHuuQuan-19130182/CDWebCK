package com.erp.backend.repositories;

import com.erp.backend.entities.Cart;
import com.erp.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("select  c from Cart c where  c.user.id =?1")
    public List<Cart> findByUser(long id);

//    @Modifying
//    @Query("update Cart  c set c.quantity = :quantity where c.id = :id")
//    public void updateCart(long id,int quantity);

}
