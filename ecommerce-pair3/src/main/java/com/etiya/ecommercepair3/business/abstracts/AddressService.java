package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.address.AddAddressRequest;
import com.etiya.ecommercepair3.entities.concrete.Address;

import java.util.List;

public interface AddressService {
    List<ListAddressResponse> getAll();
    AddressDetailResponse getAddressById(Integer id);
    AddAddressResponse addAddress(AddAddressRequest address);
}
