package com.pqromnicmandap.flightseatbooking.flight;

import com.pqromnicmandap.flightseatbooking.flight.dto.FlightCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

/*
@PostMapping(value="/meals", consumes={"application/json"}, produces={"application/json"})
    public ResponseEntity<?> addMealItem(
            @AuthenticationPrincipal User user,
            @RequestBody @Valid MealItemCreationDTO mealItemCreationDTO
    ){
        return new ResponseEntity<>(
                new MealItemCreationResponseDTO(
                        mealItemService.createMealItem(user, mealItemCreationDTO)
                ),
                HttpStatus.CREATED
        );
    }
 */