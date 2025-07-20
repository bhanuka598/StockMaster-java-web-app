package stock_management_system_package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SupplierDeleteServlet")  // Make sure this matches JSP URL exactly
public class SupplierDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String supplierIdParam = request.getParameter("supplier_id");
        System.out.println("Delete request for supplier_id: " + supplierIdParam);

        if (supplierIdParam == null) {
            response.sendRedirect(request.getContextPath() + "/supplierViewSerlvet");
            return;
        }

        try {
            int supplierId = Integer.parseInt(supplierIdParam);
            boolean isDeleted = SupplierController.deleteSupplierById(supplierId);
            System.out.println("Deletion success? " + isDeleted);

            if (isDeleted) {
                response.sendRedirect(request.getContextPath() + "/supplierViewSerlvet?deleteSuccess=true");
            } else {
                request.setAttribute("errorMessage", "Failed to delete supplier.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid supplier ID.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
