package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.AddressService;
import com.etiya.ecommercepair3.business.abstracts.ProductService;
import com.etiya.ecommercepair3.business.constants.Messages;
import com.etiya.ecommercepair3.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.product.AddProductRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.product.UpdateProductRequest;
import com.etiya.ecommercepair3.core.internationalization.MessageService;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Product;
import com.etiya.ecommercepair3.repositories.abstracts.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {
    private final ProductDao productDao;
    private final ModelMapperService modelMapperService;

    private final MessageService messageService;


    @Override
    public DataResult<Slice<ListProductResponse>> getAll(Pageable pageable) {
        return new SuccessDataResult<>(productDao.getAll(pageable),messageService.getMessage(Messages.Product.ProductGetAll));
    }

    @Override
    public DataResult<ProductDetailResponse> getById(Integer id) {
        return new SuccessDataResult<>(productDao.getByProductId(id),messageService.getMessage(Messages.Product.ProductGetById));
    }

    @Override
    public DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest) {
        // iş kuralı
        Product product=modelMapperService.forRequest().map(addProductRequest,Product.class);
        productDao.save(product);
        AddProductResponse addProductResponse=modelMapperService.forResponse().map(product,AddProductResponse.class);
        return new SuccessDataResult<>(addProductResponse,messageService.getMessage(Messages.Product.ProductAdded));
    }

    @Override
    public DataResult<UpdateProductResponse> updateProduct(UpdateProductRequest updateProductRequest ){
        // iş kuralı
        Product product=modelMapperService.forRequest().map(updateProductRequest,Product.class);
        product.setId(updateProductRequest.getId());
        productDao.save(product);
        UpdateProductResponse updateProductResponse=modelMapperService.forResponse().map(product,UpdateProductResponse.class);
        return new SuccessDataResult<>(updateProductResponse,messageService.getMessage(Messages.Product.ProductUpdated));
    }

    @Override
    public Result deleteProduct(Integer id){
        productDao.deleteById(id);
        return new SuccessResult(Messages.Product.ProductDeleted);
    }
}
