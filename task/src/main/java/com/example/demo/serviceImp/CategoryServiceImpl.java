package com.example.demo.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.CategoryService;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {

	 @Autowired
	    private CategoryRepository categoryRepository;
	    
	    public Category saveCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	  
	    public List<Category> getCategories() {
	        return categoryRepository.findAll();
	    }

}
