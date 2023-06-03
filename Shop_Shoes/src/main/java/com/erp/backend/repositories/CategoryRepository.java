package com.erp.backend.repositories;

import com.erp.backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c where c.id_category = ?1")
    public Category getCategoryById(long id);
    Optional<Category> findByName(String name);

    @Query("select u from Category  u where  u.parent_id =?1")
    public List<Category> findByParentId(int parentId);

}
