package com.etiya.ecommercepair3.business.dtos.responses.address;

import com.etiya.ecommercepair3.entities.concrete.Customer;
import com.etiya.ecommercepair3.entities.concrete.Street;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressResponse {
    private Integer id;
    private String description;
    private Integer streetId;
    private Integer customerId;

}
