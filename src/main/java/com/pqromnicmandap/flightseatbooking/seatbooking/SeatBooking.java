package com.pqromnicmandap.flightseatbooking.seatbooking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pqromnicmandap.flightseatbooking.constants.Constants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="seat_booking")
public class SeatBooking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="seat_number")  // 1A 1B etc...
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="cabin_type", columnDefinition="ENUM('ECONOMY','BUSINESS')")
    private Constants.Cabin cabinType;

    @Enumerated(EnumType.STRING)
    @Column(name="seat_location", columnDefinition="ENUM('WINDOW','MIDDLE','AISLE')")
    private Constants.SeatLocation seatLocation;

    @Enumerated(EnumType.STRING)
    @Column(name="status", columnDefinition="ENUM('AVAILABLE','BOOKED')")
    private Constants.Status status;

    @Column(name="flight_id")  // Flight id
    private Long flightId;

}
