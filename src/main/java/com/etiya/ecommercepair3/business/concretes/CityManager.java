package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CityService;
import com.etiya.ecommercepair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.AddCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.City;
import com.etiya.ecommercepair3.repositories.abstracts.CityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityManager implements CityService {
    private final CityDao cityDao;
    private final ModelMapperService modelMapperService;

    private final MessageSource messageSource;
    @Override
    public DataResult<Slice<ListCityResponse>> getAll(Pageable pageable) {
        return new SuccessDataResult<>(cityDao.getAll(pageable));
    }

    @Override
    public DataResult<CityDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(cityDao.getByCityId(id),
                messageSource.getMessage("categoryGetAll",null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest) {
        City city=modelMapperService.forRequest().map(addCityRequest,City.class);
        cityDao.save(city);
        AddCityResponse addCityResponse=modelMapperService.forResponse().map(city,AddCityResponse.class);
        return new SuccessDataResult<>(addCityResponse);
    }

    @Override
    public DataResult<UpdateCityResponse> updateCity(UpdateCityRequest updateCityRequest){
        // iş kuralı
        City city=modelMapperService.forRequest().map(updateCityRequest,City.class);
        city.setId(updateCityRequest.getId());
        cityDao.save(city);
        UpdateCityResponse updateCityResponse=modelMapperService.forResponse().map(city,UpdateCityResponse.class);
        return new SuccessDataResult<>(updateCityResponse);
    }

    @Override
    public Result deleteCity(Integer id){
        cityDao.deleteById(id);
        return new SuccessResult("X");
    }
}
