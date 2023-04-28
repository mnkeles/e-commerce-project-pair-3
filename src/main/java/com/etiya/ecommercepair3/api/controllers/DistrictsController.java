package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.DistrictService;
import com.etiya.ecommercepair3.business.dtos.responses.district.AddDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.district.AddDistrictRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/district")
@RequiredArgsConstructor
public class DistrictsController {
    private final DistrictService districtService;

    @GetMapping()
    public List<ListDistrictResponse> getAll(){
        return districtService.getAll();
    }

    @GetMapping("/{id}")
    public DistrictDetailResponse getById(@PathVariable Integer id){
        return districtService.getById(id);
    }

    @PostMapping("/add")
    public AddDistrictResponse addDistrict(AddDistrictRequest addDistrictRequest){
        return districtService.addDistrict(addDistrictRequest);
    }
}
