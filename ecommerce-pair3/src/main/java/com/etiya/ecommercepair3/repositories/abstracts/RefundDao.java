package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RefundDao extends JpaRepository<Refund,Integer> {
    @Query("SELECT r FROM Refund r")
    List<Refund> findAllByRefund();
}
