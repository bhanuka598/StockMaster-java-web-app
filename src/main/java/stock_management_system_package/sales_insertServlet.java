package stock_management_system_package;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sales_insertServlet")
public class sales_insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product_name = request.getParameter("product_name");
		String customer_name = request.getParameter("customer_name");
		String quantity = request.getParameter("quantity");
		String unit_price = request.getParameter("unit_price");
		String sale_date = request.getParameter("sale_date");
		String total_amount = request.getParameter("total_amount");
		
		
		boolean isTrue;
        isTrue = sales_controller.insertdata(product_name, customer_name, quantity, unit_price, sale_date, total_amount);

        if (isTrue==true) {
            String alertMessage = "Sales added successfully";
            response.getWriter().write("<script>alert('" + alertMessage + "'); window.location='SalesviewServlet';</script>");
        } else 
        {
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
	}

}
