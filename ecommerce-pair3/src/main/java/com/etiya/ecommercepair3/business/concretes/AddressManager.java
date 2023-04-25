package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.repositories.abstracts.AddressDao;
import com.etiya.ecommercepair3.business.abstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressManager implements AddressService {
    private AddressDao addressDao;

    @Override
    public List<Address> getAll() {
        return addressDao.findAll();
    }

    @Override
    public Address getAddressById(Integer id) {

        return addressDao.getById(id);
    }

    @Override
    public void addAddress(Address address) {
        Address address1=getAddressById(address.getId());
        if(address1!=null){
            return ;
        }
        addressDao.save(address);

    }


}
