package Employee;
import Customer.Branch;
import Customer.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Database {
    String userName = "myhotel";
    String password = "123456";
    private Connection dbConnection;
    
    public int openConnection()
    {
        try {
            dbConnection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",userName, password);
        } catch (SQLException ex) {
            
           return -1;
        }
        return 0;
    }
    public ResultSet getResultOfQuery( String query)
    {
        ResultSet rs=null;
        try {
          
            PreparedStatement ps = dbConnection.prepareStatement(query);
            rs = ps.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ArrayList<Branch> getBranch()
    {
        ArrayList<Branch> branches = new ArrayList<Branch>();
        try {
            
            String query = "select branch_id, branch_name, branch_location from branch";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Branch branch = new Branch(rs.getInt(1), rs.getString(2), rs.getString(3));
                branches.add(branch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return branches;
  
    }
    public boolean insertLoginHistory(String id)
    {
        try {
            int emp_id = Integer.parseInt(id);
            java.sql.Timestamp time = new java.sql.Timestamp(new Date().getTime());
            String query = "insert into login_history values(?,?)";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, emp_id);
            ps.setTimestamp(2, time);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean payReservation(int customer_id, int room_number, int branch_id, Date date, Double price, Reservation res)
    {
        try {
            if(this.removeReservation(res))
            {
                java.sql.Date sqldate = new java.sql.Date(date.getTime());
                String query = "insert into payment values(?,?,?,?,?)";
                PreparedStatement ps = dbConnection.prepareStatement(query);
                ps.setInt(1, customer_id);
                ps.setInt(2, room_number);
                ps.setInt(3, branch_id);
                ps.setDate(4, sqldate );
                ps.setDouble(5, price);
                ps.executeUpdate();
                
                return true;
                
            }
            else
            {
                return false;
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean reserveActivityFrontEmployee(int customer_id, int branch_id,int activity_id)
    {
        try {
    
            String query = "insert into activity_requests (customer_id, activity_id, branch_id, approve_status) values(?,?,?,?)";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, customer_id);
            ps.setInt(2, activity_id);
            ps.setInt(3, branch_id);
            ps.setString(4, "yes");
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean reserveRoomFrontEmployee(int customer_id, int branch_id, Room room, Date arrive_date, Date dep_date)
    {
        try {
            java.sql.Date a_date = new java.sql.Date(arrive_date.getTime());
            java.sql.Date d_date = new java.sql.Date(dep_date.getTime());
            
            String query = "insert into room_requests (customer_id, room_number, branch_id, arrival_date,departure_date, price, approve_status) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, customer_id);
            ps.setInt(2, room.getRoom_number());
            ps.setInt(3, branch_id);
            ps.setDate(4, a_date);
            ps.setDate(5, d_date);
            ps.setInt(6, room.getPrice());
            ps.setString(7, "yes");
            ps.executeUpdate();
            if(changeRoomStatus(room.getRoom_number(), branch_id, true))
            {
                return true;
            }
            else
            {
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    public boolean updateQuery(String query)
    {
        try{
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.executeQuery();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
            return false;
        }
        return true;
    }
    
    public boolean insertEmployee(Employee emp)
    {
        try {
            String query = "insert into employee (id, fname, lname,mail,address,start_date,emp_type,branch_id) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getFname());
            ps.setString(3, emp.getLname());
            ps.setString(4, emp.getMail());
            ps.setString(5, emp.getAddress());
            ps.setDate(6, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            ps.setString(7, emp.getType());
            ps.setInt(8, emp.getBranch());
            ps.executeUpdate();
            if(!incEmployeeId())
            {
                JOptionPane.showMessageDialog(null, "Not incremented");
            }
            dbConnection.commit();
            return true;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean insertActivity(int id, int branch,String activity_name, Date start_date, Date end_date, String info )
    {
        java.sql.Date sqlStart =  new java.sql.Date(start_date.getTime());
        java.sql.Date sqlEnd =  new java.sql.Date(end_date.getTime());
        
        try {
            String query = "insert into activity (id, branch_id, activity_name, start_time, end_time, info) values(?,?,?,?,?,?)";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, branch);
            ps.setString(3, activity_name);
            ps.setDate(4, sqlStart);
            ps.setDate(5, sqlEnd);
            ps.setString(6, info);
            ps.executeUpdate();
            if(!incActivityId())
            {
                JOptionPane.showMessageDialog(null, "Activity ID not incremented!!!");
            }
            dbConnection.commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    
        
    }
    public boolean updateActivity(Activity activity)
    {
        try {
            java.sql.Date start_date = new java.sql.Date(activity.getStart_date().getTime());
            java.sql.Date end_date = new java.sql.Date(activity.getEnd_date().getTime());
            
            String query = "update activity set activity_name = ?, start_time = ?, end_time = ?, info=? where id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setString(1, activity.getName());
            ps.setDate(2, start_date);
            ps.setDate(3, end_date);
            ps.setString(4, activity.getInfo());
            ps.setInt(5, activity.getId());
            ps.executeUpdate();
            dbConnection.commit();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        
    }
    public int addCustomer(Customer customer)
    {
        try {
            String query = "insert into customer (id, fname, lname, birthdate,mail,phone_number) values(?,?,?,?,?,?)";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            java.sql.Date date = new java.sql.Date(customer.getBirthdate().getTime());
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getFname());
            ps.setString(3, customer.getLname());
            ps.setDate(4, date);
            ps.setString(5, customer.getMail());
            ps.setLong(6, customer.getPhone());
            ps.executeUpdate();
            if(!incCustomerId())
            {
                JOptionPane.showMessageDialog(null, "Customer id is not incremented!!");
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    public int removeCustomer(int id)
    {
        try {
            String query = "delete from customer where id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            return 1;
        }
        catch(java.sql.SQLIntegrityConstraintViolationException e)
        {
            return -1;
        }
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
   
    }
    public int approveRequest(Reservation res)
    {

        try {
            String query = "select status from room where room_number = ? and branch_id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, res.getRoom_number());
            ps.setInt(2, res.getBranch_id());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                if(rs.getString(1).equals("full"))
                {
                    return -2;// Requested room is full
                }
                
            }
            else
            {
                return -3; // when can't find the room from the db
            }
        
            query ="update room_requests set approve_status = 'yes' where customer_id = ? and room_number = ? and branch_id = ? ";
            ps = dbConnection.prepareStatement(query);
            ps.setInt(1, res.getCustomer_id());
            ps.setInt(2, res.getRoom_number());
            ps.setInt(3, res.getBranch_id());
            ps.executeUpdate();
            if(changeRoomStatus(res.getRoom_number(), res.getBranch_id(), true))
            {
                return 1; // 1 is successfully approved
            }
            else
            {
                return -4; // means room's status is not changed
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0; // 0 means exception occured
        }
       
    }
    
    public boolean changeRoomStatus(int room_number, int branch_id, boolean status)
    {
        if(status) // changes status of room to full
        {
            try {
                String query = "update room set status ='full' where room_number = ? and branch_id = ? ";
                PreparedStatement ps = dbConnection.prepareStatement(query);
                ps.setInt(1, room_number);
                ps.setInt(2, branch_id);
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            
        }
        else // changes status of room to empty
        {
            try {
                String query = "update room set status ='empty' where room_number = ? and branch_id = ? ";
                PreparedStatement ps = dbConnection.prepareStatement(query);
                ps.setInt(1, room_number);
                ps.setInt(2, branch_id);
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            
        }
        
    }
    public boolean removeActivityRequest(ActivityRequest ar)
    {
        try {
            String query = "delete from activity_requests where customer_id = ? and activity_id = ? and branch_id = ? ";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, ar.getCustomer_id());
            ps.setInt(2, ar.getActivity_id());
            ps.setInt(3, ar.getBranch_id());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean approveActivityRequest(ActivityRequest ar)
    {
        try {
            String query = "update activity_requests set approve_status = 'yes' where customer_id = ? and activity_id = ? and branch_id = ? ";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, ar.getCustomer_id());
            ps.setInt(2, ar.getActivity_id());
            ps.setInt(3, ar.getBranch_id());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean updateCustomer(Customer customer)
    {
        try {
            String query = "update customer set fname = ?, lname = ?, birthdate = ?, mail = ?, phone_number=? where id = ?";
            java.sql.Date bdate = new java.sql.Date(customer.getBirthdate().getTime());
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setString(1, customer.getFname());
            ps.setString(2, customer.getLname());
            ps.setDate(3, bdate);
            ps.setString(4, customer.getMail());
            ps.setLong(5, customer.getPhone());
            ps.setInt(6, customer.getId());
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean incEmployeeId()
    {
        try {
            String query = "update myseq set idcount = idcount + 1 where seqname = 'employee'";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.executeUpdate();
            dbConnection.commit();
            return true;
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    public boolean updateRequest(Reservation res)
    {
        try {
            java.sql.Date arr_date = new java.sql.Date(res.getArrive_date().getTime());
            java.sql.Date dep_date = new java.sql.Date(res.getDeparture_date().getTime());
            String query = "update room_requests set arrival_date = ?, departure_date = ? where customer_id = ? and room_number = ? and branch_id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setDate(1, arr_date);
            ps.setDate(2, dep_date);
            ps.setInt(3, res.getCustomer_id());
            ps.setInt(4, res.getRoom_number());
            ps.setInt(5, res.getBranch_id());
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean removeReservation(Reservation res)
    {
        try {
            String query = "delete from room_requests where customer_id = ? and room_number = ? and branch_id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, res.getCustomer_id());
            ps.setInt(2, res.getRoom_number());
            ps.setInt(3, res.getBranch_id());
            ps.executeUpdate();
            if(changeRoomStatus(res.getRoom_number(), res.getBranch_id(), false))
            {
              return true;   
            }
            else
            {
                return false;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public boolean incActivityId()
    {
        try {
            String query = "update myseq set idcount = idcount + 1 where seqname = 'activity'";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.executeUpdate();
            dbConnection.commit();
            return true;
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
     public boolean incCustomerId()
    {
        try {
            String query = "update myseq set idcount = idcount + 1 where seqname = 'customer'";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.executeUpdate();
            dbConnection.commit();
            return true;
        } catch (SQLException ex) {
            
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }

}
