package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.discount.AddDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailsResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.ListDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.AddDiscountRequest;

import java.util.List;

public interface DiscountService {
    List<ListDiscountResponse> getAll();
    DiscountDetailsResponse getById(Integer id);

    AddDiscountResponse addDiscount(AddDiscountRequest addDiscountRequest);
}
