package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CityService;
import com.etiya.ecommercepair3.business.abstracts.DistrictService;
import com.etiya.ecommercepair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.CityDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.ListCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.AddCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class CitiesController {
    private final CityService cityService;


    @GetMapping()
    public DataResult<Slice<ListCityResponse>> getAll(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return cityService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public DataResult<CityDetailResponse> getById(@PathVariable Integer id){
        return cityService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest){
        return cityService.addCity(addCityRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateCityResponse> updateCity(@RequestBody@Valid UpdateCityRequest updateCityRequest){
        return cityService.updateCity(updateCityRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteCity(@PathVariable Integer id){
        return cityService.deleteCity(id);
    }
}
