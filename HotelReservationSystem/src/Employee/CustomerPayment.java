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
public class CustomerPayment {
    private int customer_id;
    private String fname;
    private String lname;
    private int visitCount;
    private int totalPayment;

    public CustomerPayment(int customer_id, String fname, String lname, int visitCount, int totalPayment) {
        this.customer_id = customer_id;
        this.fname = fname;
        this.lname = lname;
        this.visitCount = visitCount;
        this.totalPayment = totalPayment;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "ID : " + customer_id + " Name : " + fname;
    }
    
    
}
