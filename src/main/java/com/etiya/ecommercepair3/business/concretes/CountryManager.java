package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CountryService;
import com.etiya.ecommercepair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.UpdateCountryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.country.AddCountryRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.country.UpdateCountryRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Country;
import com.etiya.ecommercepair3.repositories.abstracts.CountryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryManager implements CountryService {

    private final CountryDao countryDao;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ListCountryResponse>> getAll() {
        return new SuccessDataResult<>(countryDao.getAll());
    }

    @Override
    public DataResult<CountryDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(countryDao.getByCountryId(id));
    }

    @Override
    public DataResult<AddCountryResponse> addCountry(AddCountryRequest addCountryRequest) {
        //iş kuralı

        Country country=modelMapperService.forRequest().map(addCountryRequest,Country.class);
        countryDao.save(country);
        AddCountryResponse addCountryResponse=modelMapperService.forResponse().map(country,AddCountryResponse.class);

        return new SuccessDataResult<>(addCountryResponse);
    }

    @Override
    public DataResult<UpdateCountryResponse> updateCountry(UpdateCountryRequest updateCountryRequest){
        // iş kuralı
        Country country=modelMapperService.forRequest().map(updateCountryRequest,Country.class);
        country.setId(updateCountryRequest.getId());
        countryDao.save(country);
        UpdateCountryResponse updateCountryResponse=modelMapperService.forResponse().map(country,UpdateCountryResponse.class);
        return new SuccessDataResult<>(updateCountryResponse);
    }

    @Override
    public Result deleteCountry(Integer id){
        countryDao.deleteById(id);
        return new SuccessResult("X");
    }
}
