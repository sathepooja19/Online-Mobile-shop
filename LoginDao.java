package mobile.shop.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mobile.shop.GUI.AdminDashboardGui;
import mobile.shop.GUI.CustomerGui;
import mobile.shop.GUI.ForgotPassGui;
import mobile.shop.GUI.LoginGui;

/**
 *
 * @author Dipak
 */
public class LoginDao {
      public static   boolean  Flag = false;
       public String validLogin()
       {
           try
           {
                if(LoginGui.c.getCategory().equals("Admin"))
            {
            String sql = "SELECT `email`, `pass` FROM `shop_user` WHERE admin = true";
            ResultSet rs=new DBConnectionDao().getSt().executeQuery(sql);
            while(rs.next()){
                    if(rs.getString(1).equals(LoginGui.c.getCustomerEmail()) && rs.getString(2).equals(LoginGui.c.getPassword())){
                        AdminDashboardGui.logedusername = rs.getString(1);
                        return "Admin";
                    }
                    
            }}
                
               else if(LoginGui.c.getCategory().equals("Customer"))
            {
            String sql = "SELECT `userid`,`name`,`email`,`pass` FROM `shop_user` WHERE admin = false";
            ResultSet rs=new DBConnectionDao().getSt().executeQuery(sql);
            while(rs.next()){
                    if(rs.getString(3).equals(LoginGui.c.getCustomerEmail()) && rs.getString(4).equals(LoginGui.c.getPassword())){
                       
                         CustomerGui.logedusername = rs.getString(2);
                         CustomerGui.logeduserEmail = rs.getString(3);
                         CustomerGui.logeduserid = rs.getInt(1);
                         return "Customer";
                    }
            }}
           }catch(SQLException e)
           {
                System.out.print(e);
           }
           return "Error";
       }
    public void forgotpass()
    {
        try{   
        String sql = "SELECT  `email`,`BirthDate`  FROM `shop_user`";
           ResultSet rs = new DBConnectionDao().getSt().executeQuery(sql);
           while(rs.next())
           {
             if(rs.getString(1).equals(ForgotPassGui.c.getCustomerEmail()) && rs.getDate(2).equals(ForgotPassGui.c.getBirthdate()))
             {
                  try{
                        PreparedStatement prr=new DBConnectionDao().getCon().prepareStatement("UPDATE `shop_user` SET pass=? where email=?");
                        prr.setString(1, ForgotPassGui.c.getPassword());
                        prr.setString(2,rs.getString(1));
                        prr.executeUpdate();
                        prr.close();
                        }catch(SQLException e){
                            System.out.println(e);
                        }
                   Flag = true;
             }
             
           }
           }catch(SQLException e)
           {
               System.out.print(e);
           }
        
    }
    
    public static void main(String args[])
    {
        LoginDao Login = new LoginDao();
        System.out.println(Login.validLogin());
        
    }
}
   
   
        
