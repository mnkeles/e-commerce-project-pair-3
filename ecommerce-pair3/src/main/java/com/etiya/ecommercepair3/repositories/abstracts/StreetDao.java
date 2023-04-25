package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StreetDao extends JpaRepository<Street,Integer> {
    @Query("SELECT s FROM Street s")
    List<Street> findAllBySupplier();
}
