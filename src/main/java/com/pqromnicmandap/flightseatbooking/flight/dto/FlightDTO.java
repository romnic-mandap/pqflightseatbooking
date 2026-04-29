package com.pqromnicmandap.flightseatbooking.flight.dto;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record FlightDTO(
    Long id,
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    LocalDate departureDate,
    String origin,
    String destination,
    @Enumerated(EnumType.STRING)
    Constants.Plane plane,
    @Enumerated(EnumType.STRING)
    Constants.Airline airline,
    Integer availableBusinessSeats,
    Integer availableEconomySeats
) {
}
