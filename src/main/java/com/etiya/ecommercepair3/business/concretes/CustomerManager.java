package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CustomerService;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.entities.concretes.Customer;
import com.etiya.ecommercepair3.repositories.abstracts.CustomerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerDao customerDao;
    private final ModelMapperService modelMapperService;

    @Override
    public Customer addCustomer(Customer customer) {

        return customerDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customer1 = customerDao.findById(customer.getId()).get();
        customer1 = modelMapperService.forRequest().map(customer, Customer.class);
        //customerDao.save(customer1);
        return customer1;
    }

    @Override
    public void deleteCustomer(Integer id){
         customerDao.deleteById(id);
    }

}
