package com.etiya.ecommercepair3.api.controllers;

import com.etiya.ecommercepair3.business.abstracts.AddressService;
import com.etiya.ecommercepair3.business.abstracts.CategoryService;
import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.entities.concrete.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getAddressById(Integer id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    public void addCategory(Category category){
        categoryService.addCategory(category);
    }
}


