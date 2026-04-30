package com.pqromnicmandap.flightseatbooking.flight;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import com.pqromnicmandap.flightseatbooking.flight.dto.FlightCreationDTO;
import com.pqromnicmandap.flightseatbooking.flight.dto.FlightDTO;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {

    FlightDTO createFlight(FlightCreationDTO flightCreationDTO);
    FlightDTO getFlight(Long id);

    List<FlightDTO> getFlights(LocalDate date, String origin, String destination);

    void incrementSeat(Long id, Constants.Cabin cabin);
    void decrementSeat(Long id, Constants.Cabin cabin);

}
