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
public class Admin {
    
    String id = null;
    String fname = null;
    String lname = null;
    String mail = null;
    String address = null;
    Date start_date = null;
    String branch_id = null;

    public Admin(String id, String fname, String lname, String mail, String address, Date start_date, String branch_id) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
        this.address = address;
        this.start_date = start_date;
        this.branch_id = branch_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", mail=" + mail + ", address=" + address + ", start_date=" + start_date + ", branch_id=" + branch_id + '}';
    }
    
    
    
}
