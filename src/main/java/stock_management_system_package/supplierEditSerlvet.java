package stock_management_system_package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class supplierEditSerlvet
 */
@WebServlet("/supplierEditSerlvet")
public class supplierEditSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            int supplierId = Integer.parseInt(request.getParameter("supplier_id"));
            String name = request.getParameter("supplier_name");
            String contactPerson = request.getParameter("contact_person");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            suplplierInsertModel supplier = new suplplierInsertModel(
                supplierId, name, contactPerson, email, phone, address
            );

            boolean isUpdated = SupplierController.updateData(supplier);

            if (isUpdated) {
            	response.sendRedirect(request.getContextPath() + "/supplierViewServlet?updateSuccess=true");
            } else {
                request.setAttribute("errorMessage", "Failed to update supplier.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid supplier ID.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
