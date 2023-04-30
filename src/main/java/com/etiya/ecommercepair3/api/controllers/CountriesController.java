package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CountryService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.UpdateCountryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.country.AddCountryRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.country.UpdateCountryRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountriesController {
    private final CountryService countryService;

    @GetMapping()
    public DataResult<List<ListCountryResponse>> getAll(){
        return countryService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<CountryDetailResponse> getById(@PathVariable Integer id){
        return countryService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddCountryResponse> addCountry(AddCountryRequest addCountryRequest){
        return countryService.addCountry(addCountryRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateCountryResponse> updateCountry(@RequestBody@Valid UpdateCountryRequest updateCountryRequest){
        return countryService.updateCountry(updateCountryRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteCountry(@PathVariable Integer id){
        return countryService.deleteCountry(id);
    }

}
