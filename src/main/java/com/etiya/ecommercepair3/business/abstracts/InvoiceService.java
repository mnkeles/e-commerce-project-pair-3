package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.invoice.AddInvoiceResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.InvoiceDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.ListInvoiceResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.UpdateInvoiceResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.invoice.AddInvoiceRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.invoice.UpdateInvoiceRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

import java.util.List;

public interface InvoiceService {
    DataResult<List<ListInvoiceResponse>> getAll();
    DataResult<InvoiceDetailResponse> getById(Integer id);
    DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest);

    DataResult<UpdateInvoiceResponse> updateInvoice(UpdateInvoiceRequest updateInvoiceRequest);

    Result deleteInvoice(Integer id);
}
