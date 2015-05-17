/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Customer;

/**
 *
 * @author Anar
 */
public class Room {
    public int roomnumber;
    public String roomtypename;
    public int max_guests;
    public int total_rooms;
    public int price;

    public Room(int roomnumber, String roomtypename, int max_guests, int total_rooms, int price) {
        this.roomnumber = roomnumber;
        
        this.roomtypename = roomtypename;
        this.max_guests = max_guests;
        this.total_rooms = total_rooms;
        this.price = price;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }


    public String getRoomtypename() {
        return roomtypename;
    }

    public void setRoomtypename(String roomtypename) {
        this.roomtypename = roomtypename;
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
        return ""+getRoomnumber()+" "+getRoomtypename();
    }
    
    
    
}
