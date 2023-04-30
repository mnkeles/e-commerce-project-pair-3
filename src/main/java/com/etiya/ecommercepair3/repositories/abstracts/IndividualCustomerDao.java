package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer,Integer> {
    @Query("SELECT ic FROM IndividualCustomer ic")
    List<IndividualCustomer> findAllByIndividualCustomer();
}
