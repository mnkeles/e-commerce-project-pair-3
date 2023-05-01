package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.IndividualCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.ListIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.UpdateIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/individual-customer")
@RequiredArgsConstructor
public class IndividualCustomersController {
    private final IndividualCustomerService individualCustomerService;

    @GetMapping()
    public DataResult<ListIndividualCustomerResponse> getAll(){
        return individualCustomerService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<IndividualCustomerDetailResponse> getById(@PathVariable Integer id){
        return individualCustomerService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddIndividualCustomerResponse> addIndividualCustomer(@RequestBody@Valid AddIndividualCustomerRequest addIndividualCustomerRequest){
        return individualCustomerService.addIndividualCustomer(addIndividualCustomerRequest);
    }

    @PutMapping("/update")
    public DataResult<UpdateIndividualCustomerResponse> updateIndividualCustomer(@RequestBody@Valid UpdateIndividualCustomerRequest updateIndividualCustomerRequest){
        return individualCustomerService.updateIndividualCustomer(updateIndividualCustomerRequest);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteIndividualCustomer(@PathVariable Integer id){
        return individualCustomerService.deleteIndividualCustomer(id);
    }


}
