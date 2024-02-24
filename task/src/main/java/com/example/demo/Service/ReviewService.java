package com.example.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Exceptions.ReviewNotFoundException;
import com.example.demo.entity.Review;

public interface ReviewService {

	Review saveReview(Review review);

    List<Review> getReviews();

    Review saveReviewByProductID(Review review, Integer productId);

    List<Review> getReviewsByProductId(Integer productId) throws ReviewNotFoundException;
    
    Page<Review> getPaginatedReviewsByProductId(Integer productId, Pageable pageable) throws ReviewNotFoundException;
    
	
}
