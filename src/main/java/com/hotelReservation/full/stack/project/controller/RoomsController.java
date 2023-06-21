package com.hotelReservation.full.stack.project.controller;

import com.hotelReservation.full.stack.project.exception.UserNotFoundException;
import com.hotelReservation.full.stack.project.model.Rooms;
import com.hotelReservation.full.stack.project.model.Users;
import com.hotelReservation.full.stack.project.repository.RoomsRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class RoomsController {
    @Autowired
    private RoomsRepository roomsRepository;

    @PostMapping("/addrooms")
    Rooms newrooms( @RequestBody Rooms newRooms)
    {

        return roomsRepository.save(newRooms);
    }
    @GetMapping("/getRooms")
    List<Rooms> getRooms() {

        return roomsRepository.findAll();
    }

    @GetMapping("/findrooms/{room_id}")
    Rooms getRoomsByRoom_id(@PathVariable Long room_id) {

        return (Rooms) roomsRepository.findById(room_id)

                .orElseThrow(() -> new UserNotFoundException(room_id));
    }
    @DeleteMapping("/rooms/{room_id}")
    String deleteuser(@PathVariable Long room_id){
        if(!roomsRepository.existsById(room_id)){
            throw new UserNotFoundException(room_id);
        }
        roomsRepository.deleteById(room_id);
        return "User with is"+room_id+"has been deleted";
    }

    @PutMapping("/update2/{room_id}")
    Rooms updateRooms(@RequestBody Rooms newRooms, @PathVariable Long room_id) {
        return roomsRepository.findById(room_id).map(user -> {
            user.setRoom_id(newRooms.getRoom_id());
            user.setHotel_id(newRooms.getHotel_id());
            user.setRoom_number(newRooms.getRoom_number());
            user.setRoom_type(newRooms.getRoom_type());
            user.setCapacity(newRooms.getCapacity());
            user.setRate(newRooms.getRate());
            return roomsRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(room_id));
    }



}





