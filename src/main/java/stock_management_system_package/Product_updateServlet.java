package stock_management_system_package;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Product_updateServlet")
public class Product_updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_id = request.getParameter("product_id");
		String product_name = request.getParameter("product_name");
		String category = request.getParameter("category");
		String stock_quantity = request.getParameter("stock_quantity");
		String price = request.getParameter("price");
		
		boolean isTrue;
		isTrue = Product_Controller.updatedata(product_id, product_name, category, stock_quantity, price);
		
		if(isTrue == true) {
			List<Product_Model> product_details = Product_Controller.getById(product_id);
			request.setAttribute("product_details", product_details);
			
			String alertMessage = "Data Update Successful";
			response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='Product_viewServlet'</script>");
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
		}
	}

}
