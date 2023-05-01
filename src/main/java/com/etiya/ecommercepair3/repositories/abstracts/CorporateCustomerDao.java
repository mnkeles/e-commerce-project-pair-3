package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.CorporateCustomerDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.ListCorporateCustomerResponse;
import com.etiya.ecommercepair3.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CorporateCustomerDao extends JpaRepository<CorporateCustomer,Integer> {
    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.ListCorporateCustomerResponse" +
            "(c.id,c.companyNumber,c.companyName,c.phoneNumber,c.accountName,c.password)  from CorporateCustomer c")
    ListCorporateCustomerResponse getAll();

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer.CorporateCustomerDetailResponse" +
            "(c.id,c.companyNumber,c.companyNumber,c.phoneNumber,c.accountName,c.password)  from CorporateCustomer c " +
            "where c.id=:id")
    CorporateCustomerDetailResponse getByCorporateCustomerId(Integer id);
}
