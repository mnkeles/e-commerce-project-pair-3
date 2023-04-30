package com.etiya.ecommercepair3.repositories.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.payment.ListPaymentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.PaymentDetailResponse;
import com.etiya.ecommercepair3.entities.concretes.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentDao extends JpaRepository<Payment,Integer> {

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.payment.ListPaymentResponse" +
            "(p.id,p.paymentDate,p.paymentType,p.installment,o.id) From Payment  p join Order o ")
    List<ListPaymentResponse> getAll();

    @Query("select new com.etiya.ecommercepair3.business.dtos.responses.payment.PaymentDetailResponse" +
            "(p.id,p.paymentDate,p.paymentType,p.installment,o.id) from Payment p join Order o  where p.id=:id")
    PaymentDetailResponse getByPaymentId(Integer id);

}
