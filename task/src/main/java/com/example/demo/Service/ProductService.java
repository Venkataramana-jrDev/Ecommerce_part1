package com.example.demo.Service;

import java.util.List;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

public interface ProductService {

	 Product saveProduct(Product product);

	    List<Product> getProducts();

	    Product getProduct(Integer productId) throws ProductNotFoundException;

	    Category getCategory(Integer productId) throws  ProductNotFoundException;
	
}
