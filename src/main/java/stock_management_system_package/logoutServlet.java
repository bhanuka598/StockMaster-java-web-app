package stock_management_system_package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate(); // kills the session
            // close the session
        }
        
        // Redirect to login.jsp
        response.sendRedirect("login.jsp");
    }
}
