package com.etiya.ecommercepair3.repositories.abstracts;


import com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailResponse;
import com.etiya.ecommercepair3.entities.concretes.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StreetDao extends JpaRepository<Street,Integer> {

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse" +
            "(s.id,s.streetName,d.id) From Street s join District d")
    List<ListStreetResponse> getAll();

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailResponse" +
            "(s.id,s.streetName,d.id) From Street s join District d  where s.id=:id")
    StreetDetailResponse getByStreetId(Integer id);

    @Query("SELECT s FROM Street s")
    List<Street> findAllBySupplier();
}
