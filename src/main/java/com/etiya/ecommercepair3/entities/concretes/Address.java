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
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="description")
    private String description;

    @ManyToOne()
    @JoinColumn(name="street_id")
    private Street street;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "address")
   // @JsonIgnoreProperties("address")
    private List<Order> orders;


}
