package com.etiya.ecommercepair3.business.abstracts;


import com.etiya.ecommercepair3.entities.concrete.Address;
import com.etiya.ecommercepair3.entities.concrete.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category getCategoryById(Integer id);

    void addCategory(Category category);
}
