package com.pqromnicmandap.flightseatbooking.seatbooking;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import com.pqromnicmandap.flightseatbooking.exception.AlreadyAvailableException;
import com.pqromnicmandap.flightseatbooking.exception.AlreadyBookedException;
import com.pqromnicmandap.flightseatbooking.exception.ResourceNotFoundException;
import com.pqromnicmandap.flightseatbooking.flight.Flight;
import com.pqromnicmandap.flightseatbooking.flight.FlightService;
import com.pqromnicmandap.flightseatbooking.flight.dto.FlightDTO;
import com.pqromnicmandap.flightseatbooking.seatbooking.dto.SeatBookingCreationDTO;
import com.pqromnicmandap.flightseatbooking.seatbooking.dto.SeatBookingDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatBookingServiceImpl implements SeatBookingService {

    private final SeatBookingRepository seatBookingRepository;
    private FlightService flightService;

    @Autowired
    public SeatBookingServiceImpl(SeatBookingRepository seatBookingRepository) {
        this.seatBookingRepository = seatBookingRepository;
    }

    @Autowired
    public void setFlightService(FlightService flightService){
        this.flightService = flightService;
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

    @Override
    public SeatBookingDTO getSeatBooking(Long seatBookingId) {
        Optional<SeatBooking> seatBooking = seatBookingRepository.findById(seatBookingId);
        if(seatBooking.isPresent()){
            return convertSeatBookingToSeatBookingDTO(seatBooking.get());
        }
        throw new ResourceNotFoundException("seatBookingId not found: " + seatBookingId);
    }

    @Transactional
    @Override
    public SeatBookingDTO bookSeatBooking(Long seatBookingId) {
        Optional<SeatBooking> seatBooking = seatBookingRepository.findById(seatBookingId);
        if(seatBooking.isPresent()){
            SeatBooking sb = seatBooking.get();
            if(sb.getStatus().equals(Constants.Status.BOOKED)){
                throw new AlreadyBookedException("already booked!");
            }
            sb.setStatus(Constants.Status.BOOKED);
            flightService.decrementSeat(sb.getFlightId(), sb.getCabinType());
            return convertSeatBookingToSeatBookingDTO(seatBookingRepository.save(sb));
        }
        throw new ResourceNotFoundException("seatBookingId not found: " + seatBookingId);
    }

    @Transactional
    @Override
    public SeatBookingDTO cancelSeatBooking(Long seatBookingId) {
        Optional<SeatBooking> seatBooking = seatBookingRepository.findById(seatBookingId);
        if(seatBooking.isPresent()){
            SeatBooking sb = seatBooking.get();
            if(sb.getStatus().equals(Constants.Status.AVAILABLE)){
                throw new AlreadyAvailableException("already available!");
            }
            sb.setStatus(Constants.Status.AVAILABLE);
            flightService.incrementSeat(sb.getFlightId(), sb.getCabinType());
            return convertSeatBookingToSeatBookingDTO(seatBookingRepository.save(sb));
        }
        throw new ResourceNotFoundException("seatBookingId not found: " + seatBookingId);
    }

    private SeatBookingDTO convertSeatBookingToSeatBookingDTO(SeatBooking seatBooking){
        return new SeatBookingDTO(
                seatBooking.getId(),
                seatBooking.getSeatNumber(),
                seatBooking.getCabinType(),
                seatBooking.getSeatLocation(),
                seatBooking.getStatus(),
                seatBooking.getFlightId()
        );
    }




}
