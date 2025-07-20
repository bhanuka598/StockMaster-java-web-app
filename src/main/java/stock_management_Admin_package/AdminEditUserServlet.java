package stock_management_Admin_package;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import stock_management_system_package.login_model;
import stock_management_system_package.login_controller;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminEditUserServlet")
public class AdminEditUserServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String idParam = req.getParameter("user_id");
    if (idParam == null) {
      resp.sendRedirect("AdminViewServlet");
      return;
    }

    int userId = Integer.parseInt(idParam);
    login_model user = login_controller.getUserById(userId);
    if (user == null) {
      resp.sendRedirect("AdminViewServlet");
      return;
    }

    // make the user available to your JSP if you want a separate edit page
    req.setAttribute("user", user);
    // if using modal form on same page, you won’t forward
    // req.getRequestDispatcher("editUser.jsp").forward(req, resp);
    // instead just return to the dashboard
    resp.sendRedirect("mainAdminDashboard.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    int userId   = Integer.parseInt(req.getParameter("user_id"));
    String name  = req.getParameter("full_name");
    String email = req.getParameter("email");
    String role  = req.getParameter("role");

    boolean success = login_controller.updateData(userId, name, email, role);
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    if (success) {
    	out.println("<html><body>");
        out.println("<script>");
        out.println("alert('user changed successfully!');");
        out.println("window.location.href = 'AdminViewServlet';"); // Redirect to SalesviewServlet
        out.println("</script>");
        out.println("</body></html>");
    } else {
    	out.println("<html><body>");
        out.println("<h3>Error change . Please try again.</h3>");
        out.println("<a href='AdminViewServlet'>Go back to Sales Management</a>");
        out.println("</body></html>");
    }
  }
}
