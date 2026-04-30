package com.pqromnicmandap.flightseatbooking.seatbooking;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(value="/seat-bookings", produces={"application/json"})
    public ResponseEntity<?> getAllSeatBookings(
            @RequestParam(required=true) Long flightId,
            @RequestParam Optional<Integer> p,
            @RequestParam Optional<Constants.SeatLocation> seatLocation,
            @RequestParam Optional<Constants.Cabin> cabinType
    ){
        Integer page = p.orElse(0);
        return new ResponseEntity<>(
                seatBookingService.getAllSeatBookings(
                        flightId, seatLocation.orElse(null), cabinType.orElse(null), page
                ),
                HttpStatus.OK
        );
    }

    @PutMapping(value="/seat-bookings/{id}/book", produces={"application/json"})
    public ResponseEntity<?> bookSeatBooking(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(
                seatBookingService.bookSeatBooking(id),
                HttpStatus.OK
        );
    }

    @PutMapping(value="/seat-bookings/{id}/cancel", produces={"application/json"})
    public ResponseEntity<?> cancelSeatBooking(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(
                seatBookingService.cancelSeatBooking(id),
                HttpStatus.OK
        );
    }









}
