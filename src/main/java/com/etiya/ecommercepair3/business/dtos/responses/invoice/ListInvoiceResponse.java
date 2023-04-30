package com.etiya.ecommercepair3.business.dtos.responses.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListInvoiceResponse {
    private Integer id;
    private Integer invoiceNumber;
    private Date invoiceDate;
    private Integer orderId;
}
