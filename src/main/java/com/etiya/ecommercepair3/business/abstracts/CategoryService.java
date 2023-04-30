package com.etiya.ecommercepair3.business.abstracts;

import com.etiya.ecommercepair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.category.AddCategoryRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.category.UpdateCategoryRequest;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;

import java.util.List;

public interface CategoryService {

    DataResult<List<ListCategoryResponse>> getAll();
    DataResult<CategoryDetailResponse> getCategoryById(Integer id);

    DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest);

    DataResult<UpdateCategoryResponse> updateCategoryResponse(UpdateCategoryRequest updateCategoryRequest);

    Result deleteCategory(Integer id);
}
