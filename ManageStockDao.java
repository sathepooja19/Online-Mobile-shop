package mobile.shop.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
 import mobile.shop.GUI.Manage_StockGui;


/**
 *
 * @author Dipak
 */
public class ManageStockDao {
    ResultSet rs;
    int quantity = 0;
    public static int coloumncount=0;
     public static ArrayList<String> sub = new ArrayList<String>();
    public static ArrayList<String> products = new ArrayList<String>();
    public static ArrayList<Integer> p_quantity = new ArrayList<Integer>();
    public static ArrayList<Integer> p_id = new ArrayList<Integer>();
    public static ArrayList<String> p_Name = new ArrayList<String>();
     public void getSpecificSubcat() {
        int pcid = 0;
        try {
            String sql1 = "SELECT `pcid` FROM `product_category` WHERE Title = ?";
            PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql1);
            p.setString(1, Manage_StockGui.cat.getCategory_Title());
            rs = p.executeQuery();
            while (rs.next()) {
                pcid = (rs.getInt(1));
            }

            String sql2 = "SELECT `Sub_Title` FROM `sub_category` WHERE pcid = (?)";
            PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql2);
            p1.setInt(1, pcid);
            ResultSet rs1;
            rs1 = p1.executeQuery();
            while (rs1.next()) {
                sub.add(rs1.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
      public void getproductnames()
    {
         int scid = 0;
        
        try{
             //geting product sub category id 
            String sql2 = "SELECT `scid` FROM `sub_category` WHERE Sub_Title = ?";
            PreparedStatement p2 = new DBConnectionDao().getCon().prepareStatement(sql2);
            p2.setString(1, Manage_StockGui.cat.getSub_Category_Title());
            rs = p2.executeQuery();
            while (rs.next()) {
                scid = (rs.getInt(1));
                
            }
             
            
           String sql = "SELECT Name FROM `products` WHERE  scid  = ?";
           PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql);
            p1.setInt(1,scid);
           ResultSet  rs1 = p1.executeQuery();
            while(rs1.next()){
                products.add(rs1.getString(1));
              
            }
           
          } catch(SQLException e)
        {
            System.out.println(e);
        }
        
        
    }
     public void getStock()
     {
         
       try
       {
           String sql ="SELECT quantity FROM products where Name = ? ";
         PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql);
         p1.setString(1,Manage_StockGui.products.getName());
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
           System.out.println(quantity);
           quantity = Manage_StockGui.products.getQuantity() + quantity;
           try
           {
             String sql ="UPDATE `products` SET `quantity`= ? WHERE Name = ?";
             PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql);
             p1.setInt(1,quantity);
             p1.setString(2,Manage_StockGui.products.getName());
             p1.executeUpdate();
               
           }catch(SQLException e)
           {
               
           }
           
            
           
        
     }
        public void getDetails()
        {  p_id.clear();
           p_Name.clear();
           p_quantity.clear();
            try{  
               String sql = "SELECT `product_id`, `Name`, `quantity` FROM products";
            PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql);
            ResultSet rs = p1.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            coloumncount = rss.getColumnCount();
             
            while(rs.next())
             {
                 p_id.add(rs.getInt(1));
                 
                 p_Name.add(rs.getString(2));
                 p_quantity.add(rs.getInt(3));
             }
            
             }catch(SQLException e)
             {
                 
             }
        }
        public static void main(String args[])
        {
            ManageStockDao m = new ManageStockDao ();
            m.UpdateStock();
        }
}
