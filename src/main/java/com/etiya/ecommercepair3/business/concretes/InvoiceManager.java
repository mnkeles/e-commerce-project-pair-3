package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.InvoiceService;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.AddInvoiceResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.InvoiceDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.ListInvoiceResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.UpdateInvoiceResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.invoice.AddInvoiceRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.invoice.UpdateInvoiceRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Invoice;
import com.etiya.ecommercepair3.repositories.abstracts.InvoiceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceDao invoiceDao;
    private final ModelMapperService modelMapperService;
    @Override
    public DataResult<List<ListInvoiceResponse>> getAll() {
        return new SuccessDataResult<>(invoiceDao.getAll());
    }

    @Override
    public DataResult<InvoiceDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(invoiceDao.getByInvoiceId(id));
    }

    @Override
    public DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest) {
        Invoice invoice=modelMapperService.forRequest().map(addInvoiceRequest,Invoice.class);
        invoiceDao.save(invoice);
        AddInvoiceResponse addInvoiceResponse=modelMapperService.forResponse().map(invoice,AddInvoiceResponse.class);
        return new SuccessDataResult<>(addInvoiceResponse);
    }

    @Override
    public DataResult<UpdateInvoiceResponse> updateInvoice(UpdateInvoiceRequest updateInvoiceRequest){
        // iş kuralı
        Invoice invoice=modelMapperService.forRequest().map(updateInvoiceRequest,Invoice.class);
        invoice.setId(updateInvoiceRequest.getId());
        invoiceDao.save(invoice);
        UpdateInvoiceResponse updateInvoiceResponse=modelMapperService.forResponse().map(invoice,UpdateInvoiceResponse.class);
        return new SuccessDataResult<>(updateInvoiceResponse);
    }

    @Override
    public Result deleteInvoice(Integer id){
        invoiceDao.deleteById(id);
        return new SuccessResult("X");
    }

}
