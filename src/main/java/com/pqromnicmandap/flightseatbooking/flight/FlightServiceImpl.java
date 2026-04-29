package com.pqromnicmandap.flightseatbooking.flight;

import com.pqromnicmandap.flightseatbooking.flight.dto.FlightCreationDTO;
import com.pqromnicmandap.flightseatbooking.flight.dto.FlightDTO;
import com.pqromnicmandap.flightseatbooking.seatbooking.SeatBookingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final SeatBookingService seatBookingService;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, SeatBookingService seatBookingService) {
        this.flightRepository = flightRepository;
        this.seatBookingService = seatBookingService;
    }




    public static final Integer AIRBUS_2090_SEATS = 90;
    public static final Integer AIRBUS_2090_BUSINESS_SEATS = 24;
    public static final Integer AIRBUS_2090_ECONOMY_SEATS = 66;

    public static final Integer AIRBUS_2060_SEATS = 60;
    public static final Integer AIRBUS_2060_BUSINESS_SEATS = 12;
    public static final Integer AIRBUS_2060_ECONOMY_SEATS = 48;

    public static final Integer AIRBUS_2032_SEATS = 32;
    public static final Integer AIRBUS_2032_BUSINESS_SEATS = 8;
    public static final Integer AIRBUS_2032_ECONOMY_SEATS = 24;


    @Transactional
    @Override
    public FlightDTO createFlight(FlightCreationDTO flightCreationDTO) {
        Flight flight = new Flight();
        flight.setDepartureDate(flightCreationDTO.departureDate());
        flight.setOrigin(flightCreationDTO.origin());
        flight.setDestination(flightCreationDTO.destination());
        flight.setPlane(flightCreationDTO.plane());
        flight.setAirline(flightCreationDTO.airline());
        switch (flightCreationDTO.plane()) {
            case AIRBUS_2090:
                flight.setAvailableBusinessSeats(AIRBUS_2090_BUSINESS_SEATS);
                flight.setAvailableEconomySeats(AIRBUS_2090_ECONOMY_SEATS);
                break;
            case AIRBUS_2060:
                flight.setAvailableBusinessSeats(AIRBUS_2060_BUSINESS_SEATS);
                flight.setAvailableEconomySeats(AIRBUS_2060_ECONOMY_SEATS);
                break;
            case AIRBUS_2032:
                flight.setAvailableBusinessSeats(AIRBUS_2032_BUSINESS_SEATS);
                flight.setAvailableEconomySeats(AIRBUS_2032_ECONOMY_SEATS);
                break;
            default:
                flight.setAvailableBusinessSeats(0);
                flight.setAvailableEconomySeats(0);
        }
        Flight savedFlight = flightRepository.save(flight);

        switch (savedFlight.getPlane()){
            case AIRBUS_2090:
                seatBookingService.createSeatBookingAIRBUS_2090(savedFlight.getId());
                break;
            case AIRBUS_2060:
                seatBookingService.createSeatBookingAIRBUS_2060(savedFlight.getId());
                break;
            case AIRBUS_2032:
                seatBookingService.createSeatBookingAIRBUS_2032(savedFlight.getId());
                break;
            default:

        }

        return convertFlightToFlightDTO(savedFlight);
    }

    private FlightDTO convertFlightToFlightDTO(Flight flight){
        return new FlightDTO(
                flight.getId(),
                flight.getDepartureDate(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getPlane(),
                flight.getAirline(),
                flight.getAvailableBusinessSeats(),
                flight.getAvailableEconomySeats()
        );
    }
}
