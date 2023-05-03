package com.etiya.ecommercepair3.business.abstracts;



import com.etiya.ecommercepair3.business.dtos.responses.refund.AddRefundResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.ListRefundResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.RefundDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.refund.UpdateRefundResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.refund.AddRefundRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.refund.UpdateRefundRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface RefundService {
    DataResult<Slice<ListRefundResponse>> getAll(Pageable pageable);
    DataResult<RefundDetailResponse> getById(Integer id);
    DataResult<AddRefundResponse> addRefund(AddRefundRequest addRefundRequest);

    DataResult<UpdateRefundResponse> updateRefund(UpdateRefundRequest updateRefundRequest);

    Result deleteRefund(Integer id);
}
