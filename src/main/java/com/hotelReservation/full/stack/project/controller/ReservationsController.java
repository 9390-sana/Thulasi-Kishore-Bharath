package com.hotelReservation.full.stack.project.controller;

import com.hotelReservation.full.stack.project.exception.UserNotFoundException;
import com.hotelReservation.full.stack.project.model.Reservations;
import com.hotelReservation.full.stack.project.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class ReservationsController {
    @Autowired
    private ReservationsRepository reservationsRepository;

    @PostMapping("/addreservations")
    Reservations newreservations( @RequestBody Reservations newReservations)
    {

        return reservationsRepository.save(newReservations);
    }
    @GetMapping("/getReservations")
    List<Reservations> getReservations() {

        return reservationsRepository.findAll();
    }

    @GetMapping("/findreservations/{reservation_id}")
    Reservations getReservationsByReservation_id(@PathVariable Long reservation_id) {

        return (Reservations) reservationsRepository.findById(reservation_id)

                .orElseThrow(() -> new UserNotFoundException(reservation_id));
    }
    @DeleteMapping("/reservation/{reservation_id}")
    String deleteuser(@PathVariable Long reservation_id){
        if(!reservationsRepository.existsById(reservation_id)){
            throw new UserNotFoundException(reservation_id);
        }
        reservationsRepository.deleteById(reservation_id);
        return "User with is"+reservation_id+"has been deleted";
    }

    @PutMapping("/update1/{reservation_id}")
    Reservations updateReservations(@RequestBody Reservations newReservations, @PathVariable Long reservation_id) {
        return reservationsRepository.findById(reservation_id).map(user -> {
            user.setReservation_id(newReservations.getReservation_id());
            user.setRoom_id(newReservations.getRoom_id());
            user.setUser_id(newReservations.getUser_id());
            user.setCheck_in_date(newReservations.getCheck_in_date());
            user.setCheck_out_date(newReservations.getCheck_out_date());
            user.setNum_guests(newReservations.getNum_guests());
            user.setTotal_cost(newReservations.getTotal_cost());
            return reservationsRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(reservation_id));
    }



}





