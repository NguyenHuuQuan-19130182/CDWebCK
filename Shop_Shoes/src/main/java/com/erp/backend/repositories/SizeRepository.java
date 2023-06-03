package com.erp.backend.repositories;

import com.erp.backend.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size,Long> {

    @Query("select s from Size s " +
            "join Product p on p.id = s.product.id" +
            " where  s.sizeId = ?1")
    public Size getSizeByProduct(long id);

    @Query("select s from Size s " +
            "join Product p on p.id = s.product.id" +
            " where  p.id = ?1")
    public List<Size> getAllSizeById(long id);


}
