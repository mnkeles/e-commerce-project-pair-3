package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercepair3.entities.concretes.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryDao extends JpaRepository<Country,Integer> {

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.country.ListCountryResponse" +
            "(c.id,c.countryName) From Country  c")
    List<ListCountryResponse> getAll();

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.country.CountryDetailResponse" +
            "(c.id,c.countryName) From Country c where c.id=:id")
    CountryDetailResponse getByCountryId(Integer id);
}
