package com.pqromnicmandap.flightseatbooking.seatbooking;

import com.pqromnicmandap.flightseatbooking.constants.Constants;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SeatBookingRepository extends JpaRepository<SeatBooking, Long> {

    @Query(value=
            """
                SELECT sb.*
                FROM seat_booking AS sb
                WHERE
                    (:flightId = sb.flight_id) AND
                    (:#{#seatLocation?.name()} IS NULL OR :#{#seatLocation?.name()} = sb.seat_location) AND
                    (:#{#cabinType?.name()} IS NULL OR :#{#cabinType?.name()} = sb.cabin_type)
            """, nativeQuery=true)
    List<SeatBooking> getAllSeatBookings(
            @Param("flightId") Long flightId,
            @Param("seatLocation") Constants.SeatLocation seatLocation,
            @Param("cabinType") Constants.Cabin cabinType,
            Pageable pageable
    );
}
