/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Employee;

import java.util.Date;

/**
 *
 * @author Anar
 */
public class Reservation {
    
    public int customer_id;
    public int room_number;
    public int branch_id;
    public Date arrive_date;
    public Date departure_date;
    public int daily_price;
    public String approve_status;

    public Reservation(int customer_id, int room_number, int branch_id, Date arrive_date, Date departure_date, int daily_price, String approve_status) {
        this.customer_id = customer_id;
        this.room_number = room_number;
        this.branch_id = branch_id;
        this.arrive_date = arrive_date;
        this.departure_date = departure_date;
        this.daily_price = daily_price;
        this.approve_status = approve_status;
    }
    

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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

    public Date getArrive_date() {
        return arrive_date;
    }

    public void setArrive_date(Date arrive_date) {
        this.arrive_date = arrive_date;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public int getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(int daily_price) {
        this.daily_price = daily_price;
    }

    public String getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(String approve_status) {
        this.approve_status = approve_status;
    }

    @Override
    public String toString() {
        return customer_id + " "+room_number;
    }
    
    
    
    
    
}
