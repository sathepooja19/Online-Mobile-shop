package mobile.shop.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mobile.shop.GUI.CustomerGui;
import mobile.shop.GUI.MycartGui;

/**
 *
 * @author Dipak
 */
public class PlaceorderDao {

    PreparedStatement p;
     ResultSet rs;
    String sql;
   static int cartid = 0;
   static int orderid = 0;

    
    public void getcartid()
    {
        try{
           sql = "SELECT `cart_id` FROM `cart` WHERE userid = ?";
            p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setInt(1, CustomerGui.logeduserid);
            rs = p.executeQuery();

            while (rs.next()) {
                cartid = (rs.getInt(1));
            }
        }catch(SQLException e){
        System.out.println(e);
        }
    }
    
    public void placeorder() {
        try {

             getcartid();

            sql = "INSERT INTO `orders`(`userid`, `cart_id`, `Total_amount`) VALUES (?,?,?)";
            p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setInt(1, CustomerGui.logeduserid);
            p.setInt(2, cartid);
            p.setFloat(3, MycartGui.i);
            p.executeUpdate();

            sql = "SELECT `Order_id` FROM `orders` WHERE `cart_id`= ?";
            p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setInt(1, cartid);
            rs = p.executeQuery();

            while (rs.next()) {
                orderid = (rs.getInt(1));
            }

            sql = "SELECT `Name`, `Model`,`Price`, `Quantity`, `Total_amount`,`Brand` FROM `cart_items` WHERE `cart_id`= ? ";
            p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setInt(1, cartid);
            rs = p.executeQuery();
            while (rs.next()) {
                sql = "INSERT INTO `order_items`(`Name`, `Model`, `Brand`, `Price`,`Quantity`,`Total_amount`,`Order_id`) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql);
                p1.setString(1, rs.getString(1));
                p1.setString(2, rs.getString(2));
                p1.setString(3, rs.getString(6));
                p1.setFloat(4, rs.getFloat(3));
                p1.setInt(5, rs.getInt(4));
                p1.setFloat(6, rs.getFloat(5));
                p1.setInt(7, orderid);
                p1.executeUpdate();
            }

            clearecart();
            payement();
        } catch (SQLException e) {
            System.out.print(e);
        }

    }

    public void payement() {
        try {
            String sql = "INSERT INTO `payments`(`Utr_Number`, `Order_id`, `userid`) VALUES (?,?,?)";
            PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql);
            p1.setString(1, MycartGui.paymentutr);
            p1.setInt(2, orderid);
            p1.setInt(3, CustomerGui.logeduserid);
            p1.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public void clearecart() {
        try {

            String sql = "DELETE FROM `cart` WHERE cart_id = ?";
            p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setInt(1, cartid);
            p.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

}
