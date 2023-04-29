package com.etiya.ecommercepair3.business.dtos.resquests.discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDiscountRequest {
    private Double discountAmount;
    private Date discountExpire;
}
