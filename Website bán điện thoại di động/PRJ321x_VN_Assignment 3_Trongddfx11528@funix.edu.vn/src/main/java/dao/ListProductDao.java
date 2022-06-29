package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import context.DBContext;
import model.Cart;
import model.Customer;
import model.Product;
import model.ProductOrders;

public class ListProductDao {
     Connection conn = null;
     PreparedStatement ps = null;
     ResultSet rs = null;
    public List<Product> getAllProduct() {
    List<Product> list = new ArrayList<>();
    String query = "select * from shoppingdb.products";
    try {
    	conn = new DBContext().getConnection(); // connect to MySql
    	ps = conn.prepareStatement(query);
    	rs = ps.executeQuery();
    	while (rs.next()) {
    	 list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),
    			 rs.getString(5),rs.getString(6),rs.getString(7)));
    	}
    } catch (Exception e) {
    	System.out.print(e.getMessage());
    }
    return list;
  }
    
    public List<Product> pagingList(int index) {
    	List<Product> list = new ArrayList<Product>();
    	String query = "select * from shoppingdb.products limit ?,6";
    	try {
        	conn = new DBContext().getConnection(); // connect to MySql
        	ps = conn.prepareStatement(query);
        	ps.setInt(1, (index-1)*6);
        	rs = ps.executeQuery();
        	while (rs.next()) {
           	 list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),
           			 rs.getString(5),rs.getString(6),rs.getString(7)));
           	}
        } catch (Exception e) {
        	System.out.print(e.getMessage());
        }
        return list;
    }
    
    public Product getProductbyID(String id) {
    	String query = "select * from shoppingdb.products where product_id = ?";
    	try {
        	conn = new DBContext().getConnection(); // connect to MySql
        	ps = conn.prepareStatement(query);
        	ps.setString(1, id);
        	rs = ps.executeQuery();
        	while (rs.next()) {
           	 return new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),
           			 rs.getString(5),rs.getString(6),rs.getString(7));
           	}
        } catch (Exception e) {
        	System.out.print(e.getMessage());
        }
        return null;  	
    }
    
    public List<Product> Search(String search) {
    	List<Product> list = new ArrayList<>();
    	String query = "select * from shoppingdb.products where product_name like ?";
    	try {
        	conn = new DBContext().getConnection(); // connect to MySql
        	ps = conn.prepareStatement(query);
        	ps.setString(1, "%"+ search + "%");
        	rs = ps.executeQuery();
        	while (rs.next()) {
           	 list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),
           			 rs.getString(5),rs.getString(6),rs.getString(7)));
           	}
        } catch (Exception e) {
        	System.out.print(e.getMessage());
        }
    	if(list.isEmpty()) {
    		System.out.print("Nothing Found!");
    	}
    	return list;
    }
    
    public void saveData(List<ProductOrders> po, Customer c) {
    	String sql1 = "insert into cartandcustomer.cart values(?,?,?,?)";
    	String sql2 = "insert into cartandcustomer.customer values(?,?,?)";
    	try {
    		conn = new DBContext().getConnection();
    	   PreparedStatement ps1 = conn.prepareStatement(sql1);
    	   PreparedStatement ps2 = conn.prepareStatement(sql2);
    	   for(ProductOrders o: po) {
    	   ps1.setString(1, o.getNameProduct());	
    	   ps1.setFloat(2, o.getPrice());	
    	   ps1.setInt(3, o.getAmountProduct());	
    	   ps1.setFloat(4, o.getTotalprice());
    	   ps1.executeUpdate();
    	   }
           ps2.setString(1, c.getName());
           ps2.setString(2, c.getAddress());
           ps2.setInt(3, c.getPhoneNumber());
           ps2.executeUpdate();
    	} catch (Exception e) {
    		System.out.print(e.getMessage());
    	}
    }
    
    //Check if access data to MySql successfully
    public static void main (String[] args) {
    	ListProductDao dao = new ListProductDao();
    	List<Product> list = dao.getAllProduct();
    	List<Product> listPage = dao.pagingList(1);
    	for (Product o: listPage) {
    		System.out.println(o);
    	}
    }
}
