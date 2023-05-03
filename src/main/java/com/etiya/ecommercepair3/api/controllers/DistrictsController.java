package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.DistrictService;
import com.etiya.ecommercepair3.business.dtos.responses.district.AddDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.DistrictDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.ListDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.responses.district.UpdateDistrictResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.district.AddDistrictRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.district.UpdateDistrictRequest;
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
@RequestMapping("/api/district")
@RequiredArgsConstructor
public class DistrictsController {
    private final DistrictService districtService;

    @GetMapping()
    public DataResult<Slice<ListDistrictResponse>> getAll(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return districtService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public DataResult<DistrictDetailResponse> getById(@PathVariable Integer id){
        return districtService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddDistrictResponse> addDistrict(AddDistrictRequest addDistrictRequest){
        return districtService.addDistrict(addDistrictRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateDistrictResponse> updateDistrict(@RequestBody@Valid UpdateDistrictRequest updateDistrictRequest){
        return districtService.updateDistrict(updateDistrictRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteDistrict(@PathVariable Integer id){
        return districtService.deleteDistrict(id);
    }
}
