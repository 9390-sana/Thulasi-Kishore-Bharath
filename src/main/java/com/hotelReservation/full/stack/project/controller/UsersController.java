package com.hotelReservation.full.stack.project.controller;



import com.hotelReservation.full.stack.project.exception.UserNotFoundException;
import com.hotelReservation.full.stack.project.model.Users;
import com.hotelReservation.full.stack.project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UsersController {
    @Autowired
    public UsersRepository usersRepository;

    @PostMapping("/addusers")
    Users newusers( @RequestBody Users newUsers)
    {

        return usersRepository.save(newUsers);
    }
    @GetMapping("/getUsers")
    List<Users> getUsers() {

        return usersRepository.findAll();
    }



    @GetMapping("/findusers/{user_id}")
    Users getUsersByUser_id(@PathVariable Long user_id) {
        return (Users) usersRepository.findById(user_id)

                .orElseThrow(() -> new UserNotFoundException(user_id));
    }
    @DeleteMapping("/user/{user_id}")
    String deleteuser(@PathVariable Long user_id){
        if(!usersRepository.existsById(user_id)){
            throw new UserNotFoundException(user_id);
        }
        usersRepository.deleteById(user_id);
        return "User with is"+user_id+"has been deleted";
    }

    @PutMapping("/update3/{user_id}")
    Users updateUser(@RequestBody Users newUsers, @PathVariable Long user_id) {
        return usersRepository.findById(user_id).map(user -> {
            user.setUser_id(newUsers.getUser_id());
            user.setFirst_name(newUsers.getFirst_name());
            user.setLast_name(newUsers.getLast_name());
            user.setEmail(newUsers.getEmail());
            return usersRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(user_id));
    }

}
