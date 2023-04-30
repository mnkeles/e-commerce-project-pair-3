package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.discount.AddDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.ListDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.UpdateDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.AddDiscountRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.UpdateDiscountRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

import java.util.List;

public interface DiscountService {
    DataResult<List<ListDiscountResponse>> getAll();
    DataResult<DiscountDetailResponse> getById(Integer id);

    DataResult<AddDiscountResponse> addDiscount(AddDiscountRequest addDiscountRequest);

    DataResult<UpdateDiscountResponse> updateDiscount(UpdateDiscountRequest updateDiscountRequest);

    Result deleteDiscount(Integer id);
}
