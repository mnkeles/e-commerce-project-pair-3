package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.ProductAttributeService;

import com.etiya.ecommercepair3.business.dtos.responses.city.UpdateCityResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.AddProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ListProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.ProductAttributeDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.productAttribute.UpdateProductAttributeResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.city.UpdateCityRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.productAttribute.AddProductAttributeRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.productAttribute.UpdateProductAttributeRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-attribute")
@RequiredArgsConstructor
public class ProductAttributesController {
    private final ProductAttributeService productAttributeService;

    @GetMapping()
    public DataResult<List<ListProductAttributeResponse>> getAll(){
        return productAttributeService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<ProductAttributeDetailResponse> getById(@PathVariable Integer id){
        return productAttributeService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<AddProductAttributeResponse> addProductAttribute(AddProductAttributeRequest addProductAttributeRequest){
        return productAttributeService.addProductAttribiute(addProductAttributeRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateProductAttributeResponse>
                        updateProductAttribute(@RequestBody@Valid UpdateProductAttributeRequest updateProductAttributeRequest ){
        return productAttributeService.updateProductAttribute(updateProductAttributeRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteProductAttribute(@PathVariable Integer id){
        return productAttributeService.deleteProductAttribute(id);
    }

}
