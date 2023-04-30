package com.etiya.ecommercepair3.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@JsonIgnoreProperties("address")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "addres_id")
    private Address address;

    @OneToOne()
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;


    @OneToOne()
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "order")
    private List<Refund> refunds;


}
