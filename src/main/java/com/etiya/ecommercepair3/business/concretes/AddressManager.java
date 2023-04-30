package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.UpdateAddressResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.address.AddAddressRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.address.UpdateAddressRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Address;
import com.etiya.ecommercepair3.repositories.abstracts.AddressDao;
import com.etiya.ecommercepair3.business.abstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressManager implements AddressService {
    private final AddressDao addressDao;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ListAddressResponse>> getAll() {
        return new SuccessDataResult<>(addressDao.getAll());
    }

    @Override
    public DataResult<AddressDetailResponse> getAddressById(Integer id) {
        return new SuccessDataResult<>(addressDao.getByAddressId(id));
    }

    @Override
    public DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest) {
        if (addAddressRequest.getDescription() == null || addAddressRequest.getDescription().equals("")) {
            return null;
        }
        /*Address address = new Address();
        address.setDescription(addAddressRequest.getDescription());
        Customer customer=customergetById(addAddressRequest.getCustomerId());
        Customer customer=getAddressById(addAddressRequest.getCustomerId());
        //Customer customer = new Customer();
        //customer.setId(addAddressRequest.getCustomerId());
        address.setCustomer(customer);
        Street street=new Street();
        street.setId(addAddressRequest.getStreetId());
        address.setStreet(street);

         */
        Address address = modelMapperService.forRequest().map(addAddressRequest, Address.class);
        addressDao.save(address);
        AddAddressResponse addAddressResponse = modelMapperService.forResponse().map(address, AddAddressResponse.class);
        return new SuccessDataResult<>(addAddressResponse);
    }

    @Override
    public DataResult<UpdateAddressResponse> updateAddress(UpdateAddressRequest updateAddressRequest) {
        // iş kuralı
        Address address = modelMapperService.forRequest().map(updateAddressRequest, Address.class);
        address.setId(updateAddressRequest.getId());
        addressDao.save(address);
        UpdateAddressResponse updateAddressResponse = modelMapperService.forResponse().map(address, UpdateAddressResponse.class);
        return new SuccessDataResult<>(updateAddressResponse);
    }

    @Override
    public Result deleteAddress(Integer id) {
        addressDao.deleteById(id);
        return new SuccessResult("x");
    }


}
