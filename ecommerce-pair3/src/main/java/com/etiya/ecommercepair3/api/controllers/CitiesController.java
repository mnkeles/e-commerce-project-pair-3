package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CityService;
import com.etiya.ecommercepair3.business.abstracts.DistrictService;
import com.etiya.ecommercepair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.AddDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.AddCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.district.AddDistrictRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class CitiesController {
    private final CityService cityService;


    @GetMapping()
    public List<ListCityResponse> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public CityDetailResponse getById(@PathVariable Integer id){
        return cityService.getById(id);
    }

    @PostMapping("/add")
    public AddCityResponse addCity(AddCityRequest addCityRequest){
        return cityService.addCity(addCityRequest);
    }
}
