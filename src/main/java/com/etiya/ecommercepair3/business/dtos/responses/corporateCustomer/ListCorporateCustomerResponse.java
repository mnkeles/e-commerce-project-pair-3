package com.etiya.ecommercepair3.business.dtos.responses.corporateCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCorporateCustomerResponse {
    private Integer id;
    private String companyNumber;
    private String companyName;
    private String phoneNumber;
    private String accountName;
    private String password;
}
