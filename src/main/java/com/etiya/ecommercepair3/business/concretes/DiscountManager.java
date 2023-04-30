package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.DiscountService;
import com.etiya.ecommercepair3.business.dtos.responses.discount.AddDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.DiscountDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.ListDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.responses.discount.UpdateDiscountResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.AddDiscountRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.discount.UpdateDiscountRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Discount;
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
    public DataResult<List<ListDiscountResponse>> getAll() {
        return new SuccessDataResult<>(discountDao.getAll());
    }

    @Override
    public DataResult<DiscountDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(discountDao.getByDiscountId(id));
    }

    @Override
    public DataResult<AddDiscountResponse> addDiscount(AddDiscountRequest addDiscountRequest) {
        // iş kuralı

        Discount discount=modelMapperService.forRequest().map(addDiscountRequest,Discount.class);
        discountDao.save(discount);
        AddDiscountResponse addDiscountResponse=modelMapperService.forResponse().map(discount,AddDiscountResponse.class);
        return new SuccessDataResult<>(addDiscountResponse);
    }

    @Override
    public DataResult<UpdateDiscountResponse> updateDiscount(UpdateDiscountRequest updateDiscountRequest){
        // iş kuralı
        Discount discount=modelMapperService.forRequest().map(updateDiscountRequest,Discount.class);
        discount.setId(discount.getId());
        discountDao.save(discount);
        UpdateDiscountResponse updateDiscountResponse=modelMapperService.forResponse().map(discount,UpdateDiscountResponse.class);
        return new SuccessDataResult<>(updateDiscountResponse);
    }

    @Override
    public Result deleteDiscount(Integer id){
        discountDao.deleteById(id);
        return new SuccessResult("X");
    }
}
