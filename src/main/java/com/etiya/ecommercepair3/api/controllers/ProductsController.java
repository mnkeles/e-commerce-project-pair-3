package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.ProductService;

import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.product.UpdateProductResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.product.AddProductRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.product.UpdateProductRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductsController {
    private ProductService productService;
    @GetMapping()
    public DataResult<List<ListProductResponse>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<ProductDetailResponse> getById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddProductResponse> addStreet(AddProductRequest addProductRequest){
        return productService.addProduct(addProductRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateProductResponse> updateProduct(@RequestBody@Valid UpdateProductRequest updateProductRequest){
        return productService.updateProduct(updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
}
