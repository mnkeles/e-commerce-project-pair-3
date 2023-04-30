package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.invoice.InvoiceDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.invoice.ListInvoiceResponse;
import com.etiya.ecommercepair3.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceDao extends JpaRepository<Invoice,Integer> {

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.invoice.ListInvoiceResponse" +
            "(i.id,i.invoiceNumber,i.invoiceDate,i.order.id) from Invoice i")
    List<ListInvoiceResponse> getAll();

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.invoice.InvoiceDetailResponse" +
            "(i.id,i.invoiceNumber,i.invoiceDate,i.order.id) from Invoice i where i.id=:id")
    InvoiceDetailResponse getByInvoiceId(Integer id);
    @Query("SELECT i FROM Invoice i")
    List<Invoice> findAllByInvoice();
}
