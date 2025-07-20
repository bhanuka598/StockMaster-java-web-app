package stock_management_system_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sales_controller {

    // ✅ Method to insert user data (registration)
    public static boolean insertdata(String product_name, String customer_name, String quantity, String unit_price, String sale_date, String total_amount) {
        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = db_connection.getConnection();
            System.out.println("Connection established successfully.");

            String sql = "INSERT INTO sales (product_name, customer_name, quantity, unit_price, sale_date, total_amount) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, product_name);
            pstmt.setString(2, customer_name);
            pstmt.setInt(3, Integer.parseInt(quantity)); // Convert string quantity to integer
            pstmt.setFloat(4, Float.parseFloat(unit_price)); // Convert string unit_price to float
            pstmt.setString(5, sale_date);
            pstmt.setFloat(6, Float.parseFloat(total_amount)); // Convert string total_amount to float

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

    // Method to get sales data by sales_id
    public static List<Salesinsert_model> getById(int sales_Id) {
        ArrayList<Salesinsert_model> salesList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = db_connection.getConnection();
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM sales WHERE sales_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, sales_Id); // Set sales_id as an integer for the query
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Sales data fetched: " + rs.getString("sales_id"));  // Debugging line to see if we get results

                // Create Salesinsert_model objects and add them to the list
                Salesinsert_model sales = new Salesinsert_model(
                    rs.getInt("sales_id"),
                    rs.getString("product_name"),
                    rs.getString("customer_name"),
                    rs.getInt("quantity"),
                    rs.getFloat("unit_price"),
                    rs.getString("sale_date"),
                    rs.getFloat("total_amount")
                );
                salesList.add(sales);
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

        return salesList;
    }

    // Method to get all sales data
    public static List<Salesinsert_model> getAllData() {
        ArrayList<Salesinsert_model> salesList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = db_connection.getConnection();
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM sales"; // Ensure this matches your DB schema
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // Debugging line to see if we get data from the result set
                System.out.println("Sales data fetched: " + rs.getString("sales_id"));

                // Create Salesinsert_model objects and add them to the list
                Salesinsert_model sales = new Salesinsert_model(
                    rs.getInt("sales_id"),
                    rs.getString("product_name"),
                    rs.getString("customer_name"),
                    rs.getInt("quantity"),
                    rs.getFloat("unit_price"),
                    rs.getString("sale_date"),
                    rs.getFloat("total_amount")
                );
                salesList.add(sales);
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

        System.out.println("Sales list size: " + salesList.size()); // Print the size of the list to confirm if data is being added
        return salesList;
    }
    
    
    //update data controller
    
    public static boolean updatedata(String sales_id, String product_name, String customer_name, String quantity, String unit_price, String sale_date, String total_amount) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;

        try {
            // Establish database connection
            con = db_connection.getConnection();
            System.out.println("Connection established successfully.");

            // SQL query to update the sales record
            String sql = "UPDATE sales SET product_name = ?, customer_name = ?, quantity = ?, unit_price = ?, sale_date = ?, total_amount = ? WHERE sales_id = ?";

            // Prepare the statement and set parameters
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, product_name);
            pstmt.setString(2, customer_name);
            pstmt.setInt(3, Integer.parseInt(quantity)); // Convert quantity to integer
            pstmt.setFloat(4, Float.parseFloat(unit_price)); // Convert unit_price to float
            pstmt.setString(5, sale_date);
            pstmt.setFloat(6, Float.parseFloat(total_amount)); // Convert total_amount to float
            pstmt.setInt(7, Integer.parseInt(sales_id)); // Convert sales_id to integer

            // Execute the update query
            int rowsAffected = pstmt.executeUpdate();

            // If rows are affected, set success flag to true
            if (rowsAffected > 0) {
                isSuccess = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle invalid number format exceptions (e.g., for quantity, unit_price, and total_amount)
            e.printStackTrace();
        } finally {
            try {
                // Close the resources to avoid memory leaks
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccess; // Return true if the update was successful, false otherwise
    }

   }
    
  

