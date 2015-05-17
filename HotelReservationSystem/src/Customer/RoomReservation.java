/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Customer;

import java.util.Date;

/**
 *
 * @author Anar
 */
public class RoomReservation {
    
    public int room_number;
    public int branch_id;
    public Date arrival_date;
    public Date departure_date;
    public int price;
    public String approve_status;

    public RoomReservation(int room_number, int branch_id, Date arrival_date, Date departure_date, int price, String approve_status) {
        this.room_number = room_number;
        this.branch_id = branch_id;
        this.arrival_date = arrival_date;
        this.departure_date = departure_date;
        this.price = price;
        this.approve_status = approve_status;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(String approve_status) {
        this.approve_status = approve_status;
    }

    @Override
    public String toString() {
        return "Branch "+getBranch_id()+" Room "+getRoom_number();
    }
    
    
    
    
}
