package com.etiya.ecommercepair3.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="refunds")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="refund_cause")
    private String refundCause;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_type")
    private StatusType statusType ;

    @ManyToOne()
    @JoinColumn(name="order_id")
    private Order order;

}
