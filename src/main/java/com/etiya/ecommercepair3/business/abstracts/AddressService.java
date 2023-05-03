package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.UpdateAddressResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.address.AddAddressRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.address.UpdateAddressRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface AddressService {
    DataResult<Slice<ListAddressResponse>> getAll(Pageable pageable);
    DataResult<AddressDetailResponse> getAddressById(Integer id);
    DataResult<AddAddressResponse> addAddress(AddAddressRequest address);

    DataResult<UpdateAddressResponse> updateAddress(UpdateAddressRequest updateAddressRequest);

    Result deleteAddress(Integer id);
}
