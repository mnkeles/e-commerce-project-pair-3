package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.entities.concretes.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
