package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.DiscountService;
import com.etiya.ecommercepair3.business.dtos.responses.discount.AddDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailsResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.ListDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.AddDiscountRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.entities.concrete.Discount;
import com.etiya.ecommercepair3.repositories.abstracts.DiscountDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountManager implements DiscountService {
    private final DiscountDao discountDao;
    private final ModelMapperService modelMapperService;

    @Override
    public List<ListDiscountResponse> getAll() {
        return discountDao.getAll();
    }

    @Override
    public DiscountDetailsResponse getById(Integer id) {
        return discountDao.getByDiscountId(id);
    }

    @Override
    public AddDiscountResponse addDiscount(AddDiscountRequest addDiscountRequest) {
        // iş kuralı

        Discount discount=modelMapperService.forRequest().map(addDiscountRequest,Discount.class);
        discountDao.save(discount);
        AddDiscountResponse addDiscountResponse=modelMapperService.forResponse().map(discount,AddDiscountResponse.class);
        return addDiscountResponse;
    }
}
