package com.etiya.ecommercepair3.business.abstracts;



import com.etiya.ecommercepair3.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.product.AddProductRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.product.UpdateProductRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

import java.util.List;

public interface ProductService {
    DataResult<List<ListProductResponse>> getAll();

    DataResult<ProductDetailResponse> getById(Integer id);

    DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest);

    DataResult<UpdateProductResponse> updateProduct(UpdateProductRequest updateProductRequest);

    Result deleteProduct(Integer id);
}
