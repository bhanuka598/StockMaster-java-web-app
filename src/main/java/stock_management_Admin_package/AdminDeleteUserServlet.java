package stock_management_Admin_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stock_management_system_package.login_controller;
import stock_management_system_package.sales_controller;

/**
 * Servlet implementation class AdminDeleteUserServlet
 */
@WebServlet("/AdminDeleteUserServlet")
public class AdminDeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the user_id parameter from the request
        String user_id_str = request.getParameter("user_id");

        // Convert sales_id to an integer
        int user_id = Integer.parseInt(user_id_str);

        // Call the deleteData method in the controller to delete the users record
        boolean isDeleted = login_controller.deleteData(user_id);

        // Prepare the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (isDeleted) {
            // If the deletion was successful, show a success message and redirect to SalesviewServlet
            out.println("<html><body>");
            out.println("<script>");
            out.println("alert('user deleted successfully!');");
            out.println("window.location.href = 'AdminViewServlet';"); // Redirect to SalesviewServlet
            out.println("</script>");
            out.println("</body></html>");
        } else {
            // If there was an issue with the deletion, show an error message and go back to Sales.jsp
            out.println("<html><body>");
            out.println("<h3>Error deleting sale. Please try again.</h3>");
            out.println("<a href='AdminViewServlet'>Go back to Sales Management</a>");
            out.println("</body></html>");
        }
    }

    // Handle POST requests if needed (optional, depending on your use case)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // In most cases, delete can be handled with GET method
    }
}