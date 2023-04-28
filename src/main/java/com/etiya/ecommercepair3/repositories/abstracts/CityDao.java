package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercepair3.entities.concrete.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityDao extends JpaRepository<City,Integer> {

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse" +
            "(c.id,c.cityName,c.country.id) From City  c")
    List<ListCityResponse> getAll();

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse" +
            "(c.id,c.cityName,c.country.id) From City c where c.id=:id")
    CityDetailResponse getByCityId(Integer id);


    @Query("SELECT c FROM City c")
    List<City> findAllByCity();
}
