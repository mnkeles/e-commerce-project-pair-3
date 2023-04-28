package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.category.AddCategoryRequest;

import java.util.List;

public interface CategoryService {

    List<ListCategoryResponse> getAll();
    CategoryDetailResponse getCategoryById(Integer id);

    AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest);
}
