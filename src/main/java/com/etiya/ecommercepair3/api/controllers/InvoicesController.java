package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.InvoiceService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.AddInvoiceResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.InvoiceDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.ListInvoiceResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.UpdateInvoiceResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.invoice.AddInvoiceRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.invoice.UpdateInvoiceRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class InvoicesController {
    private final InvoiceService invoiceService;

    @GetMapping()
    public DataResult<List<ListInvoiceResponse>> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<InvoiceDetailResponse> getById(@PathVariable Integer id){
        return invoiceService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest){
        return invoiceService.addInvoice(addInvoiceRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateInvoiceResponse> updateInvoice(@RequestBody@Valid UpdateInvoiceRequest updateInvoiceRequest){
        return invoiceService.updateInvoice(updateInvoiceRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteInvoice(@PathVariable Integer id){
        return invoiceService.deleteInvoice(id);
    }
}
