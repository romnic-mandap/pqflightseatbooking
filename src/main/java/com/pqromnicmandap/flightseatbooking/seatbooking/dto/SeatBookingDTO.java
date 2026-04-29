package com.pqromnicmandap.flightseatbooking.seatbooking.dto;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record SeatBookingDTO(
        Long id,
        String seatNumber,
        @Enumerated(EnumType.STRING)
        Constants.Cabin cabinType,
        @Enumerated(EnumType.STRING)
        Constants.SeatLocation seatLocation,
        @Enumerated(EnumType.STRING)
        Constants.Status status,
        Long flightId
) {
}
