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
public class IndividualCustomer {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="identity_number")
    private String identityNumber;

    @Column(name="first_name")
    private String firstName;

    @Column(name="surname")
    private String surname;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Customer customer;

}
