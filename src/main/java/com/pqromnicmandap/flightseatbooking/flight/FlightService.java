package com.pqromnicmandap.flightseatbooking.flight;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import com.pqromnicmandap.flightseatbooking.flight.dto.FlightCreationDTO;
import com.pqromnicmandap.flightseatbooking.flight.dto.FlightDTO;

public interface FlightService {

    FlightDTO createFlight(FlightCreationDTO flightCreationDTO);
    FlightDTO getFlight(Long id);

    void incrementSeat(Long id, Constants.Cabin cabin);
    void decrementSeat(Long id, Constants.Cabin cabin);

}
