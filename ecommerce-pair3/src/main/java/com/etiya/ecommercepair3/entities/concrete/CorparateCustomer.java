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
public class CorparateCustomer extends Customer {

    @Column(name="corparate_name")
    private String corparateName;


}
