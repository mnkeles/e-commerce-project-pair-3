package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.AddressService;
import com.etiya.ecommercepair3.business.abstracts.PaymentService;
import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.entities.concrete.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    @GetMapping()
    public List<Payment> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(Integer id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/add")
    public void addPayment(Payment payment){
        paymentService.addPayment(payment);
    }
}
