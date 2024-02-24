package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	 @Query(value = "SELECT review.* FROM review JOIN product ON review.product_id = product.product_id WHERE product.product_id =:product_id",nativeQuery = true)
	    List<Review> findAllByProductId(@Param("product_id") Integer productId);
        
	 Page<Review> findByProductProductId(Integer productId, Pageable pageable);
}
