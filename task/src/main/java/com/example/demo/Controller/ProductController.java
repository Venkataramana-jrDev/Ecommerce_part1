package com.example.demo.Controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Service.ProductService;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> product(@RequestBody Product product)   {
        log.info("product controller..... : product() "+product);
    	
    	
    	   

        return ResponseEntity.ok(productService.saveProduct(product));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts(){
        log.info("product controller..... : getProducts " );

        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> product(@PathVariable Integer productId) throws ProductNotFoundException {
        log.info("product controller..... : product() productId:- " + productId);

        return ResponseEntity.ok(productService.getProduct(productId));
    }
    @GetMapping("/category/{productId}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer productId) throws ProductNotFoundException {
        log.info("product controller..... : getCategory() productId:- " + productId);

        return ResponseEntity.status(HttpStatus.OK).body(productService.getCategory(productId));
    }
}

