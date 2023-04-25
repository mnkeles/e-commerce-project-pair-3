package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityDao extends JpaRepository<City,Integer> {
    @Query("SELECT c FROM City c")
    List<City> findAllByCity();
}
