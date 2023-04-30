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
@Table(name="product_attributes")
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender_type")
    private GenderType genderType;

    @Enumerated(EnumType.STRING)
    @Column(name = "size_type")
    private SizeType sizeType;

    @Enumerated(EnumType.STRING)
    @Column(name = "color_type")
    private ColorType colorType;

    @OneToMany(mappedBy = "productAttribute")
    private List<Product> products;

}
