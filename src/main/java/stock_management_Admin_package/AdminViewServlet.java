package stock_management_Admin_package;

import stock_management_system_package.login_controller;
import stock_management_system_package.login_model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Loads all users for the admin dashboard and forwards to the JSP.
 */
@WebServlet("/AdminViewServlet")
public class AdminViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles GET requests by fetching all users and forwarding to mainAdminDashboard.jsp.
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {
        // 1) Fetch all users from the controller
        List<login_model> userList = login_controller.getAllUsers();

        // 2) Store list in request scope
        request.setAttribute("userList", userList);

        // 3) Forward to your admin dashboard JSP
        request.getRequestDispatcher("mainAdmindashBoard.jsp")
               .forward(request, response);
    }

    /**
     * Delegate POST to GET to allow form submissions to refresh the page.
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {
        doGet(request, response);
    }
}
