package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse;
import com.etiya.ecommercepair3.entities.concretes.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictDao extends JpaRepository<District,Integer> {

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse" +
            "(d.id,d.districtName,c.id) From District d join City c")
    List<ListDistrictResponse> getAll();

    @Query("Select new com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse" +
            "(d.id,d.districtName,c.id) From District d join City c where d.id=:id")
    DistrictDetailResponse getByDistrictId(Integer id);

}
