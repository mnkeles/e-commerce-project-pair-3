package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesmanDao extends JpaRepository<Salesman,Integer> {
    @Query("SELECT s FROM Salesman s")
    List<Salesman> findAllBySalesman();
}
