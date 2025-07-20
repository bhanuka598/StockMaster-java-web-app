package stock_management_system_package;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Supplier_insertServlet")
public class Supplier_insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        
	           
	            String name = request.getParameter("supplier_name");
	            String contactPerson = request.getParameter("contact_person");
	            String email = request.getParameter("email");
	            String phone = request.getParameter("phone");
	            String address = request.getParameter("address");

	            
	            boolean isTrue;
	            isTrue = SupplierController.insertdata(name, contactPerson, email, phone, address);
	           

	            if (isTrue== true) {
	            	String alertMessage = "supplier added successfully";
	                response.getWriter().write("<script>alert('" + alertMessage + "'); window.location='supplierViewServlet';</script>");
	            
	            } else {
	            	RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
	                dis2.forward(request, response);
	            }
	}
}
