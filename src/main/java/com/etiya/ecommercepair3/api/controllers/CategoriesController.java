package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CategoryService;
import com.etiya.ecommercepair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.category.AddCategoryRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.category.UpdateCategoryRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoryService categoryService;

    @GetMapping()
    public DataResult<Slice<ListCategoryResponse>> getAll(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return categoryService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public DataResult<CategoryDetailResponse> getAddressById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    public DataResult<AddCategoryResponse> addCategory(@RequestBody@Valid AddCategoryRequest addCategoryRequest){
        return categoryService.addCategory(addCategoryRequest);
    }

    @PutMapping("/update")
    private DataResult<UpdateCategoryResponse> updateCategory(@RequestBody@Valid UpdateCategoryRequest updateCategoryRequest){
        return categoryService.updateCategoryResponse(updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    private Result deleteCategory(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }
}


