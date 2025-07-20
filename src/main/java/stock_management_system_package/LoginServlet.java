package stock_management_system_package;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get login form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("[LoginServlet] Received: email=" + email + ", password=" + password);

        // Validate login
        List<login_model> users = login_controller.loginValidate(email, password);

        if (!users.isEmpty()) {
            // Successful login
            login_model user = users.get(0); // Get the first matching user

            HttpSession session = request.getSession();
            session.setAttribute("email", user.getEmail());
            session.setAttribute("password", user.getPassword());
           
// Optional: store full name

            response.sendRedirect("AdmindashBoard.jsp"); 
        } else {
            // Failed login
        	
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
