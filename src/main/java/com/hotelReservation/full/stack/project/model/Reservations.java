package com.hotelReservation.full.stack.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservations {
    @Id
    @GeneratedValue
    private Long reservation_id;
    private Long room_id;
    private Long user_id;
    private String check_in_date;
    private String check_out_date;

    private Long num_guests;
    private Long total_cost;

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }

    public Long getNum_guests() {
        return num_guests;
    }

    public void setNum_guests(Long num_guests) {
        this.num_guests = num_guests;
    }

    public Long getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Long total_cost) {
        this.total_cost = total_cost;
    }
}

