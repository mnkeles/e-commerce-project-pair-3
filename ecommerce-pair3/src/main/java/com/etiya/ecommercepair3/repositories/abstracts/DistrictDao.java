package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse;
import com.etiya.ecommercepair3.entities.concrete.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictDao extends JpaRepository<District,Integer> {

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse" +
            "(d.id,d.districtName,d.city.id) From District d")
    List<ListDistrictResponse> getAll();

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse" +
            "(d.id,d.districtName,d.city.id) From District d where d.id=:id")
    DistrictDetailResponse getByDistrictId(Integer id);

    @Query("SELECT d FROM District d")
    List<District> findAllByDistrict();
}
