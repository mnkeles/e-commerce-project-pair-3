package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    @Query("SELECT c FROM Category c")
    List<Category> findAllByCategory();

    @Query("SELECT c.name  FROM Category c ")
    List<Category> getAllCategoryNameByCategory();

    Category getById(Integer id);
    Category getByName(String name);

}
