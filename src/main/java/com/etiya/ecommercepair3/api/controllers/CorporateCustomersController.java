package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CorporateCustomerService;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.AddCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.CorporateCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.ListCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.UpdateCorporateCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.IndividualCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.ListIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.UpdateIndividualCustomerResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.corporateCustomer.AddCorporateCustomerRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.corporateCustomer.UpdateCorporateCustomerRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/corarate-customer")
@RequiredArgsConstructor
public class CorporateCustomersController {
    private final CorporateCustomerService corporateCustomerService;

    @GetMapping()
    public DataResult<ListCorporateCustomerResponse> getAll() {
        return corporateCustomerService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<CorporateCustomerDetailResponse> getById(@PathVariable Integer id) {
        return corporateCustomerService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddCorporateCustomerResponse> addCorporateCustomer(@RequestBody @Valid AddCorporateCustomerRequest addCorporateCustomerRequest) {
        return corporateCustomerService.addCorporateCustomer(addCorporateCustomerRequest);
    }

    @PutMapping("/update")
    public DataResult<UpdateCorporateCustomerResponse> updateCorporateCustomer(@RequestBody @Valid UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        return corporateCustomerService.updateCorporateCustomer(updateCorporateCustomerRequest);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteCorporateCustomer(@PathVariable Integer id) {
        return corporateCustomerService.deleteCorporateCustomer(id);
    }

}
