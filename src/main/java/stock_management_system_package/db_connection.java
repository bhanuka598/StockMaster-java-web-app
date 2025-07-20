package stock_management_system_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connection {
    private static final String url = "jdbc:mysql://localhost:3306/stock_management_db1";
    private static final String user = "root";  
    private static final String pass = "admin";  

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Ensure driver is loaded
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Database connection failed!");
        }
        return con;
    }
}
