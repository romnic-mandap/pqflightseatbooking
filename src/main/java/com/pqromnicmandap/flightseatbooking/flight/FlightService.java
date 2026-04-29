package com.pqromnicmandap.flightseatbooking.flight;

import com.pqromnicmandap.flightseatbooking.flight.dto.FlightCreationDTO;
import com.pqromnicmandap.flightseatbooking.flight.dto.FlightDTO;

public interface FlightService {

    FlightDTO createFlight(FlightCreationDTO flightCreationDTO);
    FlightDTO getFlight(Long id);

}
