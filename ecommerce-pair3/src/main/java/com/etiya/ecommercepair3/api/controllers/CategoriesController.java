package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.CategoryService;
import com.etiya.ecommercepair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.category.AddCategoryRequest;
import com.etiya.ecommercepair3.entities.concrete.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoryService categoryService;

    @GetMapping()
    public List<ListCategoryResponse> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDetailResponse getAddressById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    public AddCategoryResponse addCategory(@RequestBody@Valid AddCategoryRequest addCategoryRequest){
        return categoryService.addCategory(addCategoryRequest);
    }
}


