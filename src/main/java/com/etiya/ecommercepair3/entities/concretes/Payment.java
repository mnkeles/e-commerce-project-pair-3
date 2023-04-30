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
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="date")
    private Date paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentType")
    private PaymentType paymentType;


    @Column(name="installment")
    private Integer installment;

    @OneToOne(mappedBy = "payment")
    private Order order;



}
