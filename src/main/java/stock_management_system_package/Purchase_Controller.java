package stock_management_system_package;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Purchase_Controller {

	//Connect DB
	private static boolean isSuccess;
	private static Connection con = null;
	private static java.sql.Statement stmt = null;
	private static ResultSet rs = null;
	
	//insert data function
	public static boolean insertdata(String product_id, String supplier_id, String purchase_date, String quantity, String purchase_price, String total_cost) {
		
		boolean isSuccess = false;
		try {
			//DB CONNECTION CALL
			con=db_connection.getConnection();
			stmt=con.createStatement();
			
			//SQL QUERY
			String sql = "insert into purchases values(0,'"+product_id+"','"+supplier_id+"','"+purchase_date+"','"+quantity+"','"+purchase_price+"','"+total_cost+"')";
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
	public static List<Purchase_Model> getById (String id){
		
		int convertedID = Integer.parseInt(id);
		
		ArrayList <Purchase_Model> purchase = new ArrayList<>();
		
		try {
			//DBConnection
			con=db_connection.getConnection();
			stmt=con.createStatement();
			
			//Query
			String sql = "select * from purchases where id = '"+convertedID+"'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int purchase_id = rs.getInt(1);
				String product_id = rs.getString(2);
				String supplier_id = rs.getString(3);
				String purchase_date = rs.getString(4);
				String quantity = rs.getString(5);
				String purchase_price = rs.getString(6);
				String total_cost = rs.getString(7);
					
				Purchase_Model pc = new Purchase_Model(purchase_id,product_id,supplier_id, purchase_date,quantity,purchase_price,total_cost);
				purchase.add(pc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return purchase;
	}
	
	//GetAll Data
	public static List<Purchase_Model> getAllPurchase (){
			
		ArrayList <Purchase_Model> purchase = new ArrayList<>();
			
		try {
			//DBConnection
			con=db_connection.getConnection();
			stmt=con.createStatement();
				
			//Query
			String sql = "select * from purchases";
				
			rs = stmt.executeQuery(sql);
				
			while(rs.next()) {
				int purchase_id = rs.getInt(1);
				String product_id = rs.getString(2);
				String supplier_id = rs.getString(3);
				String purchase_date = rs.getString(4);
				String quantity = rs.getString(5);
				String purchase_price = rs.getString(6);
				String total_cost = rs.getString(7);
					
				Purchase_Model pc = new Purchase_Model(purchase_id,product_id,supplier_id, purchase_date,quantity,purchase_price,total_cost);
				purchase.add(pc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return purchase;
	}
		
	//Update Data
	public static boolean updatedata(String purchase_id ,String product_id, String supplier_id, String purchase_date, String quantity, String purchase_price, String total_cost) {
		try {
			//DBConnection
			con=db_connection.getConnection();
			stmt=con.createStatement();
				
			//SQL Query
			String sql ="update purchases set product_id='"+product_id+"',supplier_id='"+supplier_id+"',purchase_date='"+purchase_date+"',quantity='"+quantity+"',purchase_price='"+purchase_price+"',total_cost='"+total_cost+"'"
						+ "where purchase_id='"+purchase_id+"'";
				
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
				
			String sql = "delete from purchases where purchase_id='"+convID+"'";
				
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
