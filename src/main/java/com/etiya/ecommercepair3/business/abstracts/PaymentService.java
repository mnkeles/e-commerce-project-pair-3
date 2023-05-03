package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.payment.AddPaymentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.ListPaymentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.PaymentDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.UpdatePaymentResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.payment.AddPaymentRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.payment.UpdatePaymentRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface PaymentService {

    DataResult<Slice<ListPaymentResponse>> getAll(Pageable pageable);
    DataResult<PaymentDetailResponse> getPaymentById(Integer id);
    DataResult<AddPaymentResponse> addPayment(AddPaymentRequest addPaymentRequest);

    DataResult<UpdatePaymentResponse> updatePayment(UpdatePaymentRequest updatePaymentRequest);

    Result deletePayment(Integer id);
}
