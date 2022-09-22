package mobile.shop.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import mobile.shop.GUI.CustomerGui;
import mobile.shop.GUI.Manage_OrdersGui;

/**
 *
 * @author Dipak
 */
public class ManageOrderDao {

    public static int coloumncount = 0;
    ResultSet rs;
    public static  String Utr;
    public static ArrayList<Integer> order_id = new ArrayList<Integer>();
    public static ArrayList<String> order_date = new ArrayList<String>();
    public static ArrayList<Float> Total_Amount = new ArrayList<Float>();
    public static ArrayList<String> Customer_Name = new ArrayList<String>();
    public static ArrayList<Integer> Customer_id = new ArrayList<Integer>();
      
    public void getpendingorders() {
        try {
             order_id.clear();
                    order_date.clear();
                Total_Amount.clear();
                Customer_id.clear();
                 Customer_Name.clear();
            String sql = "SELECT `Order_id`, `order_Date`,`userid`,`Total_amount` FROM `orders` WHERE  Order_status = 0";
            PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
            rs = p.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            coloumncount = rss.getColumnCount();
            while (rs.next()) {
                order_id.add(rs.getInt(1));
                order_date.add(String.valueOf(rs.getDate(2)));
                Total_Amount.add(rs.getFloat(4));
                Customer_id.add(rs.getInt(3));
            }
            for (int i = 0; i < Customer_id.size(); i++) {
                sql = "SELECT  `name` FROM `shop_user` Where`userid`= ?";
                p = new DBConnectionDao().getCon().prepareStatement(sql);
                p.setInt(1, Customer_id.get(i));
                rs = p.executeQuery();
                while (rs.next()) {
                    Customer_Name.add(rs.getString(1));

                }

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getutr() {
        try {
            String sql = "SELECT `Utr_Number` FROM `payments` WHERE Order_id = ?";
            PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setInt(1,Manage_OrdersGui.orderid);
            rs = p.executeQuery();
            while (rs.next()) {
                Utr = (rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    
   public void AproveOrder()
   {
       try{ 
     String sql = " UPDATE `orders` SET `Order_status` = true where `Order_id` = ?";
     PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setInt(1,Manage_OrdersGui.orderid);
            p.executeUpdate();
            }catch(SQLException e)
            {
              System.out.println(e);
            }
   }
  public void getaprovedgorders() {
        try {
            order_id.clear();
             order_date.clear();
                Total_Amount.clear();
                Customer_id.clear();
                 Customer_Name.clear();
                 
            String sql = "SELECT `Order_id`, `order_Date`,`userid`,`Total_amount` FROM `orders` WHERE  Order_status = 1";
            PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
            rs = p.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            coloumncount = rss.getColumnCount();
            while (rs.next()) {
                order_id.add(rs.getInt(1));
                order_date.add(String.valueOf(rs.getDate(2)));
                Total_Amount.add(rs.getFloat(4));
                Customer_id.add(rs.getInt(3));
            }
            for (int i = 0; i < Customer_id.size(); i++) {
                sql = "SELECT  `name` FROM `shop_user` Where`userid`= ?";
                p = new DBConnectionDao().getCon().prepareStatement(sql);
                p.setInt(1, Customer_id.get(i));
                rs = p.executeQuery();
                while (rs.next()) {
                    Customer_Name.add(rs.getString(1));

                }

            }
                
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new ManageOrderDao().getpendingorders();
    }
}
