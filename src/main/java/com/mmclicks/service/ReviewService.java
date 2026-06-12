package com.mmclicks.service;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmclicks.entity.Review;
import com.mmclicks.repository.ReviewRepository;
import java.util.*;

@Service
	public class ReviewService {

	    @Autowired
	    private ReviewRepository repo;

	    public Review saveReview(Review review) {
	        return repo.save(review);
	    }

	    public java.util.List<Review> getAllReviews() {
	        return repo.findAll();
	    }
	    public java.util.List<Review> getLatestReviews() {
	        return repo.findTop3ByOrderByIdDesc();
	    }
	}


