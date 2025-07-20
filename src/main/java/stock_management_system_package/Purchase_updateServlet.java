package stock_management_system_package;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Purchase_updateServlet")
public class Purchase_updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String purchase_id = request.getParameter("purchase_id");
		String product_id = request.getParameter("product_id");
		String supplier_id = request.getParameter("supplier_id");
		String purchase_date = request.getParameter("purchase_date");
		String quantity = request.getParameter("quantity");
		String purchase_price = request.getParameter("purchase_price");
		String total_cost = request.getParameter("total_cost");
		
		boolean isTrue;
		isTrue = Purchase_Controller.updatedata(purchase_id, product_id, supplier_id, purchase_date, quantity, purchase_price, total_cost);
		
		if(isTrue == true) {
			List<Purchase_Model> purchase_details = Purchase_Controller.getById(purchase_id);
			request.setAttribute("purchase_details", purchase_details);
			
			String alertMessage = "Data Update Successful";
			response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='Purchase_viewServlet'</script>");
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
		}
	}

}
