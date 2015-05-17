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
public class Activity {
    int id;
    int branch;
    String name;
    Date start_date;
    Date end_date;
    String info;

    public Activity(int id, int branch, String name, Date start_date, Date end_date, String info) {
        this.id = id;
        this.branch = branch;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return ""+id+" "+name;
    }
    
    
    
    
}
