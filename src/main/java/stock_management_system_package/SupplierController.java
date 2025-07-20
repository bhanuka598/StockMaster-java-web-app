package stock_management_system_package;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class SupplierController {
	

	 private static Connection con = null;
	 private static ResultSet rs = null;
	    

    public static boolean insertdata(String supplier_name, String contact_person, String email, String phone, String address) {
    	 boolean isSuccess = false;
         PreparedStatement pstmt = null;
    	
        try {
        con = db_connection.getConnection();
        System.out.println("Connection established successfully.");


        String sql = "INSERT INTO suppliers (supplier_name, contact_person, email, phone, address) VALUES ( ?, ?, ?, ?, ?)";
        		pstmt = con.prepareStatement(sql);
                pstmt.setString(1, supplier_name);
                pstmt.setString(2, contact_person);
                pstmt.setString(3, email);
                pstmt.setString(4, phone);
                pstmt.setString(5, address);

                int rowsAffected = pstmt.executeUpdate();
                isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();  // Handle invalid number format
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccess;
    }
    
    
    public static List<suplplierInsertModel> getAllData() {
        List<suplplierInsertModel> supplierList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = db_connection.getConnection();
            System.out.println("Connection established successfully.");

            String sql = "SELECT supplier_id, supplier_name, contact_person, email, phone, address FROM suppliers";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Supplier data fetched: " + rs.getInt("supplier_id"));

                suplplierInsertModel supplier = new suplplierInsertModel(
                    rs.getInt("supplier_id"),
                    rs.getString("supplier_name"),
                    rs.getString("contact_person"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address")
                );
                supplierList.add(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Supplier list size: " + supplierList.size());
        return supplierList;
    }
    
    
    
    /**
     * Update an existing supplier record.
     */
    public static boolean updateData(suplplierInsertModel supplier) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;
        try {
            con = db_connection.getConnection();
            String sql = "UPDATE suppliers SET supplier_name = ?, contact_person = ?, email = ?, phone = ?, address = ? " +
                         "WHERE supplier_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, supplier.getSupplier_name());
            pstmt.setString(2, supplier.getContact_person());
            pstmt.setString(3, supplier.getEmail());
            pstmt.setString(4, supplier.getPhone());
            pstmt.setString(5, supplier.getAddress());
            pstmt.setInt(6, supplier.getSupplier_id());

            int rowsAffected = pstmt.executeUpdate();
            isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }
    
    

    public static boolean deleteSupplierById(int supplierId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = db_connection.getConnection();  // Your method to get DB connection
            String sql = "DELETE FROM suppliers WHERE supplier_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, supplierId);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    }
