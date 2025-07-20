<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Purchase Management - Stock Management System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
  <style>
    /* Your existing CSS (no changes needed here) */
    .btn { padding: 0.5rem 1rem; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; font-size: 0.9rem; }
    .btn-primary { background: #1E50B4; color: white; }
    .btn-primary:hover { background: #153A80; }
    .table-container { padding: 1rem; background: white; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); border-radius: 8px; }
    .table { width: 100%; border-collapse: collapse; }
    .table th, .table td { padding: 0.75rem; border-bottom: 1px solid #eee; text-align: left; }
    .overlay { display: none; position: fixed; top: 0; left: 0; width: 100vw; height: 100vh; background: rgba(0, 0, 0, 0.5); align-items: center; justify-content: center; z-index: 1000; }
    .overlay.active { display: flex; }
    .modal { background: white; padding: 1.5rem; border-radius: 8px; width: 90%; max-width: 400px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }
    .modal label { display: block; margin-top: 1rem; font-weight: bold; }
    .modal input, .modal select { width: 100%; padding: 0.5rem; margin-top: 0.25rem; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
    .close-btn { margin-top: 1.25rem; background: blue; color: white; }
  </style>
</head>
<body>
  <div class="layout">
    <aside class="sidebar">
      <div class="nav-brand"><h1>StockMaster</h1></div>
      <nav class="nav-menu">
        <a href="AdmindashBoard.jsp" class="nav-item">Dashboard</a>
        <a href="Product_viewServlet" class="nav-item">Products</a>
        <a href="Suppliers.jsp" class="nav-item">Suppliers</a>
        <a href="purchases.jsp" class="nav-item active">Purchases</a>
        <a href="SalesviewServlet" class="nav-item">Sales</a>
      </nav>
    </aside>

    <main class="main-content">
      <header class="header">
        <h1>Purchase Management</h1>
        <div>
          <button class="btn btn-primary" onclick="openModal()">Add New Purchase</button>
          <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Logout</a>
        </div>
      </header>

      <!-- Search -->
      <div class="search-bar">
        <input type="text" id="searchPurchase" class="form-input" placeholder="Search purchases...">
      </div>

      <!-- Add Purchase Modal -->
      <div class="overlay" id="overlay">
        <div class="modal">
          <h3>Add New Purchase</h3>
          <form action="Purchase_insertServlet" method="post" onsubmit="return validatePurchaseForm(this)">
            <label>Product ID</label>
            <input type="number" name="product_id" required>

            <label>Supplier ID</label>
            <input type="number" name="supplier_id" required>

            <label>Purchase Date</label>
            <input type="date" name="purchase_date" required>

            <label>Quantity</label>
            <input type="number" name="quantity" required>

            <label>Purchase Price</label>
            <input type="text" name="purchase_price" required>

            <label>Total Cost</label>
            <input type="text" name="total_cost" required>

            <div style="text-align: right;">
              <button type="submit" class="btn btn-primary">Save</button>
              <button type="button" class="btn close-btn" onclick="closeModal()">Close</button>
            </div>
          </form>
        </div>
      </div>

      <!-- Table -->
      <div class="table-container">
        <table class="table">
          <thead>
            <tr>
              <th>Purchase ID</th>
              <th>Product ID</th>
              <th>Supplier ID</th>
              <th>Purchase Date</th>
              <th>Quantity</th>
              <th>Purchase Price</th>
              <th>Total Cost</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="purchase" items="${allPurchases}">
              <tr>
                <td>${purchase.purchase_id}</td>
                <td>${purchase.product_id}</td>
                <td>${purchase.supplier_id}</td>
                <td>${purchase.purchase_date}</td>
                <td>${purchase.quantity}</td>
                <td>${purchase.purchase_price}</td>
                <td>${purchase.total_cost}</td>
                <td>
                  <button class="btn" onclick="openUpdateModal(
                    '${purchase.purchase_id}', '${purchase.product_id}', '${purchase.supplier_id}',
                    '${purchase.purchase_date}', '${purchase.quantity}', '${purchase.purchase_price}', '${purchase.total_cost}')">Edit</button>

                  <form action="Purchase_deleteServlet" method="post" style="display:inline;">
                    <input type="hidden" name="purchase_id" value="${purchase.purchase_id}">
                    <button type="submit" class="btn">Delete</button>
                  </form>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>

      <!-- Update Modal -->
      <div class="overlay" id="updateOverlay">
        <div class="modal">
          <h3>Update Purchase</h3>
          <form action="Purchase_updateServlet" method="post" onsubmit="return validatePurchaseForm(this)">
            <input type="hidden" id="updatePurchaseId" name="purchase_id">

            <label>Product ID</label>
            <input type="number" id="updateProductID" name="product_id" required>

            <label>Supplier ID</label>
            <input type="number" id="updateSupplierID" name="supplier_id" required>

            <label>Purchase Date</label>
            <input type="date" id="updatePurchaseDate" name="purchase_date" required>

            <label>Quantity</label>
            <input type="number" id="updateQuantity" name="quantity" required>

            <label>Purchase Price</label>
            <input type="text" id="updatePurchasePrice" name="purchase_price" required>

            <label>Total Cost</label>
            <input type="text" id="updateTotalCost" name="total_cost" required>

            <div style="text-align: right;">
              <button type="submit" class="btn btn-primary">Update</button>
              <button type="button" class="btn close-btn" onclick="closeModal('updateOverlay')">Close</button>
            </div>
          </form>
        </div>
      </div>
    </main>
  </div>

  <!-- JS -->
  <script>
    function openModal() {
      const modal = document.getElementById('overlay');
      modal.classList.add('active');
      modal.style.display = 'flex';
    }

    function closeModal(modalId = 'overlay') {
      const modal = document.getElementById(modalId);
      modal.classList.remove('active');
      modal.style.display = 'none';
    }

    function openUpdateModal(purchase_id, product_id, supplier_id, purchase_date, quantity, purchase_price, total_cost) {
      document.getElementById('updatePurchaseId').value = purchase_id;
      document.getElementById('updateProductID').value = product_id;
      document.getElementById('updateSupplierID').value = supplier_id;
      document.getElementById('updatePurchaseDate').value = purchase_date;
      document.getElementById('updateQuantity').value = quantity;
      document.getElementById('updatePurchasePrice').value = purchase_price;
      document.getElementById('updateTotalCost').value = total_cost;
      document.getElementById('updateOverlay').classList.add('active');
      document.getElementById('updateOverlay').style.display = 'flex';
    }

    // Filter functionality
    document.getElementById("searchPurchase").addEventListener("input", function () {
      var input = this.value.toUpperCase();
      var rows = document.querySelectorAll(".table tbody tr");

      rows.forEach(function (row) {
        let found = false;
        row.querySelectorAll("td").forEach(function (cell) {
          if (cell.textContent.toUpperCase().indexOf(input) > -1) {
            found = true;
          }
        });
        row.style.display = found ? "" : "none";
      });
    });
    
    function validatePurchaseForm(form) {
        const purchaseDate = new Date(form.purchase_date.value);
        const today = new Date();
        today.setHours(0, 0, 0, 0); // Ignore time

        if (purchaseDate > today) {
          alert("Purchase date cannot be in the future.");
          form.purchase_date.focus();
          return false;
        }

        const quantity = parseInt(form.quantity.value, 10);
        if (isNaN(quantity) || quantity <= 0) {
          alert("Quantity must be a positive number.");
          form.quantity.focus();
          return false;
        }

        return true; // allow submission
      }
  </script>
</body>
</html>
