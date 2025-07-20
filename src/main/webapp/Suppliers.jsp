<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Suppliers - Stock Management System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
  <style>
    /* Table Styles */
    .suppliers-table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 2rem;
      background: white;
      box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      overflow: hidden;
    }
    
    .suppliers-table th, .suppliers-table td {
      padding: 0.75rem 1rem;
      text-align: left;
      border-bottom: 1px solid #e0e0e0;
    }
    
    .suppliers-table th {
      background-color: #f8f9fa;
      font-weight: bold;
    }
    
    .suppliers-table tbody tr:hover {
      background-color: #f1f3f5;
    }
    
    /* Button Styles */
    .btn {
      padding: 0.5rem 1rem;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      text-decoration: none;
      font-size: 0.9rem;
      display: inline-block;
    }

    .btn-primary {
      background: #1E50B4;
      color: white;
    }

    .btn-primary:hover {
      background: #153A80;
    }

    .btn-secondary {
      background: #6c757d;
      color: white;
    }

    .btn-secondary:hover {
      background: #5a6268;
    }

    .btn-danger {
      background: #dc3545;
      color: white;
    }

    .btn-danger:hover {
      background: #bd2130;
    }
    
    .btn-sm {
      padding: 0.25rem 0.5rem;
      font-size: 0.8rem;
    }
    
    .actions {
      display: flex;
      gap: 0.5rem;
    }

    /* Form Styles */
    .form-container {
      padding: 1.5rem;
      background: white;
      box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      max-width: 800px;
      margin: 0 auto 2rem auto;
      display: none; /* Hidden by default */
    }

    .form-group {
      margin-bottom: 1rem;
    }

    .form-group label {
      display: block;
      margin-bottom: 0.5rem;
      font-weight: bold;
    }

    .form-control {
      width: 100%;
      padding: 0.5rem;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    .form-actions {
      display: flex;
      justify-content: flex-end;
      gap: 0.5rem;
      margin-top: 1.5rem;
    }
    
    .required:after {
      content: " *";
      color: red;
    }
    
    .error-message {
      color: #dc3545;
      font-size: 0.9rem;
      margin-top: 0.25rem;
    }

    /* Layout Utilities */
    .d-flex {
      display: flex;
    }
    
    .justify-between {
      justify-content: space-between;
    }
    
    .align-center {
      align-items: center;
    }
    
    .mb-3 {
      margin-bottom: 1rem;
    }
    
    .mb-4 {
      margin-bottom: 1.5rem;
    }
    
    /* Search Styles */
    .search-container {
      margin-bottom: 1.5rem;
    }
    
    .search-box {
      padding: 0.5rem;
      border: 1px solid #ccc;
      border-radius: 4px;
      width: 250px;
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
        <a href="SupplierServlet" class="nav-item active">Suppliers</a>
        <a href="Purchase_viewServlet" class="nav-item">Purchases</a>
        <a href="SalesviewServlet" class="nav-item">Sales</a>
      </nav>
    </aside>

    <!-- Main Content -->
    <main class="main-content">
      <header class="header d-flex justify-between align-center mb-4">
        <h1>Suppliers</h1>
        <button id="addSupplierBtn" class="btn btn-primary">Add New Supplier</button>
      </header>

      <!-- Add/Edit Supplier Form -->
      <div id="supplierForm" class="form-container">
        <div class="d-flex justify-between align-center mb-3">
          <h2 id="formTitle">Add New Supplier</h2>
          <button id="closeFormBtn" class="btn btn-secondary">×</button>
        </div>
        
        <form id="supplierFormElement" action="Supplier_insertServlet" method="post">
          <input type="hidden" name="action" id="formAction" value="add">
          <input type="hidden" name="supplier_id" id="supplier_id" value="">

          <div class="form-group">
            <label for="supplier_name" class="required">Company Name</label>
            <input type="text" class="form-control" id="supplier_name" name="supplier_name" required>
            <div class="error-message" id="supplier_name_error"></div>
          </div>

          <div class="form-group">
            <label for="contact_person">Contact Person</label>
            <input type="text" class="form-control" id="contact_person" name="contact_person">
          </div>

          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email">
            <div class="error-message" id="email_error"></div>
          </div>

          <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" id="phone" name="phone">
            <div class="error-message" id="phone_error"></div>
          </div>

          <div class="form-group">
            <label for="address">Address</label>
            <textarea class="form-control" id="address" name="address" rows="3"></textarea>
          </div>

          <div class="form-actions">
            <button type="button" id="cancelFormBtn" class="btn btn-danger">Cancel</button>
            <button type="submit" class="btn btn-primary" id="saveBtn">Save Supplier</button>
          </div>
        </form>
      </div>
      
      <!-- Search Box -->
      <div class="search-container">
        <input type="text" id="searchSuppliers" class="search-box" placeholder="Search suppliers...">
      </div>

      <!-- Suppliers Table -->
      <div class="table-responsive">
        <table class="suppliers-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Company Name</th>
              <th>Contact Person</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="supplier" items="${suppliersList}">
              <tr>
                <td>${supplier.supplier_id}</td>
                <td>${supplier.supplier_name}</td>
                <td>${supplier.contact_person}</td>
                <td>${supplier.email}</td>
                <td>${supplier.phone}</td>
                <td class="actions">
                  <button class="btn btn-secondary btn-sm edit-btn" 
                          data-id="${supplier.supplier_id}"
                          data-name="${supplier.supplier_name}"
                          data-contact="${supplier.contact_person}"
                          data-email="${supplier.email}"
                          data-phone="${supplier.phone}"
                          data-address="${supplier.address}">
                    Edit
                  </button>
                  <button class="btn btn-danger btn-sm delete-btn" 
                          data-id="${supplier.supplier_id}"
                          data-name="${supplier.supplier_name}">
                    Delete
                  </button>
                </td>
              </tr>
            </c:forEach>
            
            <c:if test="${empty suppliersList}">
              <tr>
                <td colspan="6" style="text-align: center;">No suppliers found</td>
              </tr>
            </c:if>
          </tbody>
        </table>
      </div>
      
      <!-- Delete Confirmation Modal -->
      <div id="deleteModal" style="display: none; position: fixed; top: 0; left: 0; right: 0; bottom: 0; background: rgba(0,0,0,0.5); z-index: 1000;">
        <div style="background: white; padding: 2rem; border-radius: 8px; width: 400px; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
          <h3>Confirm Delete</h3>
          <p>Are you sure you want to delete supplier: <span id="deleteSupplierName"></span>?</p>
          <div style="display: flex; justify-content: flex-end; gap: 1rem; margin-top: 1.5rem;">
            <button id="cancelDeleteBtn" class="btn btn-secondary">Cancel</button>
            <form id="deleteForm" action="SupplierDeleteServlet" method="post">
              <input type="hidden" name="action" value="delete">
              <input type="hidden" name="supplier_id" id="deleteSupplierID">
              <button type="submit" class="btn btn-danger">Delete</button>
            </form>
          </div>
        </div>
      </div>
    </main>
  </div>

  <script>
    // Form display functions
    document.getElementById('addSupplierBtn').addEventListener('click', function() {
      showAddForm();
    });
    
    document.getElementById('closeFormBtn').addEventListener('click', function() {
      hideForm();
    });
    
    document.getElementById('cancelFormBtn').addEventListener('click', function() {
      hideForm();
    });
    
    // Edit buttons
    document.querySelectorAll('.edit-btn').forEach(button => {
      button.addEventListener('click', function() {
        const id = this.getAttribute('data-id');
        const name = this.getAttribute('data-name');
        const contact = this.getAttribute('data-contact');
        const email = this.getAttribute('data-email');
        const phone = this.getAttribute('data-phone');
        const address = this.getAttribute('data-address');
        
        showEditForm(id, name, contact, email, phone, address);
      });
    });
    
    // Delete buttons
    document.querySelectorAll('.delete-btn').forEach(button => {
      button.addEventListener('click', function() {
        const id = this.getAttribute('data-id');
        const name = this.getAttribute('data-name');
        showDeleteConfirmation(id, name);
      });
    });
    
    // Cancel delete
    document.getElementById('cancelDeleteBtn').addEventListener('click', function() {
      hideDeleteConfirmation();
    });
    
    // Search functionality
    document.getElementById('searchSuppliers').addEventListener('input', function() {
      const searchValue = this.value.toLowerCase();
      const rows = document.querySelectorAll('.suppliers-table tbody tr');
      
      rows.forEach(row => {
        const text = row.textContent.toLowerCase();
        row.style.display = text.includes(searchValue) ? '' : 'none';
      });
    });
    
    // Form utility functions
    function showAddForm() {
      document.getElementById('formTitle').textContent = 'Add New Supplier';
      document.getElementById('formAction').value = 'add';
      document.getElementById('supplier_id').value = '';
      document.getElementById('supplierFormElement').reset();
      document.getElementById('saveBtn').textContent = 'Save Supplier';
      document.getElementById('supplierForm').style.display = 'block';
    }
    
    function showEditForm(id, name, contact, email, phone, address) {
      document.getElementById('formTitle').textContent = 'Edit Supplier';
      document.getElementById('formAction').value = 'update';
      document.getElementById('supplier_id').value = id;
      document.getElementById('supplier_name').value = name;
      document.getElementById('contact_person').value = contact || '';
      document.getElementById('email').value = email || '';
      document.getElementById('phone').value = phone || '';
      document.getElementById('address').value = address || '';
      document.getElementById('saveBtn').textContent = 'Update Supplier';
      document.getElementById('supplierForm').style.display = 'block';
    }
    
    function hideForm() {
      document.getElementById('supplierForm').style.display = 'none';
      document.getElementById('supplier_name_error').textContent = '';
      document.getElementById('email_error').textContent = '';
    }
    
    function showDeleteConfirmation(id, name) {
      document.getElementById('deleteSupplierID').value = id;
      document.getElementById('deleteSupplierName').textContent = name;
      document.getElementById('deleteModal').style.display = 'block';
    }
    
    function hideDeleteConfirmation() {
      document.getElementById('deleteModal').style.display = 'none';
    }
    
    // Form validation
    document.getElementById('supplierFormElement').addEventListener('submit', function(e) {
      let isValid = true;
      
      // Validate supplier name
      const supplierName = document.getElementById('supplier_name').value.trim();
      if (!supplierName) {
        document.getElementById('supplier_name_error').textContent = 'Company name is required';
        isValid = false;
      } else {
        document.getElementById('supplier_name_error').textContent = '';
      }
      
      // Validate email format if provided
      const email = document.getElementById('email').value.trim();
      if (email && !isValidEmail(email)) {
        document.getElementById('email_error').textContent = 'Please enter a valid email address';
        isValid = false;
      } else {
        document.getElementById('email_error').textContent = '';
      }
      
      // Validate phone number
      const phone = document.getElementById('phone').value.trim();
      const phoneError = document.getElementById('phone_error');
      if (phone && !/^\d{10}$/.test(phone)) {
        if (!phoneError) {
          const errorDiv = document.createElement('div');
          errorDiv.id = 'phone_error';
          errorDiv.className = 'error-message';
          errorDiv.textContent = 'Phone number must be exactly 10 digits';
          document.getElementById('phone').parentNode.appendChild(errorDiv);
        } else {
          phoneError.textContent = 'Phone number must be exactly 10 digits';
        }
        isValid = false;
      } else if (phoneError) {
        phoneError.textContent = '';
      }
      
      if (!isValid) {
        e.preventDefault();
      }
      
    });
    
    function isValidEmail(email) {
      const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      return re.test(email);
    }
    
    // Initialize error messages
    <c:if test="${not empty errors}">
      <c:if test="${not empty errors.supplier_name}">
        document.getElementById('supplier_name_error').textContent = "${errors.supplier_name}";
      </c:if>
      <c:if test="${not empty errors.email}">
        document.getElementById('email_error').textContent = "${errors.email}";
      </c:if>
      // Show form if there were validation errors
      document.getElementById('supplierForm').style.display = 'block';
    </c:if>
  </script>
</body>
</html>