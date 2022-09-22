package mobile.shop.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mobile.shop.bean.Categorysbean;
import mobile.shop.GUI.Manage_CategoriesGui;

/**
 *
 * @author Dipak
 */
public class ManageCategoryDao {
     
    /**
     *
     */
   public ArrayList<String> cate;
   public ArrayList<String> subcat;
   public static ResultSet rs ;
    public  String sql;
    public static  Categorysbean cat = new Categorysbean(); 
    public ManageCategoryDao(){
    cate=new ArrayList<String>();
    subcat = new ArrayList<String>();
}
   
     public  boolean CheckDuplicate() 
     {
          boolean b =false;
         try{
         sql = " SELECT Title FROM product_category ";
          rs=new DBConnectionDao().getSt().executeQuery(sql);
          while( rs.next())
          {
              if (rs.getString(1).equalsIgnoreCase(Manage_CategoriesGui.cat.getCategory_Title()))
              {
                 b =  true;
                 break;
                 
              }             
          }
      }catch(SQLException e)
      {
                 
      } 
       return  b;
   }   
     
     public  boolean ChecksubCatExist() 
     {  boolean b = false;
         try{
         sql = "SELECT Sub_Title FROM sub_category ";
          rs=new DBConnectionDao().getSt().executeQuery(sql);
          while( rs.next())
          {
              if (rs.getString(1).equalsIgnoreCase(Manage_CategoriesGui.cat.getSub_Category_Title()))
              {
                 b =  true;
                 break;
              }
             
              
          }
      }catch(SQLException e)
      {
                 
      } 
       return b;
   }   
     
     
     
     
         
     
     public void insertCategory()  
    {
        try{
        
           sql = "INSERT INTO `product_category`(Title) VALUES(?)";
           PreparedStatement  p = new DBConnectionDao().getCon().prepareStatement(sql);
            p.setString(1,Manage_CategoriesGui.cat.getCategory_Title());
            p.executeUpdate();
           // System.out.print("Success");
        }catch(SQLException e)
        {
            System.out.print(e);
        }
    }
     public void insertSubCategory()
     {
          int Cat_id = 0;
         try{
             String sql1 = "SELECT `pcid` FROM `product_category` WHERE Title = ?";
              PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql1);
              p.setString(1,Manage_CategoriesGui.cat.getCategory_Title());
              rs = p.executeQuery();
        
              while(rs.next())
              {
                  Cat_id = rs.getInt(1);
                  System.out.println(Cat_id);   
              }
              
             sql = "INSERT INTO `sub_category`(`Sub_Title`, `pcid`) VALUES (?,?)";
            PreparedStatement  p1 = new DBConnectionDao().getCon().prepareStatement(sql);
            p1.setString(1,Manage_CategoriesGui.cat.getSub_Category_Title());
            p1.setInt(2,Cat_id);
            p1.executeUpdate();
            System.out.print("Success");  
         
             
         }catch(SQLException e)
         {}
             
     }
     public void getCategory()
     { 
         
        
         try
         {
             sql = "select Title From product_category";
              rs = new DBConnectionDao().getSt().executeQuery(sql);
           while(rs.next())
           {
               cate.add(rs.getString(1));
           }
                   
         }catch(SQLException  e){}
     }
      public void getsubCategory()
     { 
         
        
         try
         {
             sql = "select sub_Title From sub_category";
              rs = new DBConnectionDao().getSt().executeQuery(sql);
           while(rs.next())
           {
               subcat.add(rs.getString(1));
           }
                   
         }catch(SQLException  e){}
     }
    
     public void deletecategory() 
     {
         try{
          sql = "DELETE FROM `product_category` WHERE Title = ?";
           PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
           p.setString(1,Manage_CategoriesGui.cat.getCategory_Title());
           p.executeUpdate();
          }catch(SQLException e)
            {
              System.out.println(e);
            }
     }
     
     public void deletesubcategory() 
     {
         try{
          sql = "DELETE FROM `sub_category` WHERE Sub_Title = ?";
           PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
           p.setString(1,Manage_CategoriesGui.cat.getSub_Category_Title());
           p.executeUpdate();
          }catch(SQLException e)
            {
              System.out.println(e);
            }
     }
     public static void main(String args[])
     {
        ManageCategoryDao m = new ManageCategoryDao();
        m.deletecategory();
     }
}    
