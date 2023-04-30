package com.etiya.ecommercepair3.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="salesmans")
public class Salesman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "salesman")
    private List<ProductSalesman> productSalesmen;

    @OneToMany(mappedBy = "salesman")
    private List<Reply> replies;
}
