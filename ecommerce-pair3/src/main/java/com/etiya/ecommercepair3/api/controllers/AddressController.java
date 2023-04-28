package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.AddressService;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.address.AddAddressRequest;
import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.repositories.abstracts.AddressDao;
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
    public List<ListAddressResponse> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public AddressDetailResponse getAddressById(@PathVariable Integer id){
        return addressService.getAddressById(id);
    }

    @PostMapping("/add")
    public AddAddressResponse addAddress(@RequestBody @Valid AddAddressRequest  addAddressRequest){
       return addressService.addAddress(addAddressRequest);
    }

}
