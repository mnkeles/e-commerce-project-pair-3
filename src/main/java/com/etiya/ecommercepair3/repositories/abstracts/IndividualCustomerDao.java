package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.IndividualCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.ListIndividualCustomerResponse;
import com.etiya.ecommercepair3.entities.concretes.IndividualCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer,Integer> {

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.ListIndividualCustomerResponse" +
            "(i.id,i.firstName,i.lastName,i.identityNumber,i.phoneNumber,i.accountName,i.password)  from IndividualCustomer i ")
    Slice<ListIndividualCustomerResponse> getAll(Pageable pageable);

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.individualCustomer.IndividualCustomerDetailResponse" +
            "(i.id,i.firstName,i.lastName,i.identityNumber,i.phoneNumber,i.accountName,i.password)  from IndividualCustomer i " +
            "where i.id=:id")
    IndividualCustomerDetailResponse getByIndividualCustomerId(Integer id);

}
