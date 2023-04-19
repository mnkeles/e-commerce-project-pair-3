package com.etiya.ecommercepair3.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="discount_amount")
    private Double discountAmount;

    @Column(name="account_expire")
    private Date accountExpire;

    @OneToMany(mappedBy = "discount")
    private List<ProductDiscount> productDiscounts;

}
