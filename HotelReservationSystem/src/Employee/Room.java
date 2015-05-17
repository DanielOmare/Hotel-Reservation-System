/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Employee;

/**
 *
 * @author Anar
 */
public class Room {
    
    private int branch_id;
    private int room_number;
    private String room_name;
    private int max_guests;
    private int total_rooms;
    private int price;
    
    public Room(int room_number, String room_name, int max_guests, int total_rooms, int price) {
        this.room_number = room_number;
        this.room_name = room_name;
        this.max_guests = max_guests;
        this.total_rooms = total_rooms;
        this.price = price;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }
    

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getMax_guests() {
        return max_guests;
    }

    public void setMax_guests(int max_guests) {
        this.max_guests = max_guests;
    }

    public int getTotal_rooms() {
        return total_rooms;
    }

    public void setTotal_rooms(int total_rooms) {
        this.total_rooms = total_rooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getBranch_id()+" "+getRoom_number()+" "+getRoom_name();
    }
    
    
}
