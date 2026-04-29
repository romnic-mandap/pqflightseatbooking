package com.pqromnicmandap.flightseatbooking.seatbooking;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import com.pqromnicmandap.flightseatbooking.seatbooking.dto.SeatBookingCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatBookingServiceImpl implements SeatBookingService {

    private final SeatBookingRepository seatBookingRepository;

    @Autowired
    public SeatBookingServiceImpl(SeatBookingRepository seatBookingRepository) {
        this.seatBookingRepository = seatBookingRepository;
    }

    @Override
    public void createSeatBooking(SeatBookingCreationDTO seatBookingCreationDTO) {
        SeatBooking seatBooking = new SeatBooking();
        seatBooking.setSeatNumber(seatBookingCreationDTO.seatNumber());
        seatBooking.setCabinType(seatBookingCreationDTO.cabinType());
        seatBooking.setSeatLocation(seatBookingCreationDTO.seatLocation());
        seatBooking.setStatus(Constants.Status.AVAILABLE);
        seatBooking.setFlightId(seatBookingCreationDTO.flightId());
        seatBookingRepository.save(seatBooking);
    }

    @Override
    public void createSeatBookingAIRBUS_2090(Long flightId) {
        // create business seats row 1-4
        for(int i=1;i<=4;i++){
            createSeatBooking(new SeatBookingCreationDTO(i+"A", Constants.Cabin.BUSINESS, Constants.SeatLocation.WINDOW, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"B", Constants.Cabin.BUSINESS, Constants.SeatLocation.MIDDLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"C", Constants.Cabin.BUSINESS, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"D", Constants.Cabin.BUSINESS, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"E", Constants.Cabin.BUSINESS, Constants.SeatLocation.MIDDLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"F", Constants.Cabin.BUSINESS, Constants.SeatLocation.WINDOW, flightId));
        }
        // create economy seats row 5-15
        for(int i=5;i<=15;i++){
            createSeatBooking(new SeatBookingCreationDTO(i+"A", Constants.Cabin.ECONOMY, Constants.SeatLocation.WINDOW, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"B", Constants.Cabin.ECONOMY, Constants.SeatLocation.MIDDLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"C", Constants.Cabin.ECONOMY, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"D", Constants.Cabin.ECONOMY, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"E", Constants.Cabin.ECONOMY, Constants.SeatLocation.MIDDLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"F", Constants.Cabin.ECONOMY, Constants.SeatLocation.WINDOW, flightId));
        }
    }

    @Override
    public void createSeatBookingAIRBUS_2060(Long flightId) {
        // create business seats row 1-2
        for(int i=1;i<=2;i++){
            createSeatBooking(new SeatBookingCreationDTO(i+"A", Constants.Cabin.BUSINESS, Constants.SeatLocation.WINDOW, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"B", Constants.Cabin.BUSINESS, Constants.SeatLocation.MIDDLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"C", Constants.Cabin.BUSINESS, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"D", Constants.Cabin.BUSINESS, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"E", Constants.Cabin.BUSINESS, Constants.SeatLocation.MIDDLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"F", Constants.Cabin.BUSINESS, Constants.SeatLocation.WINDOW, flightId));
        }
        // create economy seats row 3-10
        for(int i=3;i<=10;i++){
            createSeatBooking(new SeatBookingCreationDTO(i+"A", Constants.Cabin.ECONOMY, Constants.SeatLocation.WINDOW, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"B", Constants.Cabin.ECONOMY, Constants.SeatLocation.MIDDLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"C", Constants.Cabin.ECONOMY, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"D", Constants.Cabin.ECONOMY, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"E", Constants.Cabin.ECONOMY, Constants.SeatLocation.MIDDLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"F", Constants.Cabin.ECONOMY, Constants.SeatLocation.WINDOW, flightId));
        }
    }

    @Override
    public void createSeatBookingAIRBUS_2032(Long flightId) {
        // create business seats row 1-2
        for(int i=1;i<=2;i++){
            createSeatBooking(new SeatBookingCreationDTO(i+"A", Constants.Cabin.BUSINESS, Constants.SeatLocation.WINDOW, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"B", Constants.Cabin.BUSINESS, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"C", Constants.Cabin.BUSINESS, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"D", Constants.Cabin.BUSINESS, Constants.SeatLocation.WINDOW, flightId));
        }
        // create economy seats row 3-8
        for(int i=3;i<=8;i++){
            createSeatBooking(new SeatBookingCreationDTO(i+"A", Constants.Cabin.ECONOMY, Constants.SeatLocation.WINDOW, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"B", Constants.Cabin.ECONOMY, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"C", Constants.Cabin.ECONOMY, Constants.SeatLocation.AISLE, flightId));
            createSeatBooking(new SeatBookingCreationDTO(i+"D", Constants.Cabin.ECONOMY, Constants.SeatLocation.WINDOW, flightId));
        }
    }


}
