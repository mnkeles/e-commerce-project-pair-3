package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();
    Address getAddressById(Integer id);
    void addAddress(Address address);
}
