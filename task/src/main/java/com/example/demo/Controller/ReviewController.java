package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.ReviewNotFoundException;
import com.example.demo.Service.ReviewService;
import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/review")
@CrossOrigin("*")
@Slf4j
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
   @Autowired
    ReviewRepository reviewRepository;
    @PostMapping
    public ResponseEntity<Review> review(@RequestBody Review review){
        log.info("review controller..... : review() " + review);
        return ResponseEntity.ok(reviewService.saveReview(review));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Review>> getReviews(){
        log.info("review controller..... : getReviews() " );

        return ResponseEntity.ok(reviewService.getReviews());
    }

    @PostMapping("/{productId}")
    public ResponseEntity<Review> review(@RequestBody Review review, @PathVariable Integer productId){
        log.info("review controller..... : review() with : " + review + "and Product ID : "+ productId);
        return ResponseEntity.ok(reviewService.saveReviewByProductID(review,productId));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Integer productId) throws ReviewNotFoundException {
        log.info("review controller..... : getReviews(productId) : "+productId );

        return ResponseEntity.ok(reviewService.getReviewsByProductId(productId));
    }
    
    
	
    
    @GetMapping("/paginated/{productId}/{page}/{size}")
    public ResponseEntity<Page<Review>> getPaginatedReviews(@PathVariable Integer productId,@PathVariable int page, @PathVariable int size) throws ReviewNotFoundException {
        log.info("review controller..... : getPaginatedReviews(productId) : " + productId);

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(reviewService.getPaginatedReviewsByProductId(productId, pageable));
    }

}
