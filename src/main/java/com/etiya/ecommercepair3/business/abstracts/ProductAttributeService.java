package com.etiya.ecommercepair3.business.abstracts;



import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.AddProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ListProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ProductAttributeDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.UpdateProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.productAttribute.AddProductAttributeRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.productAttribute.UpdateProductAttributeRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

import java.util.List;

public interface ProductAttributeService {
    DataResult<List<ListProductAttributeResponse>> getAll();

    DataResult<ProductAttributeDetailResponse> getById(Integer id);

    DataResult<AddProductAttributeResponse> addProductAttribiute(AddProductAttributeRequest addProductAttributeRequest);

    DataResult<UpdateProductAttributeResponse> updateProductAttribute(UpdateProductAttributeRequest updateProductAttributeRequest);

    Result deleteProductAttribute(Integer id);
}
