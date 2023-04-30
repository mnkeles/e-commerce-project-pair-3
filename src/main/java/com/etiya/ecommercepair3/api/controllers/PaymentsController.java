package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.PaymentService;
import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.AddPaymentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.ListPaymentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.PaymentDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.UpdatePaymentResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.payment.AddPaymentRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.payment.UpdatePaymentRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentsController {

    private final PaymentService paymentService;

    @GetMapping()
    public DataResult<List<ListPaymentResponse>> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<PaymentDetailResponse> getPaymentById(@PathVariable Integer id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/add")
    public DataResult<AddPaymentResponse> addPayment(@Valid@RequestBody AddPaymentRequest addPaymentRequest){
        return paymentService.addPayment(addPaymentRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdatePaymentResponse> updatePayment(@RequestBody@Valid UpdatePaymentRequest updatePaymentRequest){
        return paymentService.updatePayment(updatePaymentRequest);
    }

    @DeleteMapping("/{id}")
    public Result deletePayment(@PathVariable Integer id){
        return paymentService.deletePayment(id);
    }
}
