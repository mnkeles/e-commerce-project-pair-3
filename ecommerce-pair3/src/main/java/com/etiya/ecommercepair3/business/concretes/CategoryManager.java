package com.etiya.ecommercepair3.business.concretes;

import com.etiya.ecommercepair3.business.abstracts.CategoryService;
import com.etiya.ecommercepair3.entities.concrete.Category;
import com.etiya.ecommercepair3.repositories.abstracts.CategoryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;
    @Override
    public List<Category> getAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryDao.getById(id);
    }

    @Override
    public void addCategory(Category category) {
        Category category1=categoryDao.getByName(category.getName());
        if(category1!=null){
            return;
        }
        categoryDao.save(category);
    }
}
