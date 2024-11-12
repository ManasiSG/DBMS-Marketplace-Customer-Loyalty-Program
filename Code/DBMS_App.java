import java.util.Scanner;
import java.sql.Date;
import java.sql.*;
public class DBMS_App {
    static final String jdbcURL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl01";
    static final String user = "ypatil";	
	static final String passwd = "abcd1234";	
    static int brand_id=101;
    static int cust_id=0;
    static Date date = new java.sql.Date(System.currentTimeMillis());
    static Scanner input = new Scanner(System.in);
    public static void main(String [] args){
        Admin_Landing();

    }

   // ADMIN PART 
    static void AddBrand()
    {
        System.out.println("Enter Brand name: ");
        input.nextLine();
        String brandname = input.nextLine();
        
        System.out.println("Enter Brand Address: ");
        String brandadd = input.nextLine();
       
        System.out.println("\n Choose 1. Add Brand" + "\n 2. Go back");
        int option;
        option = input.nextInt();
        switch (option)
        {
            case 1:

        try
        {
           Connection conn = DriverManager.getConnection(jdbcURL, user, passwd);
           Class.forName("oracle.jdbc.OracleDriver");
           //ResultSet rs = null;
           //Statement result = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO BRAND (B_ID, B_NAME, JOIN_DATE,B_ADDRESS,ADMIN_ID) values (?, ?, ?,?,?)");
 
	        stmt.setInt(1, ++brand_id);
	        stmt.setString(2, brandname);
	        stmt.setDate(3, date);
            stmt.setString(4, brandadd);
            stmt.setString(5, null);
           
            stmt.executeUpdate();  
            System.out.println(" Record inserted");  
            // rs = result.executeQuery("Select * from BRAND ");
            // while (rs.next()) 
            // {
            //     int b_id = rs.getInt("B_ID");
            //     String b_name = rs.getString("B_NAME");
            //     Date join_date = rs.getDate("JOIN_DATE");
            //     String b_address = rs.getString("B_ADDRESS");
            //     int admin_id = rs.getInt("ADMIN_ID");
            //     System.out.println("\n Added below Brand details in Database:");
            //     System.out.println(b_id + ", " + b_name + ", " + join_date +
            //                ", " + b_address + ", " + admin_id);
            // }
             conn.close();
            // rs.close();
             stmt.close();
        }
        catch (java.sql.SQLException e) 
        {

            System.out.println ("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage()); 
                                     
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
        Admin_Landing();
        break;
       
        case 2:
        Admin_Landing();
        break;

        default:
        System.out.println("Wrong Input!");
        Admin_Landing();
        break;
    }

       

    }

    static void AddCustomer()
    {
        System.out.println("\n Enter Customer name: ");
        input.nextLine();
        String custname = input.nextLine();

        System.out.println("\n Enter Customer Address: ");
        String custadd = input.nextLine();

        System.out.println("\n Enter Customer Phone number: ");
        String c_phone = input.nextLine();

        System.out.println("\n Choose 1. Add Customer" + "\n 2. Go back");
        int option;
        option = input.nextInt();
        switch (option)
        {
            case 1:
        try
        {
           Connection conn = DriverManager.getConnection(jdbcURL, user, passwd);
           Class.forName("oracle.jdbc.OracleDriver");

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO CUSTOMER " +
            "(CUST_ID, CUST_NAME, C_ADDRESS,C_PH_NO,ADMIN_ID)" + " values (?, ?, ?,?,?)");
           
	        stmt.setInt(1, ++cust_id);
	        stmt.setString(2, custname);
	        stmt.setString(3, custadd);
            stmt.setString(4, c_phone);
            stmt.setString(5, null); 
            
            stmt.executeUpdate();  
            System.out.println(" Record inserted");  
            
            conn.close();
            stmt.close();
        }
        catch (java.sql.SQLException e) 
        {

            System.out.println ("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage()); 
                                     
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
        Admin_Landing();
        break;
       
        case 2:
        Admin_Landing();
        break;

        default:
        System.out.println("Wrong Input!");
        Admin_Landing();
        break;
    }
    }


    static void AddActivityType()
    {
        System.out.println("\n Enter Activity name: ");
        input.nextLine();
        String act_name = input.nextLine();

        System.out.println("\n Enter Activity code: ");
        int a_code = input.nextInt();

        System.out.println("\n Choose 1. Add Activity Type" + "\n 2. Go back");
        int option;
        option = input.nextInt();
        switch (option)
        {
            case 1:
        try
        {
           Connection conn = DriverManager.getConnection(jdbcURL, user, passwd);
           Class.forName("oracle.jdbc.OracleDriver");

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ACTIVITY_TYPE " +
            "(A_CODE, A_NAME,ADMIN_ID)" + " values (?, ?,?)");
           
	        stmt.setInt(1, a_code);
	        stmt.setString(2, act_name);
            stmt.setString(3, null); 
            stmt.executeUpdate();  
            System.out.println(" Record inserted");  
            conn.close();
            stmt.close();
        }
        catch (java.sql.SQLException e) 
        {

            System.out.println ("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage()); 
                                     
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
        AddActivityType();
        break;
       
        case 2:
        Admin_Landing();
        break;

        default:
        System.out.println("Wrong Input!");
        Admin_Landing();
        break;
    }
    }


    static void AddRewardType()
    {
        System.out.println("\n Enter Reward name: ");
        input.nextLine();
        String rew_name = input.nextLine();

        System.out.println("\n Enter Reward code: ");
        int r_code = input.nextInt();

        System.out.println("\n Choose 1. Add Reward Type" + "\n 2. Go back");
        int option;
        option = input.nextInt();
        switch (option)
        {
            case 1:
        try
        {
           Connection conn = DriverManager.getConnection(jdbcURL, user, passwd);
           Class.forName("oracle.jdbc.OracleDriver");
           

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO REWARD_TYPE " +
            "(R_CODE, R_NAME,ADMIN_ID)" + " values (?, ?,?)");
           
	        stmt.setInt(1, r_code);
	        stmt.setString(2, rew_name);
            stmt.setString(3, null); 
            stmt.executeUpdate();
            conn.close();
            stmt.close();
        }
        catch (java.sql.SQLException e) 
        {

            System.out.println ("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage()); 
                                     
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
        AddRewardType();
        break;
       
        case 2:
        Admin_Landing();
        break;

        default:
        System.out.println("Wrong Input!");
        Admin_Landing();
        break;
    }
    }
 
    static void ShowBrandInfo()
    {
       
            System.out.println("\n Enter Brand ID: ");
            int b_id = input.nextInt();

            System.out.println("\n Choose 1. Show Brand Info" + "\n 2. Go back");
            int option;
            option = input.nextInt();
            switch (option)
            {
                case 1:
                try
                {
                   Connection conn = DriverManager.getConnection(jdbcURL, user, passwd);
                   Class.forName("oracle.jdbc.OracleDriver");
                   ResultSet rs = null;
        
                PreparedStatement stmt = conn.prepareStatement("select * from BRAND where B_ID=?");
                stmt.setInt(1, b_id);
                rs = stmt.executeQuery();
                while (rs.next()) 
                {
                int brand_id = rs.getInt("B_ID");
                String b_name = rs.getString("B_NAME");
                Date join_date = rs.getDate("JOIN_DATE");
                String b_address = rs.getString("B_ADDRESS");
                int admin_id = rs.getInt("ADMIN_ID");
                System.out.println("\n Showing Brand details in Database:");
                System.out.println(brand_id + ", " + b_name + ", " + join_date +
                           ", " + b_address + ", " + admin_id);
                }
                conn.close();
                rs.close();
                stmt.close();
                }
                catch (java.sql.SQLException e) 
                {

                    System.out.println ("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage()); 
                                     
                }
                catch(Exception e) 
                {
                    System.out.println(e);
                }
                ShowBrandInfo();
                break;

                case 2:
                Admin_Landing();
                break;

                default:
                System.out.println("Wrong Input, try again");
                ShowBrandInfo();
            

        }
    }

  

    static void ShowCustInfo()
    {
        System.out.println("\n Enter Customer ID: ");
        int cust_id = input.nextInt();

        System.out.println("\n Choose 1. Show Customer Info" + "\n 2. Go back");
        int option;
        option = input.nextInt();
        switch (option)
        {
            case 1:
            try
            {
            Connection conn = DriverManager.getConnection(jdbcURL, user, passwd);
            Class.forName("oracle.jdbc.OracleDriver");
            ResultSet rs = null;

            PreparedStatement stmt = conn.prepareStatement("select * from CUSTOMER where CUST_ID=?");
            stmt.setInt(1, cust_id);
            rs = stmt.executeQuery();
            while (rs.next()) 
            {
                int c_id = rs.getInt("CUST_ID");
                String c_name = rs.getString("CUST_NAME");
                String c_address = rs.getString("C_ADDRESS");
                int c_number = rs.getInt("C_PH_NO");
                int admin_id = rs.getInt("ADMIN_ID");
                System.out.println("\n Showing Customer details in Database:");
                System.out.println(c_id + ", " + c_name + ", " + c_address +
                           ", " + c_number + ", " + admin_id);
            }
            stmt.close();
            conn.close();
            rs.close();
            }
            catch (java.sql.SQLException e) 
            {

                System.out.println ("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage()); 
                                 
            }
            catch(Exception e) 
            {
                System.out.println(e);
            }
            ShowCustInfo();
            break;

            case 2:
            Admin_Landing();
            break;

            default:
            System.out.println("Wrong Input, try again");
            ShowCustInfo();
        

    }
}

    static void Admin_Landing(){
        System.out.println("Choose 1. Add Brand" + "\n 2. Add Customer" + "\n 3. Show Brand's info"+ "\n 4. Show Customer's info"+ "\n 5. Add Activity Type"+ "\n 6. Add Reward Activity"+ "\n 7. Logout");

        int option;
        option = input.nextInt();
        switch (option)
        {
            case 1:
                AddBrand();
                break;
            case 2:
                AddCustomer();
                break;
            case 3:
                ShowBrandInfo();
                break;
            case 4:
                ShowCustInfo();
                break;
            case 5:
                AddActivityType();
                break;
            case 6:
                AddRewardType();
                break;
            case 7:
                System.out.println("Logged out!");
                // call Homepage here
                break;

            default:
                System.out.println("Invalid Input, try again!");
                Admin_Landing();
                break;
        }
        
    }





}