package com.pqromnicmandap.flightseatbooking.flight;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value=
            """
                SELECT f.*
                FROM flight AS f
                WHERE
                    (:d = f.departure_date) AND
                    (:origin = f.origin) AND
                    (:destination = f.destination)
            """, nativeQuery=true)
    List<Flight> getAllFlights(
            @Param("d") LocalDate date,
            @Param("origin") String origin,
            @Param("destination") String destination
    );

}
