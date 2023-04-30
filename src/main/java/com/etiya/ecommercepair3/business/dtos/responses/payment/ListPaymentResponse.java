package com.etiya.ecommercepair3.business.dtos.responses.payment;

import com.etiya.ecommercepair3.entities.concretes.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPaymentResponse {
    private Integer id;
    private Date paymentDate;
    private PaymentType paymentType;
    private Integer installment;
    private Integer orderId;

}
