
package mobile.shop.Dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import mobile.shop.GUI.CustomerGui;
import mobile.shop.GUI.MycartGui;
import mobile.shop.GUI.Purchase;


public class ManageCartDao {
     public static ArrayList<Integer> p_id = new ArrayList<Integer>();
    public static ArrayList<String> p_Name = new ArrayList<String>();
   public static ArrayList<String> p_Brand = new ArrayList<String>();
   public static ArrayList<String> p_Model = new ArrayList<String>();
   public static ArrayList<Float> p_Price = new ArrayList<Float>();
   public static ArrayList<Integer> p_Quntity = new ArrayList<Integer>();
   public static ArrayList<Float> p_total = new ArrayList<Float>();
    public static int coloumncount=0;
    int quantity ;
   
    
   
     public void getStock()
     {
         
       try
       {
           String sql ="SELECT quantity FROM products where Name = ? ";
         PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql);
         p1.setString(1,Purchase.product.getName());
         ResultSet  rs = p1.executeQuery();
         while(rs.next())
         {
             quantity = (rs.getInt(1));
         }
       }catch(SQLException e)
           
       {
       }
     }
       public void UpdateStock()
     {
           getStock();
       
           quantity =  quantity - Purchase.product.getQuantity();
           try
           {
             String sql ="UPDATE `products` SET `quantity`= ? WHERE Name = ?";
             PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql);
             p1.setInt(1,quantity);
             p1.setString(2,Purchase.product.getName());
             p1.executeUpdate();
               
           }catch(SQLException e)
           {
               
           }
     }

    public void insertproductincart()
    {
         int cartid = 0;
         try{
        
             String sql1="SELECT `cart_id` FROM `cart` WHERE userid = ?";
             PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql1);
              p.setInt(1,CustomerGui.logeduserid);
              ResultSet rs = p.executeQuery();
           while(rs.next())
              {
                cartid = rs.getInt(1);
              }
             
           
           
             if(cartid==0)
             {
             String   sql = "INSERT INTO `cart`(`userid`) VALUES (?) ";
             p = new DBConnectionDao().getCon().prepareStatement(sql);
             p.setInt(1,CustomerGui.logeduserid);
             p.executeUpdate();
              sql1="SELECT `cart_id` FROM `cart` WHERE userid = ?";
              p = new DBConnectionDao().getCon().prepareStatement(sql1);
              p.setInt(1,CustomerGui.logeduserid);
              rs = p.executeQuery();
           while(rs.next())
              {
                cartid = rs.getInt(1);
              }
              sql = "INSERT INTO `cart_items`(`Name`, `Model`, `product_id`, `cart_id`, `Price`, `Quantity`, `Total_amount`, `Brand`) VALUES (?,?,?,?,?,?,?,?)";
              p = new DBConnectionDao().getCon().prepareStatement(sql);
              p.setString(1,Purchase.product.getName());
              p.setString(2,Purchase.product.getModel());
              p.setInt(3,Purchase.product.getProductid());
              p.setInt(4,cartid);
              p.setFloat(5,Purchase.product.getPrice());
              p.setInt(6,Purchase.product.getQuantity());
              float price = Purchase.product.getPrice();
             float quntity = Purchase.product.getQuantity();
             float totalamt = (price * quntity);
            
              p.setFloat(7, totalamt);
              p.setString(8,Purchase.product.getBrand());
              p.executeUpdate();
              
             }else
             {
             String sql = "INSERT INTO `cart_items`(`Name`,`Model`,`product_id`,`cart_id`,`Price`,`Quantity`,`Total_amount`,`Brand`) VALUES (?,?,?,?,?,?,?,?)";
              p = new DBConnectionDao().getCon().prepareStatement(sql);
              p.setString(1,Purchase.product.getName());
              p.setString(2,Purchase.product.getModel());
              p.setInt(3,Purchase.product.getProductid());
              p.setInt(4,cartid);
              p.setFloat(5,Purchase.product.getPrice());
              p.setInt(6,Purchase.product.getQuantity());
         
              
             float price = Purchase.product.getPrice();
             float quntity = Purchase.product.getQuantity();
             float totalamt = (price * quntity);
             
              p.setFloat(7, totalamt);
              p.setString(8,Purchase.product.getBrand());
              p.executeUpdate();
             
             }
             
       
         
        }catch(SQLException e)
        {
            System.out.print(e);
           
        }
         getStock();
         UpdateStock();
   }
        
     public void getcart()
    {
        float i = 0;
       p_id.clear();
       p_Name.clear();
       p_Model.clear();
       p_Price.clear();
       p_Quntity.clear();
       p_total.clear();
       p_Brand.clear();
        int cartid = 0;
        try{
           String sql1 = "SELECT `cart_id` FROM `cart` WHERE userid = ?";
            PreparedStatement   p = new DBConnectionDao().getCon().prepareStatement(sql1);
            p.setInt(1,CustomerGui.logeduserid);
            ResultSet   rs = p.executeQuery();
          
           
             while(rs.next())
              {
               cartid =  (rs.getInt(1));
              }
              sql1 = "SELECT `id`, `Name`, `Model`,`Price`, `Quantity`, `Total_amount`, `Brand` FROM `cart_items` WHERE `cart_id`= ? ";
               p = new DBConnectionDao().getCon().prepareStatement(sql1);
               p.setInt(1,cartid);
              rs = p.executeQuery();
              ResultSetMetaData rss = rs.getMetaData();
              coloumncount = rss.getColumnCount();
             while(rs.next())
              {
                p_id.add(rs.getInt(1));
                p_Name.add(rs.getString(2));
                p_Model.add((rs.getString(3)));
                p_Price.add(rs.getFloat(4));
                p_Quntity.add(rs.getInt(5));
                p_total.add(rs.getFloat(6));
                i = i + rs.getFloat(6);
                p_Brand.add(rs.getString(7));
              }
               
          } catch(SQLException e)
        {
            System.out.println(e);
        }
}
     public void RemoveItem()
     {
        try{     
       String sql ="DELETE FROM `cart_items` WHERE `cart_items`.`id` =?";
       PreparedStatement  p = new DBConnectionDao().getCon().prepareStatement(sql);
       p.setInt(1,MycartGui.Item_id);
       p.executeUpdate();
     }catch(SQLException e)
     {
     }
     
     }
     
     
     
     public static void main(String args[])
     {
         ManageCartDao m = new  ManageCartDao();
         m.getcart();
     }
         
    }
