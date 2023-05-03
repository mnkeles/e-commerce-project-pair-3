package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.AddCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CityService {
    DataResult<Slice<ListCityResponse>> getAll(Pageable pageable);
    DataResult<CityDetailResponse> getById(Integer id);
    DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest);

    DataResult<UpdateCityResponse> updateCity(UpdateCityRequest updateCityRequest);

    Result deleteCity(Integer id);
}
