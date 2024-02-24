package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CategoryService;
import com.example.demo.entity.Category;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService ;

    @PostMapping
    public ResponseEntity<Category> category(@RequestBody Category category){
        log.info("entered into category controller..... : category() " + category);
        

        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategories(){
        log.info("entered into category controller..... : getCategories " );

        return ResponseEntity.ok(categoryService.getCategories());
    }
}

