package com.etiya.ecommercepair3.business.dtos.resquests.productAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductAttributeRequest {

    private String genderType;
    private String sizeType;
    private String colorType;
}
