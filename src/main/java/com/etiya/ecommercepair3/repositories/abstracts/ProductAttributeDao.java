package com.etiya.ecommercepair3.repositories.abstracts;


import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ListProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ProductAttributeDetailResponse;
import com.etiya.ecommercepair3.entities.concretes.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductAttributeDao extends JpaRepository<ProductAttribute,Integer> {

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ListProductAttributeResponse" +
            "(p.id,p.genderType,p.sizeType,p.colorType) from ProductAttribute p")
    List<ListProductAttributeResponse> getAll();

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ProductAttributeDetailResponse" +
            "(p.id,p.genderType,p.sizeType,p.colorType) from ProductAttribute p where p.id=:id")
    ProductAttributeDetailResponse getByProductAttributeId(Integer id);
}
