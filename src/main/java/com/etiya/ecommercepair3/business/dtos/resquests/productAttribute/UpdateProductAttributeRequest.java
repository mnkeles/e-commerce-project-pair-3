package com.etiya.ecommercepair3.business.dtos.resquests.productAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductAttributeRequest {
    private Integer id;
    private String genderType;
    private String sizeType;
    private String colorType;
}
