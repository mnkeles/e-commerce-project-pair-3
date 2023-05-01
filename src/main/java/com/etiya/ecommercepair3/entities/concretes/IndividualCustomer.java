package com.etiya.ecommercepair3.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="individual_customers")
@PrimaryKeyJoinColumn(name = "id")
public class IndividualCustomer extends  Customer {

    @Column(name="identity_number")
    private String identityNumber;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

   /* @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Customer customer;

    */

}
