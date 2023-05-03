package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.SalesmanService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.AddSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.ListSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.SalesmanDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.UpdateSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.AddSalesmanRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.UpdateSalesmanRequest;
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
@RequestMapping("/api/salesman")
@RequiredArgsConstructor
public class SalesmansController {
    private final SalesmanService salesmanService;

    @GetMapping()
    public DataResult<Slice<ListSalesmanResponse>> getAll(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return salesmanService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public DataResult<SalesmanDetailResponse> getById(@PathVariable Integer id){
        return salesmanService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddSalesmanResponse> addSalesman(@Valid @RequestBody AddSalesmanRequest addSalesmanRequest){
        return salesmanService.addSalesman(addSalesmanRequest);
    }
    @PutMapping("/update")
    private DataResult<UpdateSalesmanResponse> updateSalesman(@RequestBody@Valid UpdateSalesmanRequest updateSalesmanRequest){
            return salesmanService.updateSalesman(updateSalesmanRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteSalesman(@PathVariable Integer id){
        return salesmanService.deleteSalesman(id);
    }
}
