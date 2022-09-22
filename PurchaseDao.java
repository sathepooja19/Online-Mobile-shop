package mobile.shop.Dao;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static mobile.shop.Dao.ManageProductDao.rs;

import mobile.shop.GUI.Purchase;

/**
 *
 * @author Dipak
 */
public class PurchaseDao {
    public static int coloumncount=0;
    public static ArrayList<String> p_Brand = new ArrayList<String>();
    public static ArrayList<Integer> p_id = new ArrayList<Integer>();
    public static ArrayList<String> p_Name = new ArrayList<String>();
     public static ArrayList<String> sub = new ArrayList<String>();
      
   
     
     public void getSpecificSubcat() {
        int pcid = 0;
        try {
            String sql1 = "SELECT `pcid` FROM `product_category` WHERE Title = ?";
            PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql1);
            p.setString(1,Purchase.cat.getCategory_Title());
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
     public void getproducts()
    {
          p_id.clear();
           p_Name.clear();
           p_Brand.clear();
         int scid = 0;
        
        try{
             //geting product sub category id 
            String sql2 = "SELECT `scid` FROM `sub_category` WHERE Sub_Title = ?";
            PreparedStatement p2 = new DBConnectionDao().getCon().prepareStatement(sql2);
            p2.setString(1, Purchase.cat.getSub_Category_Title());
            //p2.setString(1,"Android");
            rs = p2.executeQuery();
            while (rs.next()) {
                scid = (rs.getInt(1));
                
            }
             
            
           String sql = "SELECT `product_id`, `Name`, `brand` FROM products WHERE scid =  ?";
           PreparedStatement p1 = new DBConnectionDao().getCon().prepareStatement(sql);
            p1.setInt(1,scid);
           ResultSet  rs1 = p1.executeQuery();
           ResultSetMetaData rss = rs1.getMetaData();
           coloumncount = rss.getColumnCount();
           
            while(rs1.next()){
                p_id.add(rs1.getInt(1));
                p_Name.add((rs1.getString(2)));
                p_Brand.add(rs1.getString(3));
              
            }
           
          } catch(SQLException e)
        {
            System.out.println(e);
        }
}
     
      public void ShowProduct()
    {
        try{
        String sql = "SELECT product_id, `Name`, `brand`, `model`, `Configuration`, `descpription`, quantity ,`price`,`Image` FROM `products` WHERE product_id = ? ";
        PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
        p.setInt(1,Purchase.product.getProductid());
        rs = p.executeQuery();
        while(rs.next())
        {   Purchase.product.setProductid(rs.getInt(1));
            Purchase.product.setName(rs.getString(2));
           Purchase.product.setBrand(rs.getString(3));
            Purchase.product.setModel(rs.getString(4));
            Purchase.product.setConfiguration(rs.getString(5));
            Purchase.product.setDescription(rs.getString(6));
              Purchase.product.setQuantity(rs.getInt(7));
            Purchase.product.setPrice(rs.getFloat(8));
            Purchase.product.setImage(rs.getString(9));
           
        }
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
     public static void main(String args[])
     {
         PurchaseDao p = new PurchaseDao();
         p.getproducts();
         for(int i=0;i<p_id.size();i++)
         {
             System.out.println(p_id.get(i));
             System.out.println(p_Name.get(i));
             System.out.println(p_Brand.get(i));
         }
     }
}
