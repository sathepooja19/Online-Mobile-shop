package mobile.shop.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import static mobile.shop.Dao.ManageCategoryDao.rs;
import mobile.shop.GUI.CustomerGui;
import mobile.shop.GUI.OrdersGui;

public class OrdersDao {

    public static ArrayList<Integer> order_id = new ArrayList<Integer>();
    public static ArrayList<String> order_date = new ArrayList<String>();
    public static ArrayList<Float> Total_Amount = new ArrayList<Float>();
    
    public static ArrayList<String> Product_Name = new ArrayList<String>();
    
     public static ArrayList<Float> Product_Price = new ArrayList<Float>();
    public static ArrayList<Integer> Product_Qty = new ArrayList<Integer>();
     public static ArrayList<Float> Amount = new ArrayList<Float>();
    
    public static  String Utr;
    public static float Total_amt= 0;
    
   
  public static  int coloumncount = 0;

    public void getpendingorders() {
        try {
            order_id.clear();
               order_date.clear();
               Total_Amount.clear();
            String sql = "SELECT `Order_id`, `order_Date`,`Total_amount` FROM `orders` WHERE userid = ? And Order_status = 0";
            PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setInt(1, CustomerGui.logeduserid);
             rs = p.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            coloumncount = rss.getColumnCount();
            while (rs.next()) {
               order_id.add(rs.getInt(1));
               order_date.add(String.valueOf(rs.getDate(2)));
               Total_Amount.add(rs.getFloat(3));
            }
        } catch (SQLException e) {

        }
    }
    
     public void getAprovedorders() {
        try {
            order_id.clear();
               order_date.clear();
               Total_Amount.clear();
            String sql = "SELECT `Order_id`, `order_Date`,`Total_amount` FROM `orders` WHERE userid = ? And Order_status = 1";
            PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setInt(1, CustomerGui.logeduserid);
             rs = p.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            coloumncount = rss.getColumnCount();
            while (rs.next()) {
               order_id.add(rs.getInt(1));
               order_date.add(String.valueOf(rs.getDate(2)));
               Total_Amount.add(rs.getFloat(3));
            }
        } catch (SQLException e) {

        }
        
        
    }

    public void genBill()
    {
       try {
            order_id.clear();
               order_date.clear();
               Total_Amount.clear();
            String sql = "SELECT  `Name`,  `Price`, `Quantity`, `Total_amount` FROM `order_items` WHERE `Order_id`= ? ";
            PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
           p.setInt(1,OrdersGui.orderid);
             rs = p.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            coloumncount = rss.getColumnCount();
            while (rs.next()) {
              Product_Name.add(rs.getString(1));
              Product_Price.add(rs.getFloat(2));
              Product_Qty.add(rs.getInt(3));
              Amount.add(rs.getFloat(4));
            }
            
            sql = "SELECT   `Total_amount` FROM `orders` WHERE `Order_id` = ?";
                 p = new DBConnectionDao().getCon().prepareStatement(sql);
                  p.setInt(1,OrdersGui.orderid);
                 rs = p.executeQuery();
                 while(rs.next())
                  Total_amt = rs.getFloat(1);
        } catch (SQLException e) {
          System.out.print(e);
        } 
        
    }
    
public static void main(String args[])
{
   new  OrdersDao().genBill();
   for(int i = 0;i<Product_Name.size();i++)
   {
   System.out.println( Product_Name.get(i));
   
   }

}
}
