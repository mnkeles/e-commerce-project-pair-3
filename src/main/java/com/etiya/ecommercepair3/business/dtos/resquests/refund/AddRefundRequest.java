package com.etiya.ecommercepair3.business.dtos.resquests.refund;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRefundRequest {

    private String refundCause;
    private String statusType;
    private Integer orderId;
}
