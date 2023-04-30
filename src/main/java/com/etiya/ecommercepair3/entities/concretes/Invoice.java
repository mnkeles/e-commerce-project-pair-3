package com.etiya.ecommercepair3.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="invoice_number")
    private Integer invoiceNumber;

    @Column(name="invoice_date")
    private Date invoiceDate;

    @OneToOne(mappedBy = "invoice")
    private Order order;


}
