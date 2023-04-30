package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.StreetService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.ListStreetResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.StreetDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.street.UpdateStreetResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.street.AddStreetRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.street.UpdateStreetRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/street")
@RequiredArgsConstructor
public class StreetsController {
    private final StreetService streetService;

    @GetMapping()
    public DataResult<List<ListStreetResponse>> getAll(){
        return streetService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<StreetDetailResponse> getById(@PathVariable Integer id){
        return streetService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddStreetResponse> addStreet(AddStreetRequest addStreetRequest){
        return streetService.addStreet(addStreetRequest);
    }
    @PutMapping("/update")
    private DataResult<UpdateStreetResponse> updateStreet(@RequestBody@Valid UpdateStreetRequest updateStreetRequest){
        return streetService.updateStreet(updateStreetRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteStreet(@PathVariable Integer id){
        return streetService.deleteStreet(id);
    }
}
