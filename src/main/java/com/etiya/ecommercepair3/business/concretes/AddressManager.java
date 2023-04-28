package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CustomerService;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddressDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.address.ListAddressResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.address.AddAddressRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.entities.concrete.Customer;
import com.etiya.ecommercepair3.entities.concrete.Street;
import com.etiya.ecommercepair3.repositories.abstracts.AddressDao;
import com.etiya.ecommercepair3.business.abstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressManager implements AddressService {
    private final AddressDao addressDao;
    private final ModelMapperService modelMapperService;

    @Override
    public List<ListAddressResponse> getAll() {
        return addressDao.getAll();
    }

    @Override
    public AddressDetailResponse getAddressById(Integer id) {
        return addressDao.getByAddressId(id);
    }

    @Override
    public AddAddressResponse addAddress(AddAddressRequest addAddressRequest) {
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
        Address address=modelMapperService.forRequest().map(addAddressRequest,Address.class);
        addressDao.save(address);
        AddAddressResponse addAddressResponse=modelMapperService.forResponse().map(address,AddAddressResponse.class);
        return addAddressResponse;
    }


}
