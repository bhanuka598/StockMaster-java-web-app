package stock_management_system_package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * Servlet implementation class sales_UpdateServlet
 */
@WebServlet("/sales_UpdateServlet")
public class sales_UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public sales_UpdateServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the input values from the form
        String sales_id = request.getParameter("sales_id");
        String product_name = request.getParameter("product_name");
        String customer_name = request.getParameter("customer_name");
        String quantity = request.getParameter("quantity");
        String unit_price = request.getParameter("unit_price");
        String sale_date = request.getParameter("sale_date");
        String total_amount = request.getParameter("total_amount");

        // Print the received values (for debugging purposes)
        System.out.println("Sales ID: " + sales_id);
        System.out.println("Product Name: " + product_name);
        System.out.println("Customer Name: " + customer_name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Unit Price: " + unit_price);
        System.out.println("Sale Date: " + sale_date);
        System.out.println("Total Amount: " + total_amount);

        // Call the updatedata method to update the sales record in the database
        boolean isUpdated = sales_controller.updatedata(sales_id, product_name, customer_name, quantity, unit_price, sale_date, total_amount);

        // Prepare the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (isUpdated) {
            // If the data was successfully updated, redirect to the Sales page with a success message
            out.println("<html><body>");
            out.println("<h3>Sale updated successfully!</h3>");
            out.println("<a href='SalesviewServlet.java'>Go back to Sales Management</a>");
            out.println("</body></html>");
        } else {
            // If there was an issue with the update, show an error message
            out.println("<html><body>");
            out.println("<h3>Error updating sale. Please try again.</h3>");
            out.println("<a href='SalesviewServlet.java'>Go back to Sales Management</a>");
            out.println("</body></html>");
        }
    }
}