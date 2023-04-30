package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.UpdateCountryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.category.AddCategoryRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.country.AddCountryRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.country.UpdateCountryRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

import java.util.List;

public interface CountryService {

    DataResult<List<ListCountryResponse>> getAll();

    DataResult<CountryDetailResponse> getById(Integer id);

    DataResult<AddCountryResponse> addCountry(AddCountryRequest addCountryRequest);

    DataResult<UpdateCountryResponse> updateCountry(UpdateCountryRequest updateCountryRequest);

    Result deleteCountry(Integer id);
}
