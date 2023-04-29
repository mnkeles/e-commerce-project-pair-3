package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.SalesmanService;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.AddSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.ListSalesmanResponse;
import com.etiya.ecommercepair3.business.dtos.responses.salesman.SalesmanDetailResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.saleman.AddSalesmanRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salesman")
@RequiredArgsConstructor
public class SalesmansController {
    private final SalesmanService salesmanService;

    @GetMapping()
    public List<ListSalesmanResponse> getAll(){
        return salesmanService.getAll();
    }

    @GetMapping("/{id}")
    public SalesmanDetailResponse getById(@PathVariable Integer id){
        return salesmanService.getById(id);
    }

    @PostMapping("/add")
    public AddSalesmanResponse addSalesman(@Valid @RequestBody AddSalesmanRequest addSalesmanRequest){
        return salesmanService.addSalesman(addSalesmanRequest);
    }
}
