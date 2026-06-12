package com.mmclicks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmclicks.entity.Booking;
import com.mmclicks.repository.BookingRepository;

@Service
	public class BookingService {

	    @Autowired
	    private BookingRepository repo;

	    public Booking saveBooking(
	            Booking booking) {

	        return repo.save(booking);
	    }
	}


