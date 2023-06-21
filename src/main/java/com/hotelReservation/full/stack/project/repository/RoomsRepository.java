package com.hotelReservation.full.stack.project.repository;

import com.hotelReservation.full.stack.project.model.Reservations;
import com.hotelReservation.full.stack.project.model.Rooms;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoomsRepository extends JpaRepository<Rooms,Long> {

    @Query(value = "SELECT u FROM Rooms u WHERE u.room_id = :room_id")
    Optional<Rooms> findRoomsByRoom_id(@Param("room_id") Long room_id);



}
