package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.PaymentService;
import com.etiya.ecommercepair3.business.dtos.responses.payment.AddPaymentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.ListPaymentResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.PaymentDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.payment.UpdatePaymentResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.payment.AddPaymentRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.payment.UpdatePaymentRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Payment;
import com.etiya.ecommercepair3.repositories.abstracts.PaymentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentManager implements PaymentService {
    private final PaymentDao paymentDao;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ListPaymentResponse>> getAll() {
        return new SuccessDataResult<>(paymentDao.getAll());
    }

    @Override
    public DataResult<PaymentDetailResponse> getPaymentById(Integer id) {
        return new SuccessDataResult<>(paymentDao.getByPaymentId(id));
    }

    @Override
    public DataResult<AddPaymentResponse> addPayment(AddPaymentRequest addPaymentRequest) {

        // iş kuralı
        Payment payment=modelMapperService.forRequest().map(addPaymentRequest,Payment.class);
        // Mapper Stringi enum a çevirmezse yorum satırlarını kullan
       // payment.setPaymentType(PaymentType.valueOf(addPaymentRequest.getPaymentType()));
        paymentDao.save(payment);

        AddPaymentResponse addPaymentResponse=modelMapperService.forResponse().map(payment,AddPaymentResponse.class);
        return new SuccessDataResult<>(addPaymentResponse);
    }

    @Override
    public DataResult<UpdatePaymentResponse> updatePayment(UpdatePaymentRequest updatePaymentRequest){
        // iş kuralı
        Payment payment=modelMapperService.forRequest().map(updatePaymentRequest,Payment.class);
        payment.setId(updatePaymentRequest.getId());
        paymentDao.save(payment);
        UpdatePaymentResponse updatePaymentResponse=modelMapperService.forResponse().map(payment,UpdatePaymentResponse.class);
        return new SuccessDataResult<>(updatePaymentResponse);
    }

    @Override
    public Result deletePayment(Integer id){
        paymentDao.deleteById(id);
        return new SuccessResult("X");
    }
}
