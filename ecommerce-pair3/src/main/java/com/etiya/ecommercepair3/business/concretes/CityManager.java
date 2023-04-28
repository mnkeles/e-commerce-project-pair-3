package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CityService;
import com.etiya.ecommercepair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.AddCityRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.entities.concrete.City;
import com.etiya.ecommercepair3.entities.concrete.Country;
import com.etiya.ecommercepair3.repositories.abstracts.CityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityManager implements CityService {
    private final CityDao cityDao;
    private final ModelMapperService modelMapperService;
    @Override
    public List<ListCityResponse> getAll() {
        return cityDao.getAll();
    }

    @Override
    public CityDetailResponse getById(Integer id) {
        return cityDao.getByCityId(id);
    }

    @Override
    public AddCityResponse addCity(AddCityRequest addCityRequest) {
        City city=modelMapperService.forRequest().map(addCityRequest,City.class);
        cityDao.save(city);
        AddCityResponse addCityResponse=modelMapperService.forResponse().map(city,AddCityResponse.class);
        return addCityResponse;
    }
}
