package com.etiya.ecommercepair3.business.dtos.responses.refund;

import com.etiya.ecommercepair3.entities.concretes.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRefundResponse {
    private Integer id;
    private String refundCause;
    private StatusType statusType;
    private Integer orderId;
}
