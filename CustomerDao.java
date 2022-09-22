package mobile.shop.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import mobile.shop.GUI.Manage_CustomersGui;

/**
 *
 * @author Dipak
 */
public class CustomerDao {

    public static ArrayList<Integer> id = new ArrayList<Integer>();
    public static ArrayList<String> Name = new ArrayList<String>();
    public static ArrayList<Long> Mobile = new ArrayList<Long>();
    public static ArrayList<String> Email = new ArrayList<String>();
    public static ArrayList<String> gender = new ArrayList<String>();
    public static ArrayList<String> Birthdate = new ArrayList<String>();
    public static ArrayList<String> Address = new ArrayList<String>();
    public static ArrayList<String> registerdate = new ArrayList<String>();
    public static ArrayList<Long> Aadhar = new ArrayList<Long>();
    public static int coloumncount=0;

    public void getcust() {
        try {
             id.clear();
                Name.clear();
                Mobile.clear();
                Email.clear();
                gender.clear();
                Birthdate.clear();
                Address.clear();
                registerdate.clear();
                Aadhar.clear();
            String sql = "SELECT `userid`, `name`, `mobile`, `email`, `gender`, `BirthDate`, `address`, `aadharno`,`registerdate` FROM `shop_user` WHERE `admin` = false";
            ResultSet rs = new DBConnectionDao().getSt().executeQuery(sql);
             ResultSetMetaData rss = rs.getMetaData();
            coloumncount = rss.getColumnCount();

            while (rs.next()) {
                id.add(rs.getInt(1));
                Name.add(rs.getString(2));
                Mobile.add(rs.getLong(3));
                Email.add(rs.getString(4));
                gender.add(rs.getString(5));
                Birthdate.add(rs.getString(6));
                Address.add(rs.getString(7));
                registerdate.add(rs.getString(9));
                Aadhar.add(rs.getLong(8));
            }

        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    public void DeleteCust()
    {
        try{ 
       String sql = "DELETE FROM `shop_user` WHERE userid = ?";
       PreparedStatement p = new DBConnectionDao().getCon().prepareStatement(sql);
       p.setInt(1,Manage_CustomersGui.cust_id);
       p.executeUpdate();
       }catch(SQLException e)
       {
           System.out.print(e);
       }
    }

    public static void main(String args[]) {
        new CustomerDao().getcust();
        System.out.print(id.get(0));
        System.out.print(id.get(1));
        System.out.print(id.get(2));
    }

}
