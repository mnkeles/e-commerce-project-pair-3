package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
    @Query("SELECT c FROM Customer c")
    List<Customer> findAllByCustomer();

}
