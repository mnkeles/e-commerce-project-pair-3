package com.etiya.ecommercepair3.business.dtos.responses.discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDiscountResponse {
    private Integer id;
    private Double discountAmount;
    private Date discountExpire;
}
