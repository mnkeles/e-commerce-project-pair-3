package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.AddressService;
import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.repositories.abstracts.AddressDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
    private AddressService addressService;

    @GetMapping()
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address getAddressById(Integer id){
        return addressService.getAddressById(id);
    }

    @PostMapping("/add")
    public void addAddress(Address address){
        addressService.addAddress(address);
    }

}
