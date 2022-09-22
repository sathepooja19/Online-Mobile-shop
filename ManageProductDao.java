package mobile.shop.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mobile.shop.GUI.Manage_ProductsGui;

/**
 *
 * @author Dipak
 */
public class ManageProductDao {

    public static ArrayList<String> sub = new ArrayList<String>();
    public static ArrayList<String> products = new ArrayList<String>(); 
    public static ResultSet rs;

    public void getSpecificSubcat() {
        int pcid = 0;
        try {
            String sql1 = "SELECT `pcid` FROM `product_category` WHERE Title = ?";
            PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql1);
            p.setString(1, Manage_ProductsGui.cat.getCategory_Title());
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

    public void insert_Product() {
        int pcid = 0, scid = 0;
        try {
            //geting product category id
            String sql1 = "SELECT `pcid` FROM `product_category` WHERE Title = ?";
            PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql1);
            p1.setString(1, Manage_ProductsGui.cat.getCategory_Title());
            rs = p1.executeQuery();
            while (rs.next()) {
                pcid = (rs.getInt(1));
            }
            //geting product sub category id 
            String sql2 = "SELECT `scid` FROM `sub_category` WHERE Sub_Title = ?";
            PreparedStatement p2 = new DBConnectionDao().getCon().prepareStatement(sql2);
            p2.setString(1, Manage_ProductsGui.cat.getSub_Category_Title());
            rs = p2.executeQuery();
            while (rs.next()) {
                scid = (rs.getInt(1));
            }
//            System.out.print("ok");

            //insert Product  
            String sql3 = "INSERT INTO products (`Name`,`brand`,`model`,`Configuration`,`descpription`,`price`,`pcid`,`scid`,`Image`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement p3 = new DBConnectionDao().getCon().prepareStatement(sql3);

            p3.setString(1, Manage_ProductsGui.product.getName());
            p3.setString(2, Manage_ProductsGui.product.getBrand());
            p3.setString(3, Manage_ProductsGui.product.getModel());
            p3.setString(4, Manage_ProductsGui.product.getConfiguration());
            p3.setString(5, Manage_ProductsGui.product.getDescription());
            p3.setFloat(6, Manage_ProductsGui.product.getPrice());

            p3.setInt(7, pcid);
            p3.setInt(8, scid);
            p3.setString(9,Manage_ProductsGui.product.getImage());
            p3.executeUpdate();
            
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
            p2.setString(1, Manage_ProductsGui.cat.getSub_Category_Title());
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
    
    public void ShowProduct()
    {
        try{
        String sql = "SELECT `Name`, `brand`, `model`, `Configuration`, `descpription`, `price` , `Image` FROM `products` WHERE Name = ? ";
        PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
        p.setString(1,Manage_ProductsGui.product.getName());
        rs = p.executeQuery();
        while(rs.next())
        {
            Manage_ProductsGui.product.setName(rs.getString(1));
            Manage_ProductsGui.product.setBrand(rs.getString(2));
            Manage_ProductsGui.product.setModel(rs.getString(3));
            Manage_ProductsGui.product.setConfiguration(rs.getString(4));
            Manage_ProductsGui.product.setDescription(rs.getString(5));
            Manage_ProductsGui.product.setPrice(rs.getFloat(6));
            Manage_ProductsGui.product.setImage(rs.getString(7));
           
        }
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    public void UpdateProduct()
    {
        try{
            String  sql ="UPDATE `products` SET `Name`= ? ,`brand`= ? ,`model`= ? ,`Configuration`= ? ,`descpription`= ? ,`price`= ? ,`Image`= ? WHERE Name = ?"; 
             PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
          
         
            p.setString(1, Manage_ProductsGui.product.getName());
            p.setString(2, Manage_ProductsGui.product.getBrand());
            p.setString(3, Manage_ProductsGui.product.getModel());
            p.setString(4, Manage_ProductsGui.product.getConfiguration());
            p.setString(5, Manage_ProductsGui.product.getDescription());
            p.setFloat(6, Manage_ProductsGui.product.getPrice());
            p.setString(7, Manage_ProductsGui.product.getImage());
            
            p.setString(8,Manage_ProductsGui.updateproductname);
            
            System.out.print(Manage_ProductsGui.updateproductname);
            p.executeUpdate();
            
            
            
        }catch(SQLException e)
        {
            System.out.print(e);
        }
    }
    public void DeleteProduct()
    {
        
         try{
        String  sql = "DELETE FROM products WHERE Name = ?";
           PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
           p.setString(1,Manage_ProductsGui.updateproductname);
           p.executeUpdate();
          }catch(SQLException e)
            {
              System.out.println(e);
            }
    }
    public static void main(String args[])
    {
        ManageProductDao m = new  ManageProductDao();
        m.UpdateProduct();
    }
  
}
