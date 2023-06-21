package com.hotelReservation.full.stack.project.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long user_id){super("the name does not exist:"+user_id);}
}
