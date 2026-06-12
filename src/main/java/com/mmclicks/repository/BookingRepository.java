package com.mmclicks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmclicks.entity.Booking;

public interface BookingRepository
extends JpaRepository<Booking, Long> {
	  List<Booking> findAllByOrderByCreatedAtDesc();

}