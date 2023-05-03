package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.supplier.ListSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.SupplierDetailResponse;
import com.etiya.ecommercepair3.entities.concretes.Supplier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierDao extends JpaRepository<Supplier,Integer> {

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.supplier.ListSupplierResponse" +
            "(s.id,s.name) from  Supplier s ")
    Slice<ListSupplierResponse> getAll(Pageable pageable);

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.supplier.SupplierDetailResponse" +
            "(s.id,s.name) from  Supplier s where  s.id=:id")
    SupplierDetailResponse getBySupplierId(Integer id);
}
