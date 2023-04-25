package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.ProductSalesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductSalesmanDao extends JpaRepository<ProductSalesman,Integer> {
    @Query("SELECT ps FROM ProductSalesman ps")
    List<ProductSalesman> findAllByProductSalesman();
}
