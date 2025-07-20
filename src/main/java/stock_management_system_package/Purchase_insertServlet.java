package stock_management_system_package;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Purchase_insertServlet")
public class Purchase_insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_id = request.getParameter("product_id");
		String supplier_id = request.getParameter("supplier_id");
		String purchase_date = request.getParameter("purchase_date");
		String quantity = request.getParameter("quantity");
		String purchase_price = request.getParameter("purchase_price");
		String total_cost = request.getParameter("total_cost");

		boolean isTrue;

		isTrue = Purchase_Controller.insertdata(product_id, supplier_id, purchase_date, quantity, purchase_price, total_cost);

		if(isTrue == true) {
			String alertMessage = "Data Insert Successful";
			response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='Purchase_viewServlet'</script>");
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
		}
	}

}
