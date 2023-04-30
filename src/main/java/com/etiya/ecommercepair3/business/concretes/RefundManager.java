package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.RefundService;
import com.etiya.ecommercepair3.business.dtos.responses.refund.AddRefundResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.ListRefundResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.RefundDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.UpdateRefundResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.refund.AddRefundRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.refund.UpdateRefundRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Refund;
import com.etiya.ecommercepair3.repositories.abstracts.RefundDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefundManager implements RefundService {
    private final RefundDao refundDao;
    private final ModelMapperService modelMapperService;
    @Override
    public DataResult<List<ListRefundResponse>> getAll() {
        return new SuccessDataResult<>(refundDao.getAll());
    }

    @Override
    public DataResult<RefundDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(refundDao.getByRefundId(id));
    }

    @Override
    public DataResult<AddRefundResponse> addRefund(AddRefundRequest addRefundRequest) {
        // iş kuralı
        Refund refund=modelMapperService.forRequest().map(addRefundRequest,Refund.class);
        refundDao.save(refund);
        AddRefundResponse addRefundResponse=modelMapperService.forResponse().map(refund,AddRefundResponse.class);
        return new SuccessDataResult<>(addRefundResponse);
    }

    @Override
    public DataResult<UpdateRefundResponse> updateRefund(UpdateRefundRequest  updateRefundRequest){
        // iş kuralı
        Refund  refund=modelMapperService.forRequest().map(updateRefundRequest,Refund.class);
        refund.setId(updateRefundRequest.getId());
        refundDao.save(refund);
        UpdateRefundResponse updateRefundResponse=modelMapperService.forResponse().map(refund,UpdateRefundResponse.class);
        return new SuccessDataResult<>(updateRefundResponse);
    }

    @Override
    public Result deleteRefund(Integer id){
        refundDao.deleteById(id);
        return new SuccessResult("X");
    }
}
