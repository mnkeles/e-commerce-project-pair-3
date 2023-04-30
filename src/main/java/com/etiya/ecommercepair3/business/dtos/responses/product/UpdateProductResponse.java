package com.etiya.ecommercepair3.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductResponse {
    private Integer id;
    private String productName;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer productAttributeId;
}
