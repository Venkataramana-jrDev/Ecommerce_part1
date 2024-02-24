package com.example.demo.Exceptions;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(String msg){
       
        System.out.println(msg);
    }
	
}
