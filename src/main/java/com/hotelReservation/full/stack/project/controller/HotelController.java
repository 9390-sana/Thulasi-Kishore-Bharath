package com.hotelReservation.full.stack.project.controller;

import com.hotelReservation.full.stack.project.exception.UserNotFoundException;
import com.hotelReservation.full.stack.project.model.Hotel;
import com.hotelReservation.full.stack.project.model.Reservations;
import com.hotelReservation.full.stack.project.repository.HotelRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")


public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping("/addhotel")
    Hotel newhotel( @RequestBody Hotel newHotel)
    {

        return hotelRepository.save(newHotel);
    }
    @GetMapping("/getHotel")
    List<Hotel> getHotel() {

        return hotelRepository.findAll();
    }

    @GetMapping("/findhotel/{hotel_id}")
    Hotel getHotelByHotel_id(@PathVariable Long hotel_id) {

        return (Hotel) hotelRepository.findById(hotel_id)

                .orElseThrow(() -> new UserNotFoundException(hotel_id));
    }
    @DeleteMapping("/hotel/{hotel_id}")
    String deleteuser(@PathVariable Long hotel_id){
        if(!hotelRepository.existsById(hotel_id)){
            throw new UserNotFoundException(hotel_id);
        }
        hotelRepository.deleteById(hotel_id);
        return "User with is"+hotel_id+"has been deleted";
    }

    @PutMapping("/update/{hotel_id}")
    Hotel updateHotel(@RequestBody Hotel newHotel, @PathVariable Long hotel_id) {
        return hotelRepository.findById(hotel_id).map(user -> {
            user.setHotel_name(newHotel.getHotel_name());
            user.setAddress(newHotel.getAddress());
            user.setCity(newHotel.getCity());
            user.setState(newHotel.getState());
            user.setCountry(newHotel.getCountry());
            user.setPostal_code(newHotel.getPostal_code());
            user.setPhone_number(newHotel.getPhone_number());
            return hotelRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(hotel_id));
    }





}





