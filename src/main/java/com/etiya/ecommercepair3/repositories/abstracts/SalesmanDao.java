package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.salesman.ListSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.SalesmanDetailResponse;
import com.etiya.ecommercepair3.entities.concretes.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesmanDao extends JpaRepository<Salesman,Integer> {

    @Query("SELECT new com.etiya.ecommercepair3.business.dtos.responses.salesman.ListSalesmanResponse" +
            "(s.id,s.name) from Salesman s")
    List<ListSalesmanResponse> getAll();

    @Query("SELECT new com.etiya.ecommercepair3.business.dtos.responses.salesman.SalesmanDetailResponse" +
            "(s.id,s.name) from Salesman s where s.id=:id")
    SalesmanDetailResponse getBySalesmanId(Integer id);
}
