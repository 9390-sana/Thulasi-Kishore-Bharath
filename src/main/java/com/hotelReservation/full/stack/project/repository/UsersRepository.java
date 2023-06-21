package com.hotelReservation.full.stack.project.repository;

import com.hotelReservation.full.stack.project.model.Rooms;
import com.hotelReservation.full.stack.project.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {



    @Query(value = "SELECT u FROM Users u WHERE u.user_id = :user_id")
    Optional<Users> findUsersByUser_id(@Param("user_id") Long user_id);
}
