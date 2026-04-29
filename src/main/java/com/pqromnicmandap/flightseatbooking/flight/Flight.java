package com.pqromnicmandap.flightseatbooking.flight;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="flight")
public class Flight {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  // yyyy-mm-dd
    @Column(name="departure_date")
    private LocalDate departureDate;

    @Column(name="origin")
    private String origin;

    @Column(name="destination")
    private String destination;

    @Enumerated(EnumType.STRING)
    @Column(name="plane", columnDefinition="ENUM('AIRBUS_2090','AIRBUS_2060','AIRBUS_2032')")
    private Constants.Plane plane;

    @Enumerated(EnumType.STRING)
    @Column(name="airline", columnDefinition="ENUM('QANTAS','PANAM','PACIFIC')")
    private Constants.Airline airline;

    @Column(name="available_business_seats")
    private Integer availableBusinessSeats;

    @Column(name="available_economy_seats")
    private Integer availableEconomySeats;

}
