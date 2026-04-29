package com.pqromnicmandap.flightseatbooking.seatbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SeatBookingController {

    private final SeatBookingService seatBookingService;

    @Autowired
    public SeatBookingController(SeatBookingService seatBookingService) {
        this.seatBookingService = seatBookingService;
    }

    @GetMapping(value="/seat-bookings/{id}", produces={"application/json"})
    public ResponseEntity<?> getSeatBooking(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(
                seatBookingService.getSeatBooking(id),
                HttpStatus.OK
        );
    }









}
