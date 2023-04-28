package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CategoryService;
import com.etiya.ecommercepair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.category.AddCategoryRequest;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.entities.concrete.Category;
import com.etiya.ecommercepair3.repositories.abstracts.CategoryDao;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryDao categoryDao;
    private  final ModelMapperService modelMapperService;
    @Override
    public List<ListCategoryResponse> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public CategoryDetailResponse getCategoryById(Integer id) {
        return categoryDao.getByCategoryId(id);
    }

    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {
       /*if (addCategoryRequest.getName() == null || addCategoryRequest.getName().equals("")) {
            return null;
        }
*/

        Category category=modelMapperService.forRequest().map(addCategoryRequest,Category.class);
        categoryDao.save(category);
        AddCategoryResponse addCategoryResponse=modelMapperService.forResponse().map(category,AddCategoryResponse.class);
        /*
        Category  category=new Category();
        category.setName(addCategoryRequest.getName());
        categoryDao.save(category);
        AddCategoryResponse addCategoryResponse=new AddCategoryResponse(category.getId(), category.getName());

         */

        return addCategoryResponse;
    }
}
