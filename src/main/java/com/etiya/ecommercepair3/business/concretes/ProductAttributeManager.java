package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.ProductAttributeService;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.AddProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ListProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ProductAttributeDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.UpdateProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.productAttribute.AddProductAttributeRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.productAttribute.UpdateProductAttributeRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.ProductAttribute;
import com.etiya.ecommercepair3.repositories.abstracts.ProductAttributeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductAttributeManager implements ProductAttributeService {
    private final ProductAttributeDao productAttributeDao;
    private final ModelMapperService modelMapperService;
    @Override
    public DataResult<List<ListProductAttributeResponse>> getAll() {
        return new SuccessDataResult<>(productAttributeDao.getAll());
    }

    @Override
    public DataResult<ProductAttributeDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(productAttributeDao.getByProductAttributeId(id));
    }

    @Override
    public DataResult<AddProductAttributeResponse> addProductAttribiute(AddProductAttributeRequest addProductAttributeRequest) {
        // iş kuralı

        ProductAttribute productAttribute=modelMapperService.forRequest().map(addProductAttributeRequest,ProductAttribute.class);
        //productAttribute.setSizeType(SizeType.valueOf(addProductAttributeRequest.getSizeType()));
        //productAttribute.setGenderType(GenderType.valueOf(addProductAttributeRequest.getGenderType()));
        //productAttribute.setGenderType(GenderType.valueOf(addProductAttributeRequest.getGenderType()));
        productAttributeDao.save(productAttribute);
        AddProductAttributeResponse addProductAttributeResponse=modelMapperService.forResponse().
                map(productAttribute,AddProductAttributeResponse.class);


        return new SuccessDataResult<>(addProductAttributeResponse);
    }

    @Override
    public DataResult<UpdateProductAttributeResponse> updateProductAttribute(UpdateProductAttributeRequest updateProductAttributeRequest){
        // iş kuralı
        ProductAttribute productAttribute=modelMapperService.forRequest()
                .map(updateProductAttributeRequest,ProductAttribute.class);
        productAttribute.setId(updateProductAttributeRequest.getId());
        productAttributeDao.save(productAttribute);
        UpdateProductAttributeResponse updateProductAttributeResponse=modelMapperService.forResponse()
                .map(productAttribute,UpdateProductAttributeResponse.class);
        return new SuccessDataResult<>(updateProductAttributeResponse);
    }

    @Override
    public Result deleteProductAttribute(Integer id){
        productAttributeDao.deleteById(id);
        return new SuccessResult("X");
    }
}
