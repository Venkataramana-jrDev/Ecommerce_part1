package com.example.demo.serviceImp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Exceptions.ReviewNotFoundException;
import com.example.demo.Service.ReviewService;
import com.example.demo.entity.Product;
import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;
@Service
public class ReviewServiceImpl implements ReviewService {

	 @Autowired
	    private ReviewRepository reviewRepository;
	 
	    @Override
	    public Review saveReview(Review review) {

	        review.setReviewDate(""+ LocalDate.now());
	        return reviewRepository.save(review);
	    }

	    @Override
	    public List<Review> getReviews() {
	        return reviewRepository.findAll();
	    }

	    @Override
	    public Review saveReviewByProductID(Review review, Integer productId) {
	        Product product = new Product();
	        product.setProductId(productId);
	        review.setProduct(product);
	        review.setReviewDate(""+LocalDate.now());
	        return reviewRepository.save(review);
	    }

	    @Override
	    public List<Review> getReviewsByProductId(Integer productId) throws ReviewNotFoundException {
	        List<Review> reviews = reviewRepository.findAllByProductId(productId);
	        if(reviews.size() == 0){
	            throw new ReviewNotFoundException("Reviews Not found for the given Product Id : "+productId);
	        }
	        return reviews.stream().toList();
	    }

	    @Override
	    public Page<Review> getPaginatedReviewsByProductId(Integer productId, Pageable pageable) throws ReviewNotFoundException {
	        return reviewRepository.findByProductProductId(productId, pageable);
	    }
	    
	    
	
}
