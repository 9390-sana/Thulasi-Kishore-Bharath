package com.hotelReservation.full.stack.project.repository;

import com.hotelReservation.full.stack.project.model.Hotel;
import com.hotelReservation.full.stack.project.model.Reservations;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReservationsRepository extends JpaRepository<Reservations,Long> {
    @Query(value = "SELECT u FROM Reservations u WHERE u.reservation_id = :reservation_id")
    Optional<Reservations> findReservationByReservation_id(@Param("reservation_id") Long reservation_id);


}
