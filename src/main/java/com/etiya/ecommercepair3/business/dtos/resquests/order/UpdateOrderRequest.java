package com.etiya.ecommercepair3.business.dtos.resquests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    private Integer id;
    private Integer customerId;
    private Integer addressId;
    private Integer paymentId;
    private Integer invoiceId;
    private Integer supplierId;
}
