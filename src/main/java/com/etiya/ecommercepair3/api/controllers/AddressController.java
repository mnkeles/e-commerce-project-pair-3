package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.AddressService;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.UpdateAddressResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.address.AddAddressRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.address.UpdateAddressRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping()
    public DataResult<List<ListAddressResponse>> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<AddressDetailResponse> getAddressById(@PathVariable Integer id){
        return addressService.getAddressById(id);
    }

    @PostMapping("/add")
    public DataResult<AddAddressResponse> addAddress(@RequestBody @Valid AddAddressRequest  addAddressRequest){
       return addressService.addAddress(addAddressRequest);
    }

    @PutMapping("/update")
    public DataResult<UpdateAddressResponse> updateAddress(@RequestBody@Valid UpdateAddressRequest updateAddressRequest){
        return addressService.updateAddress(updateAddressRequest);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteAddress(@PathVariable Integer id){
        return addressService.deleteAddress(id);
    }



}
