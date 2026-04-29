package com.pqromnicmandap.flightseatbooking.seatbooking;

import com.pqromnicmandap.flightseatbooking.seatbooking.dto.SeatBookingCreationDTO;

public interface SeatBookingService {

    void createSeatBooking(SeatBookingCreationDTO seatBookingCreationDTO);
    void createSeatBookingAIRBUS_2090(Long flightId);
    void createSeatBookingAIRBUS_2060(Long flightId);
    void createSeatBookingAIRBUS_2032(Long flightId);

}
