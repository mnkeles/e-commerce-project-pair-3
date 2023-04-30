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
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="city_name",unique = true)
    private String cityName;

    @ManyToOne()
    @JoinColumn(name="country_id")
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<District> districts;


}
