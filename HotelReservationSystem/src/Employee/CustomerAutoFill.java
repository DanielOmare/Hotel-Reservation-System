/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Employee;
import Customer.Customer;
import java.util.Date;
/**
 *
 * @author Anar
 */
public class CustomerAutoFill {
    public static void main(String[] args)
    {
        int customerid = 1034;
        String customerName = "CustomerName";
        String customerSurname = "CustomerSurname";
        Date date = new Date();
        String mail = "customer@yahoo.com";
        
        Database database = new Database();
        database.openConnection();
        Customer customer;
        for(int i = 0; i < 10; i++)
        {
            customer = new Customer(customerid+i, customerName+i, customerSurname+i, date, mail+i, 999999990);
            database.addCustomer(customer);
        }
        
    }
    
}
