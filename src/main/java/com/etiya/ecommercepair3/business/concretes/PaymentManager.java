package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.PaymentService;
import com.etiya.ecommercepair3.entities.concrete.Payment;
import com.etiya.ecommercepair3.repositories.abstracts.PaymentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentManager implements PaymentService {
    private PaymentDao paymentDao;


    @Override
    public List<Payment> getAll() {
        return paymentDao.findAll();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getById(id);
    }

    @Override
    public void addPayment(Payment payment) {
        if(payment.getPaymentTypeId()==null){
            return;
        }
        paymentDao.save(payment);
    }
}
