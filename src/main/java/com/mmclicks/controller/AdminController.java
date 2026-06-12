package com.mmclicks.controller;

import com.mmclicks.entity.Booking;
import com.mmclicks.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private BookingRepository bookingRepository;

    // GET all bookings
    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAllByOrderByCreatedAtDesc();
    }

    // PATCH booking status
    @PatchMapping("/bookings/{id}/status")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {

        String newStatus = body.get("status");
        if (newStatus == null || newStatus.isBlank()) {
            Map<String, Object> err = new HashMap<>();
            err.put("success", false);
            err.put("message", "Status is required");
            return ResponseEntity.badRequest().body(err);
        }

        return bookingRepository.findById(id).map(booking -> {
            booking.setStatus(newStatus.toUpperCase());
            bookingRepository.save(booking);

            Map<String, Object> res = new HashMap<>();
            res.put("success", true);
            res.put("message", "Status updated to " + newStatus);
            return ResponseEntity.ok(res);

        }).orElse(ResponseEntity.notFound().build());
    }

    // POST mark WhatsApp as sent
    @PostMapping("/bookings/{id}/send-whatsapp")
    public ResponseEntity<?> markWhatsAppSent(@PathVariable Long id) {

        return bookingRepository.findById(id).map(booking -> {
            booking.setWhatsappSent(true);
            bookingRepository.save(booking);

            Map<String, Object> res = new HashMap<>();
            res.put("success", true);
            res.put("message", "WhatsApp marked as sent");
            return ResponseEntity.ok(res);

        }).orElse(ResponseEntity.notFound().build());
    }
}