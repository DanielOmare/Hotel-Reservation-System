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
public class Employee {
    int id;
    String address;
    String mail;
    String type;
    int branch;
    String fname;
    String lname;

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
    String start_date;
    public Employee(int id,String fname, String lname, String mail, String address, String type, int branch) {
        this.id = id;
        this.address = address;
        this.mail = mail;
        this.type = type;
        this.branch = branch;
        this.fname = fname;
        this.lname = lname;
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
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

    @Override
    public String toString() {
        return getId()+" "+getFname()+" "+getLname();
    }
    
    
}
