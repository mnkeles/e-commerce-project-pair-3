package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercepair3.entities.concrete.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    @Query("SELECT c FROM Category c")
    List<Category> findAllByCategory();

    @Query("SELECT c.name  FROM Category c ")
    List<Category> getAllCategoryNameByCategory();

    @Query(value="Select new com.etiya.ecommercepair3.business.dtos.responses.category.ListCategoryResponse" +
            "(c.id,c.name) From Category c" ,nativeQuery = false)
    List<ListCategoryResponse> getAll();

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.category.CategoryDetailResponse" +
            "(c.id,c.name) from Category c where c.id=:id")
    CategoryDetailResponse getByCategoryId(Integer id);

}
