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
public class Customer {
    public int id;
    public String fname;
    public String lname;
    public Date birthdate;
    public String mail;
    public long phone;

    public Customer(int id, String fname, String lname, Date birthdate, String mail, long phone) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.birthdate = birthdate;
        this.mail = mail;
        this.phone = phone;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ""+getId()+" "+getFname()+" "+getLname();
    }
    
    
    
}
