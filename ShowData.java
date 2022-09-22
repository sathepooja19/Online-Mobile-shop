
package mobile.shop.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dipak
 */
public class ShowData {
       public static int total_Customer = 0;
       public static int total_products = 0;
       public static int Recived_paymet = 0;
       public static int pending_orders = 0;
       public static int Aproved_orders = 0;
       public static int total_Stock = 0;
      public static int total_Saled =0;
         
   public void getdata()
   {
       try{
        String  sql = "select COUNT(*) FROM `shop_user`";
    PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
           
        ResultSet    rs = p.executeQuery();
            while (rs.next()) {
              total_Customer = rs.getInt(1) - 1;
            }
                sql = "select COUNT(*) FROM products";
                p = new DBConnectionDao().getCon().prepareStatement(sql);
           
              rs = p.executeQuery();
            while (rs.next()) {
              total_products= rs.getInt(1);
              
              
            }
              sql = "SELECT SUM(Total_amount) FROM orders";
                p = new DBConnectionDao().getCon().prepareStatement(sql);
           
              rs = p.executeQuery();
            while (rs.next()) {
              Recived_paymet= rs.getInt(1);
              
            }
              sql = "SELECT COUNT(*) FROM orders WHERE Order_status =0";
                p = new DBConnectionDao().getCon().prepareStatement(sql);
           
              rs = p.executeQuery();
            while (rs.next()) {
              pending_orders= rs.getInt(1);
               
            }
            sql = "SELECT COUNT(*) FROM orders WHERE Order_status =1";
                p = new DBConnectionDao().getCon().prepareStatement(sql);
           
              rs = p.executeQuery();
            while (rs.next()) {
              Aproved_orders= rs.getInt(1);
               
            }
             sql = "SELECT SUM(quantity) FROM products";
                p = new DBConnectionDao().getCon().prepareStatement(sql);
           
              rs = p.executeQuery();
            while (rs.next()) {
              total_Stock= rs.getInt(1);
               
            }
            sql = "SELECT SUM(quantity) FROM order_items";
                p = new DBConnectionDao().getCon().prepareStatement(sql);
           
              rs = p.executeQuery();
            while (rs.next()) {
              total_Saled= rs.getInt(1);
               
            }
     }catch(SQLException e)
     {
     
     }
   }
    
public static void main(String args[])
{
   new ShowData().getdata();
}
}
