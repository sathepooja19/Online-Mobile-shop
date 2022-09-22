/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobile.shop.Dao;

import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mobile.shop.GUI.RegisterGui;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 *
 * @author Dipak
 */
 public class RegisterDao {
      
     java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
 
      public boolean checkDuplicate() {
          boolean b =false;
         try{
        String sql = "SELECT email FROM shop_user ";
        ResultSet  rs=new DBConnectionDao().getSt().executeQuery(sql);
          while( rs.next())
          {
              if (rs.getString(1).equalsIgnoreCase(RegisterGui.c.getCustomerEmail()))
              {
                 b =  true;
                 break;
                 
              }             
          }
      }catch(SQLException e)
      {
            System.out.print(e);
      } 
         return b;
   
   }   
     public void Register()
   {
       try
     { 
           
           System.out.print("Test");
        // String sql1 = "INSERT INTO `shop_user`(`name`, `mobile`, `email`, `gender`,`BirthDate`, `address`, `aadharno`, `pass`, admin,`registerdate`) VALUES(?,?,?,?,?,?,?,?,?,?,)";        
         String sql = "INSERT INTO `shop_user`(`name`, `mobile`, `email`, `gender`,`BirthDate`, `address`, `aadharno`,  `pass`, `registerdate`) VALUES(?,?,?,?,?,?,?,?,?)";
         PreparedStatement p =new DBConnectionDao().getCon().prepareStatement(sql); 
        
         p.setString(1,RegisterGui.c.getCustomerName());
         p.setLong(2,RegisterGui.c.getMobileNumber());
         p.setString(3,RegisterGui.c.getCustomerEmail());
         p.setString(4,RegisterGui.c.getCustomergender());
         p.setDate(5,RegisterGui.c.getBirthdate());
         p.setString(6,RegisterGui.c.getCustomerAddress());
         p.setLong(7,RegisterGui.c.getAadharNumber());
         p.setString(8,RegisterGui.c.getPassword());
         p.setTimestamp(9,date);
         p.executeUpdate();
        }catch(SQLException e)
        {
         // System.out.print(e);
        }
        
   }
 }