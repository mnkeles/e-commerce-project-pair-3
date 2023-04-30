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
@Table(name="street")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="street_name",unique = true)
    private String streetName;

    @OneToMany(mappedBy = "street")
    private List<Address> addresses;

    @ManyToOne()
    @JoinColumn(name="district_id")
    private District district;

}
