package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CountryService;
import com.etiya.ecommercepair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.category.AddCategoryRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.country.AddCountryRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.entities.concrete.Country;
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
    public List<ListCountryResponse> getAll() {
        return countryDao.getAll();
    }

    @Override
    public CountryDetailResponse getById(Integer id) {
        return countryDao.getByCountryId(id);
    }

    @Override
    public AddCountryResponse addCountry(AddCountryRequest addCountryRequest) {
        //iş kuralı

        Country country=modelMapperService.forRequest().map(addCountryRequest,Country.class);
        countryDao.save(country);
        AddCountryResponse addCountryResponse=modelMapperService.forResponse().map(country,AddCountryResponse.class);


        /*
        Country country=new Country();
        country.setCountryName(addCountryRequest.getCountryName());
        countryDao.save(country);
        AddCountryResponse addCountryResponse=new AddCountryResponse(country.getId(), country.getCountryName());
         */



        return addCountryResponse;
    }
}
