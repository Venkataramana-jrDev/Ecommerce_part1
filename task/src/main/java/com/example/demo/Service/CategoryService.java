package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Category;

public interface CategoryService {

	Category saveCategory(Category category);

    List<Category> getCategories();
	
}
