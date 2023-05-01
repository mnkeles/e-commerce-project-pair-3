package com.etiya.ecommercepair3.business.dtos.resquests.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddIndividualCustomerRequest {
    private String firstName;
    private String lastName;
    private String identityNumber;
    private String phoneNumber;
    private String accountName;
    private String password;
}
