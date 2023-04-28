package com.etiya.ecommercepair3.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="corparate_customers")
public class CorparateCustomer   {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="company_number")
    private Integer companyNumber;

    @Column(name="company_name")
    private String companyName;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Customer customer;


}
