package com.example.demo.serviceImp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Service.ProductService;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	 @Autowired
	    private ProductRepository productRepository;
	    @Override
	    public Product saveProduct(Product product) {

	        product.setCreationDate(""+LocalDate.now()+"");

	        return productRepository.save(product);
	    }

	    @Override
	    public List<Product> getProducts() {
	        return productRepository.findAll();
	    }

	   
	    public Product getProduct(Integer productId) throws ProductNotFoundException {
	        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product Not Found With provided product ID : "+productId));
	    }

	
	    public Category getCategory(Integer productId) throws ProductNotFoundException {
	        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product does not existed with given product ID : "+ productId));
	        if(product.getCategory() != null){
	            return Category.builder()
	                    .categoryId(product.getCategory().getCategoryId())
	                    .categoryName(product.getCategory().getCategoryName())
	                    .build();
	        }
	        return null;
	    }

}
