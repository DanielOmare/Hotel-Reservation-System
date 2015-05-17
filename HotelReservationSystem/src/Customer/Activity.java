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
public class Activity {
    public int id;
    public int branch_id;
    public String activity_name;
    public Date start_time;
    public Date end_time;
    public String info;

    public Activity(int id, int branch_id, String activity_name, Date start_time, Date end_time, String info) {
        this.id = id;
        this.branch_id = branch_id;
        this.activity_name = activity_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.info = info;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return ""+id + " " + activity_name;
    }
    
    
    
    
}
