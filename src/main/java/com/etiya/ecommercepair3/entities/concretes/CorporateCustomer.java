package com.etiya.ecommercepair3.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "corparate_customers")
@PrimaryKeyJoinColumn(name = "id")
public class CorporateCustomer extends Customer {
    @Column(name = "company_number")
    private String companyNumber;

    @Column(name = "company_name")
    private String companyName;

    /*@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Customer customer;

     */


}
