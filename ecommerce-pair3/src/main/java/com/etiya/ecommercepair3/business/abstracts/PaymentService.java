package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.entities.concrete.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getAll();
    Payment getPaymentById(Integer id);
    void addPayment(Payment payment);
}
