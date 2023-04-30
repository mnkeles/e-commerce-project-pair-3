package com.etiya.ecommercepair3.business.dtos.resquests.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRequest {

    private Date paymentDate;
    private String paymentType;
    private Integer installment;
    private Integer orderId;

}
