package com.hotelReservation.full.stack.project.repository;

import com.hotelReservation.full.stack.project.model.Hotel;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface
HotelRepository extends JpaRepository<Hotel,Long> {
   @Query(value = "SELECT u FROM Hotel u WHERE u.hotel_id = :hotel_id")
    Optional<Hotel> findHotelByHotel_id(@Param("hotel_id") Long hotel_id);


}
