package com.pqromnicmandap.flightseatbooking.flight;

import com.pqromnicmandap.flightseatbooking.flight.dto.FlightCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping(value="/flights", consumes={"application/json"}, produces={"application/json"})
    public ResponseEntity<?> createFlight(
            @RequestBody FlightCreationDTO flightCreationDTO
            ){
        return new ResponseEntity<>(
                flightService.createFlight(flightCreationDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping(value="/flights/{id}", produces={"application/json"})
    public ResponseEntity<?> getFlight(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(
                flightService.getFlight(id),
                HttpStatus.OK
        );
    }

    @GetMapping(value="/flights", produces={"application/json"})
    public ResponseEntity<?> getFlights(
            @RequestParam(required=true) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required=true) String origin,
            @RequestParam(required=true) String destination
            ){
        return new ResponseEntity<>(
                flightService.getFlights(date, origin, destination),
                HttpStatus.OK
        );
    }

}