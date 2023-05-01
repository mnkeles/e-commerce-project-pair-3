package com.etiya.ecommercepair3.business.dtos.resquests.corporateCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCorporateCustomerRequest {
    private String companyNumber;
    private String companyName;
    private String phoneNumber;
    private String accountName;
    private String password;
}
