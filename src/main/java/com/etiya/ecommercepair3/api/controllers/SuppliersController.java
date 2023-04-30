package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.SupplierService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.AddSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.ListSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.SupplierDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.supplier.UpdateSupplierResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.supplier.AddSupplierRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.supplier.UpdateSupplierRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SuppliersController {
    private final SupplierService supplierService;
    @GetMapping()
    public DataResult<List<ListSupplierResponse>> getAll(){
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<SupplierDetailResponse> getById(@PathVariable Integer id){
        return supplierService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddSupplierResponse> addStreet(AddSupplierRequest addSupplierRequest){
        return supplierService.addSupplier(addSupplierRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateSupplierResponse> updateSupplier(@RequestBody@Valid UpdateSupplierRequest updateSupplierRequest){
            return supplierService.updateSupplier(updateSupplierRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteSupplier(@PathVariable Integer id){
        return supplierService.deleteSupplier(id);
    }
}
