<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="stock_management_system_package.Salesinsert_model" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sales Management - Stock Management System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
  <style>
    .btn {
      padding: 0.5rem 1rem;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      text-decoration: none;
      font-size: 0.9rem;
    }

    .btn-primary {
      background: #1E50B4;
      color: white;
    }

    .btn-primary:hover {
      background: #153A80;
    }

    .table-container {
      flex: 1;
      padding: 1rem;
      background: white;
    }

    .table {
      width: 100%;
      border-collapse: collapse;
    }

    .table th, .table td {
      padding: 0.75rem;
      border-bottom: 1px solid #eee;
      text-align: left;
    }

    .overlay {
      display: none;
      position: fixed;
      top: 0; left: 0;
      width: 100vw; height: 100vh;
      background: rgba(0,0,0,0.5);
      align-items: center;
      justify-content: center;
      z-index: 1000;
    }
    .overlay.active {
      display: flex;
    }
    .modal {
      background: white;
      padding: 1.5rem;
      border-radius: 8px;
      width: 90%;
      max-width: 400px;
      box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }
    .modal label {
      display: block;
      margin-top: 1rem;
      font-weight: bold;
    }
    .modal input {
      width: 100%;
      padding: 0.5rem;
      margin-top: 0.25rem;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    .close-btn {
      margin-top: 1.25rem;
      background: blue;
      color: white;
    }
  </style>
</head>

<body>
  <div class="layout">
    <!-- Sidebar -->
    <aside class="sidebar">
      <div class="nav-brand">
        <h1>StockMaster</h1>
      </div>
      <nav class="nav-menu">
        <a href="AdmindashBoard.jsp" class="nav-item">Dashboard</a>
        <a href="Product_viewServlet" class="nav-item">Products</a>
        <a href="Suppliers.jsp" class="nav-item">Suppliers</a>
        <a href="Purchase_viewServlet" class="nav-item">Purchases</a>
        <a href="Sales.jsp" class="nav-item active">Sales</a>
      </nav>
    </aside>

    <!-- Main Content -->
    <main class="main-content">
      <header class="header">
        <h1>Sales Management</h1>
        <div>
          <button class="btn btn-primary" onclick="openModal('overlaySale')">Add New Sale</button>
          <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Logout</a>
        </div>
      </header>

      <!-- Modal Overlay for Add New Sale -->
      <div class="overlay" id="overlaySale">
        <div class="modal">
          <h3>Add New Sale</h3>
          <form action="sales_insertServlet" method="post">
            <label for="saleProductName">Product Name</label>
            <input type="text" name="product_name" placeholder="Enter product name" required>

            <label for="saleCustomer">Customer</label>
            <input type="text" name="customer_name" placeholder="Enter customer name" required>

            <label for="saleQuantity">Quantity</label>
            <input type="number" name="quantity" placeholder="Enter quantity" required>

            <label for="salePrice">Unit Price</label>
            <input type="text" name="unit_price" placeholder="Enter unit price" required>

            <label for="saleDate">Sale Date</label>
            <input type="date" name="sale_date" placeholder="Select date" required>

            <label for="saleAmount">Total Amount</label>
            <input type="text" name="total_amount" placeholder="Total amount" required>

            <div style="text-align: right;">
              <button type="submit" class="btn close-btn">Add Sale</button>
              <button class="btn close-btn" onclick="closeModal('overlaySale')">Close</button>
            </div>
          </form>
        </div>
      </div>

      <!-- Sales Table -->
      <div class="table-container">
        <table class="table">
          <thead>
            <tr>
              <th>Invoice</th>
              <th>Product Name</th>
              <th>Customer</th>
              <th>Date</th>
              <th>Amount</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            <c:if test="${not empty salesList}">
              <c:forEach var="sale" items="${salesList}">
                <tr>
                  <td>${sale.sales_id}</td>
                  <td>${sale.product_name}</td>
                  <td>${sale.customer_name}</td>
                  <td>${sale.sale_date}</td>
                  <td>${sale.total_amount}</td>
               	<td>
               		<button type="button" class="btn btn-primary" onclick="openModal('editSale')">Update</button>
               		<button class="btn">Delete</button>
               	</td>
               	</form>
               	
               	      <!-- Modal Overlay for edit Sale -->
      <div class="overlay" id="editSale">
        <div class="modal">
          <h3>Update Sale</h3>
          <form action="" method="post">
            <label for="saleProductName">Product Name</label>
            <input type="text" name="product_name" placeholder="Enter product name" required>

            <label for="saleCustomer">Customer</label>
            <input type="text" name="customer_name" placeholder="Enter customer name" required>

            <label for="saleQuantity">Quantity</label>
            <input type="number" name="quantity" placeholder="Enter quantity" required>

            <label for="salePrice">Unit Price</label>
            <input type="text" name="unit_price" placeholder="Enter unit price" required>

            <label for="saleDate">Sale Date</label>
            <input type="date" name="sale_date" placeholder="Select date" required>

            <label for="saleAmount">Total Amount</label>
            <input type="text" name="total_amount" placeholder="Total amount" required>

            <div style="text-align: right;">
              <button type="button" class="btn close-btn">Update Sale</button>
              <button type="button" class="btn close-btn" onclick="closeModal('editSale')">Close</button>
            </div>
          </form>
        </div>
      </div>
               	
               	
              </c:forEach>
            </c:if>
            
            <c:if test="${empty salesList}">
              <tr>
                <td colspan="6">No sales data available.</td>
              </tr>
            </c:if>
          </tbody>
        </table>
      </div>
    </main>
  </div>

  <script>
    // Function to open modal by id
    function openModal(modalId) {
      document.getElementById(modalId).classList.add('active');
    }

    // Function to close modal by id
    function closeModal(modalId) {
      document.getElementById(modalId).classList.remove('active');
    }
  </script>
</body>
</html>
