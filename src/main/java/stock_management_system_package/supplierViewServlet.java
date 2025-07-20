package stock_management_system_package;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class supplierViewServlet
 */
@WebServlet("/supplierViewServlet")
public class supplierViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Fetch all suppliers
	        List<suplplierInsertModel> suppliers = SupplierController.getAllData();

	        // Set suppliers list into request scope
	        request.setAttribute("suppliers", suppliers);

	        // Forward to JSP for rendering
	        request.getRequestDispatcher("Suppliers.jsp").forward(request, response);
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
