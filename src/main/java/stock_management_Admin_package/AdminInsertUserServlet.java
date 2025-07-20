package stock_management_Admin_package;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stock_management_system_package.login_controller;

/**
 * Servlet implementation class AdminInsertUserServlet
 */
@WebServlet("/AdminInsertUserServlet")
public class AdminInsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        boolean isTrue;
        isTrue = login_controller.insertdata(full_name, email, password, role);

        if (isTrue==true) {
            String alertMessage = "User added successfully";
            response.getWriter().write("<script>alert('" + alertMessage + "'); window.location='AdminViewServlet';</script>");
        } else 
        {
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    } 
}