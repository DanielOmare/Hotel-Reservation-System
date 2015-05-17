package Employee;

import java.sql.Timestamp;

/**
 *
 * @author Anar
 */
public class LoginEmployee {
    private int id;
    private String fname;
    private String lname;
    private String type;
    private Timestamp time;

    public LoginEmployee(int id, String fname, String lname, String type, Timestamp time) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.type = type;
        this.time = time;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return getFname()+"   "+getType()+"   "+getTime().toString();
    }
    
    
}
