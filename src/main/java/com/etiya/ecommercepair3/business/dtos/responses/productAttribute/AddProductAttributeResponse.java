package com.etiya.ecommercepair3.business.dtos.responses.productAttribute;

import com.etiya.ecommercepair3.entities.concretes.ColorType;
import com.etiya.ecommercepair3.entities.concretes.GenderType;
import com.etiya.ecommercepair3.entities.concretes.SizeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductAttributeResponse {
    private Integer id;
    private GenderType genderType;
    private SizeType sizeType;
    private ColorType colorType;

}
