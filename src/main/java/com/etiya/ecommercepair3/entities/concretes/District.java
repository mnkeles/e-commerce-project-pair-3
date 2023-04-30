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
@Table(name="districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="district_name",unique = true)
    private String districtName;

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City  city;

    @OneToMany(mappedBy = "district")
    private List<Street> streets;
}
