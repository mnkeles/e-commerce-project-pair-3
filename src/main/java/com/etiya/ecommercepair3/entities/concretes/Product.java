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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "units_in_stock")
    private Integer unitsInStock;

    @OneToMany(mappedBy = "product")
    private List<ProductDiscount> productDiscounts;

    @ManyToOne()
    @JoinColumn(name = "product_attributes_id")
    private ProductAttribute productAttribute;

    @OneToMany(mappedBy = "product")
    private List<Comment> comments;

    @OneToMany(mappedBy ="product")
    private List<ProductSalesman>  productSalesmen;

    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productCategories;

}
