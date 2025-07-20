package stock_management_system_package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Product_Controller {

	//Connect DB
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//insert data function
	public static boolean insertdata(String product_name, String category, String stock_quantity, String price) {
		
		boolean isSuccess = false;
		try {
			//DB CONNECTION CALL
			con=db_connection.getConnection();
			stmt=con.createStatement();
			
			//SQL QUERY
			String sql = "insert into products values(0,'"+product_name+"','"+category+"','"+stock_quantity+"','"+price+"')";
			int rs = stmt.executeUpdate(sql);
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	//GetById
	public static List<Product_Model> getById (String id){
		
		int convertedID = Integer.parseInt(id);
		
		ArrayList <Product_Model> product = new ArrayList<>();
		
		try {
			//DBConnection
			con=db_connection.getConnection();
			stmt=con.createStatement();
			
			//Query
			String sql = "select * from products where id = '"+convertedID+"'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int product_id = rs.getInt(1);
				String product_name = rs.getString(2);
				String category = rs.getString(3);
				String stock_quantity = rs.getString(4);
				String price = rs.getString(5);
				
				Product_Model pd = new Product_Model(product_id,product_name,category,stock_quantity,price);
				product.add(pd);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	//GetAll Data
	public static List<Product_Model> getAllProduct (){
		
		ArrayList <Product_Model> product = new ArrayList<>();
		
		try {
			//DBConnection
			con=db_connection.getConnection();
			stmt=con.createStatement();
			
			//Query
			String sql = "select * from products";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int product_id = rs.getInt(1);
				String product_name = rs.getString(2);
				String category = rs.getString(3);
				String stock_quantity = rs.getString(4);
				String price = rs.getString(5);
				
				Product_Model pd = new Product_Model(product_id,product_name,category,stock_quantity,price);
				product.add(pd);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	//Update Data
	public static boolean updatedata(String product_id,String product_name,String category,String stock_quantity,String price) {
		try {
			//DBConnection
			con=db_connection.getConnection();
			stmt=con.createStatement();
			
			//SQL Query
			String sql ="update products set product_name='"+product_name+"',category='"+category+"',stock_quantity='"+stock_quantity+"',price='"+price+"'"
					+ "where product_id='"+product_id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	//Delete Data
	public static boolean deletedata(String id) {
		int convID = Integer.parseInt(id);
		try {
			//DBConnection
			con=db_connection.getConnection();
			stmt=con.createStatement();
			
			String sql = "delete from products where product_id='"+convID+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
