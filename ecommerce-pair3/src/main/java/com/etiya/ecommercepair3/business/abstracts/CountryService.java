package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.category.AddCategoryRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.country.AddCountryRequest;

import java.util.List;

public interface CountryService {

    List<ListCountryResponse> getAll();

    CountryDetailResponse getById(Integer id);

    AddCountryResponse addCountry(AddCountryRequest addCountryRequest);
}
