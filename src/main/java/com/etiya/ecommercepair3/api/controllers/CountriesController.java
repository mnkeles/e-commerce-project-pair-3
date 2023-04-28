package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CountryService;
import com.etiya.ecommercepair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.CountryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.country.ListCountryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.country.AddCountryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountriesController {
    private final CountryService countryService;

    @GetMapping()
    public List<ListCountryResponse> getAll(){
        return countryService.getAll();
    }

    @GetMapping("{id}")
    public CountryDetailResponse getById(@PathVariable Integer id){
        return countryService.getById(id);
    }

    @PostMapping("/add")
    public AddCountryResponse addCountry(AddCountryRequest addCountryRequest){
        return countryService.addCountry(addCountryRequest);
    }

}
