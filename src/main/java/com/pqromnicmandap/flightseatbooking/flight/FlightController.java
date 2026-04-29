package com.pqromnicmandap.flightseatbooking.flight;

import com.pqromnicmandap.flightseatbooking.flight.dto.FlightCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}