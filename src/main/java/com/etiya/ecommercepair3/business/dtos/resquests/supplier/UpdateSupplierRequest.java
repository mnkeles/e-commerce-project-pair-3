package com.etiya.ecommercepair3.business.dtos.resquests.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSupplierRequest {
    private Integer id;
    private String name;

}
