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
public class ActivityRequest {
    
    private int customer_id;
    private int activity_id;
    private int branch_id;
    private String approve_status;
    private String customer_name;
    private String activity_name;

    public ActivityRequest(int customer_id, int activity_id, int branch_id, String approve_status, String customer_name, String activity_name) {
        this.customer_id = customer_id;
        this.activity_id = activity_id;
        this.branch_id = branch_id;
        this.approve_status = approve_status;
        this.customer_name = customer_name;
        this.activity_name = activity_name;
    }
    

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(String approve_status) {
        this.approve_status = approve_status;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    @Override
    public String toString() {
        return getActivity_name()+" "+getCustomer_name();
    }
    
    
    
}
