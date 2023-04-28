package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceDao extends JpaRepository<Invoice,Integer> {
    @Query("SELECT i FROM Invoice i")
    List<Invoice> findAllByInvoice();
}
