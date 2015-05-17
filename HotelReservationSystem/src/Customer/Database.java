package Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public ResultSet customerLogin(int id, String password)
    {
        ResultSet rs = null;
        try {
            String query = "select * from customer where id=? and passw=?";
            
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }  
    }
    public boolean removeActivityRequest(int customer_id, int branch_id, int activity_id)
    {
        try {
            String query = "delete from activity_requests where customer_id = ? and branch_id = ? and activity_id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, customer_id);
            ps.setInt(2, branch_id);
            ps.setInt(3, activity_id);
            ps.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    public boolean removeRequest(RoomReservation room, int customer_id)
    {
        try {
            String query = "delete from room_requests where customer_id = ? and room_number = ? and branch_id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, customer_id);
            ps.setInt(2, room.getRoom_number());
            ps.setInt(3, room.getBranch_id());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ResultSet getActivities(int branch_id)
    {
        ResultSet rs = null;
        try {
            String query = "select id, branch_id, activity_name, start_time, end_time, info from activity where branch_id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, branch_id);
            rs = ps.executeQuery();
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
        
        
    }
    public int requestActivity(int customer_id, int branch_id, int activity_id)
    {
        try {
            String query = "insert into activity_requests (customer_id, activity_id, branch_id) values (?,?,?)";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, customer_id);
            ps.setInt(2, activity_id);
            ps.setInt(3, branch_id);
            ps.executeUpdate();
            return 1;
            
        }
        catch(java.sql.SQLIntegrityConstraintViolationException ex)
        {
            return -1;
        }
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    public Customer getCustomer(int id)
    {
        Customer customer = null;
        ResultSet rs = null;
        try {
            String query = "select id, fname, lname, birthdate, mail, phone_number from customer where id=?";
            
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
            {
                customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5), rs.getLong(6));
                 return customer;
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return customer;
        }
        return customer;
    }
    
    public boolean updateCustomer(Customer customer)
    {
        try {
            String query = "update customer set fname = ?, lname = ?, birthdate = ?, mail=?, phone_number=? where id = ?";
            java.sql.Date birthdate =  new java.sql.Date(customer.getBirthdate().getTime());
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setString(1, customer.getFname());
            ps.setString(2, customer.getLname());
            ps.setDate(3, birthdate);
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
    public ResultSet getBranch()
    {
        ResultSet rs = null;
        try
        {
            String query = "select branch_id, branch_name, branch_location from branch";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
            
        }
    }
    public ResultSet getRooms(int branchid)
    {
        ResultSet rs = null;
        try
        {
            String query = "select room_number, name, max_guests, total_rooms, price from room, room_type"
                    + " where type_id = id and branch_id = ? and status='empty'";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, branchid);
            rs = ps.executeQuery();
            return rs;
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
            
        }
        
    }
    public int ReserveRoom(int customer_id, int room_number, int branch_id, Date arrival_date, Date departure_date, int price)
    {
        try {
            java.sql.Date arrivalDate = new java.sql.Date(arrival_date.getTime());
            java.sql.Date departureDate = new java.sql.Date(departure_date.getTime());
            
            String query = "insert into room_requests (customer_id, room_number, branch_id, arrival_date,departure_date,price)"
                    + " values(?,?,?,?,?,?)";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, customer_id);
            ps.setInt(2, room_number);
            ps.setInt(3, branch_id);
            ps.setDate(4, arrivalDate);
            ps.setDate(5, departureDate);
            ps.setInt(6, price);
            ps.executeUpdate();
            return 1;
            
        }
        catch(java.sql.SQLIntegrityConstraintViolationException ex)
        {
            return -1;
        }
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
        
    }
    
    
        
    
    
    
    
     

}
