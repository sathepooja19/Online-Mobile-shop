package mobile.shop.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dipak
 */
public class DBConnectionDao {
   private Connection con = null;
   private Statement st = null;
   
   public Connection getCon()
   {
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_shop","root","");
       }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
   }
       return this.con;
   
   }
    public Statement getSt() {
        try{
            return st=getCon().createStatement();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return this.st;
    }
     public static void main(String []args)
     {
         System.out.println(new DBConnectionDao().getCon());
     }
}

   
