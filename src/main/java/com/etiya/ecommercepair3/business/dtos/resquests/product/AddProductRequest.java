package com.etiya.ecommercepair3.business.dtos.resquests.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {
    private String productName;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer productAttributeId;
}
