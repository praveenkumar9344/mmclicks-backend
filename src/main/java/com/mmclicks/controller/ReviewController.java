package com.mmclicks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmclicks.entity.Review;
import com.mmclicks.service.ReviewService;

@RestController
	@RequestMapping("/api/reviews")
	@CrossOrigin(origins = "http://localhost:3000")
	public class ReviewController {

	    @Autowired
	    private ReviewService service;

	    @PostMapping
	    public Review saveReview(
	            @RequestBody Review review) {

	        return service.saveReview(review);
	    }

	  
	    @GetMapping
	    public List<Review> getReviews() {
	        return service.getLatestReviews();
	    }
	}


