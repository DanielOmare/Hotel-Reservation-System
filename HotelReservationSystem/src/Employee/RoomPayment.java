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
public class RoomPayment {
    private int room_number;
    private int branch_id;
    private int payment_amount;
    

    public RoomPayment(int room_number, int branch_id, int payment_amount) {
        this.room_number = room_number;
        this.branch_id = branch_id;
        this.payment_amount = payment_amount;
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

    public int getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(int payment_amount) {
        this.payment_amount = payment_amount;
    }

    @Override
    public String toString() {
        return "Room : "+getRoom_number()+ " Branch : "+getBranch_id()+" Total Income : "+getPayment_amount();
    }
    
    
    
    
}
