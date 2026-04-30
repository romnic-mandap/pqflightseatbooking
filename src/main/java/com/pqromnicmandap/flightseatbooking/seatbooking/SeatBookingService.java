package com.pqromnicmandap.flightseatbooking.seatbooking;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import com.pqromnicmandap.flightseatbooking.seatbooking.dto.SeatBookingCreationDTO;
import com.pqromnicmandap.flightseatbooking.seatbooking.dto.SeatBookingDTO;

import java.util.List;

public interface SeatBookingService {

    void createSeatBooking(SeatBookingCreationDTO seatBookingCreationDTO);
    void createSeatBookingAIRBUS_2090(Long flightId);
    void createSeatBookingAIRBUS_2060(Long flightId);
    void createSeatBookingAIRBUS_2032(Long flightId);

    SeatBookingDTO getSeatBooking(Long seatBookingId);

    SeatBookingDTO bookSeatBooking(Long seatBookingId);
    SeatBookingDTO cancelSeatBooking(Long seatBookingId);

    List<SeatBookingDTO> getAllSeatBookings(
            Long flightId, Constants.SeatLocation seatLocation, Constants.Cabin cabinType, Integer page
    );
}
