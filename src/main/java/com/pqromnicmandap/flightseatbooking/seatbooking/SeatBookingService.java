package com.pqromnicmandap.flightseatbooking.seatbooking;

import com.pqromnicmandap.flightseatbooking.seatbooking.dto.SeatBookingCreationDTO;
import com.pqromnicmandap.flightseatbooking.seatbooking.dto.SeatBookingDTO;

public interface SeatBookingService {

    void createSeatBooking(SeatBookingCreationDTO seatBookingCreationDTO);
    void createSeatBookingAIRBUS_2090(Long flightId);
    void createSeatBookingAIRBUS_2060(Long flightId);
    void createSeatBookingAIRBUS_2032(Long flightId);

    SeatBookingDTO getSeatBooking(Long seatBookingId);
}
