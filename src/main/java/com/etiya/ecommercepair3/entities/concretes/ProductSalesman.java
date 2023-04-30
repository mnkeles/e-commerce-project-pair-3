package com.etiya.ecommercepair3.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_salesman")
public class ProductSalesman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name="salesman_id")
    private Salesman salesman;
}
