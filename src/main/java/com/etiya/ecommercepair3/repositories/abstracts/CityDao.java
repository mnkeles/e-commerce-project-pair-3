package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercepair3.entities.concretes.City;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityDao extends JpaRepository<City,Integer> {

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse" +
            "(c.id,c.cityName,co.id) From City  c join Country co")
    Slice<ListCityResponse> getAll(Pageable pageable);

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse" +
            "(c.id,c.cityName,co.id) From City c join Country co where c.id=:id")
    CityDetailResponse getByCityId(Integer id);
}
