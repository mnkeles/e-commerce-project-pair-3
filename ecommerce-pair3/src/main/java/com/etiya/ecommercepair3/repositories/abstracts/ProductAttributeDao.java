package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductAttributeDao extends JpaRepository<ProductAttribute,Integer> {
    @Query("SELECT pa FROM ProductAttribute pa")
    List<ProductAttribute> findAllByProductAttribute();
}
