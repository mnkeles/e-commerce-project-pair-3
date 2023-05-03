package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CategoryService;
import com.etiya.ecommercepair3.business.constants.Messages;
import com.etiya.ecommercepair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.CategoryDetailResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercepair3.business.dtos.resquests.category.AddCategoryRequest;
import com.etiya.ecommercepair3.business.dtos.resquests.category.UpdateCategoryRequest;
import com.etiya.ecommercepair3.core.internationalization.MessageService;
import com.etiya.ecommercepair3.core.utils.maping.ModelMapperService;
import com.etiya.ecommercepair3.core.utils.results.DataResult;
import com.etiya.ecommercepair3.core.utils.results.Result;
import com.etiya.ecommercepair3.core.utils.results.SuccessDataResult;
import com.etiya.ecommercepair3.core.utils.results.SuccessResult;
import com.etiya.ecommercepair3.entities.concretes.Category;
import com.etiya.ecommercepair3.repositories.abstracts.CategoryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryDao categoryDao;
    private  final ModelMapperService modelMapperService;
    private final MessageService messageService;
    @Override
    public DataResult<Slice<ListCategoryResponse>> getAll(Pageable pageable) {
        return new SuccessDataResult<>(categoryDao.getAll(pageable),
                messageService.getMessage(Messages.Category.CategoryGetAll)) ;

    }

    @Override
    public DataResult<CategoryDetailResponse> getCategoryById(Integer id) {
        return new SuccessDataResult<>(categoryDao.getByCategoryId(id),
                messageService.getMessage(Messages.Category.CategoryGetById));
    }

    @Override
    public DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest) {
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

        return new SuccessDataResult<>(addCategoryResponse,
                messageService.getMessage(Messages.Category.CategoryAdded));
    }

    @Override
    public DataResult<UpdateCategoryResponse> updateCategoryResponse(UpdateCategoryRequest updateCategoryRequest){
        // iş kuralı
        Category category=modelMapperService.forRequest().map(updateCategoryRequest,Category.class);
        category.setId(updateCategoryRequest.getId());
        categoryDao.save(category);
        UpdateCategoryResponse updateCategoryResponse=modelMapperService.forResponse().map(category,UpdateCategoryResponse.class);
        return new SuccessDataResult<>(updateCategoryResponse,
                messageService.getMessage(Messages.Category.CategoryUpdated));

    }

    @Override
    public Result deleteCategory(Integer id){
        categoryDao.deleteById(id);
        return new SuccessResult(messageService.getMessage(Messages.Category.CategoryDeleted));
    }
}
