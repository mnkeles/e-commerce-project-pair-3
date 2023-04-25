package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentDao extends JpaRepository<Payment,Integer> {
    @Query("SELECT pa FROM Payment pa")
    List<Payment> findAllByPayment();

    Payment getById(Integer id);
}
