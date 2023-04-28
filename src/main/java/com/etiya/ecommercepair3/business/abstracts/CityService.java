package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.AddCityRequest;

import java.util.List;

public interface CityService {
    List<ListCityResponse> getAll();
    CityDetailResponse getById(Integer id);
    AddCityResponse addCity(AddCityRequest addCityRequest);
}
