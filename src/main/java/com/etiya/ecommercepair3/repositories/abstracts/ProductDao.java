package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercepair3.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.product.ListProductResponse" +
            "(p.id,p.productName,p.unitPrice,p.unitsInStock,pa.id) From Product  p join ProductAttribute pa ")
    List<ListProductResponse> getAll();

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.product.ProductDetailResponse" +
            "(p.id,p.productName,p.unitPrice,p.unitsInStock,pa.id) From Product p join ProductAttribute pa" +
            " where p.id=:id")
    ProductDetailResponse getByProductId(Integer id);
    @Query("SELECT p FROM Product p")
    List<Product> findAllByProduct();
}
