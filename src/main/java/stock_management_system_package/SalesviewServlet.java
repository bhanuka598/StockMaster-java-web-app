package stock_management_system_package;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SalesviewServlet")
public class SalesviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SalesviewServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Call the method to get all data from the database
        List<Salesinsert_model> salesList = sales_controller.getAllData();

        // Debugging statement to check if data is fetched
        System.out.println("Sales List Size: " + (salesList != null ? salesList.size() : "Null"));

        // Check if salesList is not null or empty
        if (salesList != null && !salesList.isEmpty()) {
            // Set the salesList as an attribute in the request
            request.setAttribute("salesList", salesList);
        } else {
            System.out.println("Sales List is empty or null.");
        }

        // Forward the request to the JSP page for display
        request.getRequestDispatcher("Sales.jsp").forward(request, response);
    }
}
