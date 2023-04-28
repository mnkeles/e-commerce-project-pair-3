package com.etiya.ecommercepair3.repositories.abstracts;


import com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailsResponse;
import com.etiya.ecommercepair3.entities.concrete.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StreetDao extends JpaRepository<Street,Integer> {

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse" +
            "(s.id,s.streetName,s.district.id) From Street  s")
    List<ListStreetResponse> getAll();

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailsResponse" +
            "(s.id,s.streetName,s.district.id) From Street s where s.id=:id")
    StreetDetailsResponse getByStreetId(Integer id);

    @Query("SELECT s FROM Street s")
    List<Street> findAllBySupplier();
}
