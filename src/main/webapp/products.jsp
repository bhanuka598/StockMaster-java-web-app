<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Products - Stock Management System</title>
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

    /* —— MODAL STYLES —— */
    .overlay {
      display: none;               /* hidden by default */
      position: fixed;
      top: 0; left: 0;
      width: 100vw; height: 100vh;
      background: rgba(0,0,0,0.5);
      align-items: center;
      justify-content: center;
      z-index: 1000;
    }
    .overlay.active {
      display: flex;              /* show as flex container when active */
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
    .modal input, .modal select {
      width: 100%;
      padding: 0.5rem;
      margin-top: 0.25rem;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }
    .close-btn {
      margin-top: 1.25rem;
      background: blue;
      color: white;
    }
    .status-pill {
	  display: inline-block;
	  padding: 0.3rem 0.8rem;
	  border-radius: 20px;
	  font-weight: bold;
	  font-size: 0.85rem;
	  text-align: center;
	}
	
	.status-low {
	  background-color: #fff7cc;
	  color: #804000;
	}
	
	.status-out {
	  background-color: #ffe6e6;
	  color: #a30000;
	}
	
	.status-in {
	  background-color: #d6f5d6;
	  color: #1a661a;
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
        <a href="Product_viewServlet"     class="nav-item active">Products</a>
        <a href="Suppliers.jsp"    class="nav-item">Suppliers</a>
        <a href="Purchase_viewServlet"    class="nav-item">Purchases</a>
        <a href="SalesviewServlet"        class="nav-item">Sales</a>
      </nav>
    </aside>

    <!-- Main Content -->
    <main class="main-content">
      <header class="header">
        <h1>Product Management</h1>
        <div>
          <button class="btn btn-primary" onclick="openModal()">Add New Product</button> 
          
          
          <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Logout</a>

     
        </div>
      </header>
      
            <!-- Modal Overlay -->
		      <div class="overlay" id="overlay">
		        <div class="modal">
		          <h3>Add New Product</h3>
		          <form action="Product_insertServlet" method="post" onsubmit="return validateForm()">
			          <label for="productName">Product Name</label>
			          <input id="productName" type="text" name="product_name" placeholder="Enter product name">
			
			          <label for="category">Category</label>
			          <select id="category" name="category">
			            <option value="">Select Category</option>
			            <option>Electronics</option>
			            <option>Furniture</option>
			            <option>Office Supplies</option>
			            <option>Stationery</option>
			          </select>
			          
			          <label for="stockQuantity">Stock Quantity</label>
			          <input id="stockQuantity" type="number" name="stock_quantity" placeholder="Enter stock quantity">
			          
			          <label for="price">Price</label>
			          <input id="price" type="text" name="price" placeholder="Enter price">
			
			          <div style="text-align: right;">
			            <button class="btn close-btn" onclick="closeModal()">Close</button>
			          </div>
			        </form>
		        </div>
		      </div>
      
      
      <!-- Products Table -->
      <div class="table-container">
        <div style="padding-bottom:1rem;">
          <input type="text" id="searchProduct" class="form-input" placeholder="Search products..." style="max-width:300px;">
        </div>
        <table class="table">
          <thead>
            <tr>
              <th>Product ID</th>
              <th>Product Name</th>
              <th>Category</th>
              <th>Quantity</th>
              <th>Price</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
	          <c:forEach var="product" items="${allProducts}">
				<tr>
				<td>${product.product_id}</td>
        		<td>${product.product_name}</td>
        		<td>${product.category}</td>
        		<td>${product.stock_quantity}</td>
        		<td>${product.price}</td>
        		<td>
					  <c:choose>
					    <c:when test="${product.stock_quantity >= 5}">
					      <span class="status-pill status-in">In Stock</span>
					    </c:when>
					    <c:when test="${product.stock_quantity > 0 && product.stock_quantity < 5}">
					      <span class="status-pill status-low">Low Stock</span>
					    </c:when>
					    <c:otherwise>
					      <span class="status-pill status-out">Out of Stock</span>
					    </c:otherwise>
					  </c:choose>
				</td>
				<td>
					<button class="btn btn-primary" onclick="openUpdateModal(
						  '${product.product_id}',
						  '${product.product_name}',
						  '${product.category}',
						  '${product.stock_quantity}',
						  '${product.price}'
						)">Update</button>

					<!-- style="background-color: #04AA6D; color: white;" for update button -->
					<form action="Product_deleteServlet" method="post" style="margin: 0;display: inline-block;">
							<input type="hidden" name="product_id" value="${product.product_id}" />
							<button class="btn" >Delete</button>
					</form>
					<!-- style="background-color: #f44336; color: white;" for delete button -->
					
				</td>
					
				</tr>
				</c:forEach>
          </tbody>
        </table>
      </div>
      
      
		<!-- Update Modal Overlay -->
		<div class="overlay" id="updateOverlay">
		  <div class="modal">
		    <h3>Update Product</h3>
		    <form action="Product_updateServlet" method="post" onsubmit="return validateForm()">
		      
		      <!-- Hidden Product ID -->
		      <input type="hidden" id="updateProductId" name="product_id">
		      
		      <label for="updateProductName">Product Name</label>
		      <input id="updateProductName" type="text" name="product_name" placeholder="Update product name">
		      
		      <label for="updateCategory">Category</label>
		      <select id="updateCategory" name="category">
		        <option value="">Select Category</option>
		        <option>Electronics</option>
		        <option>Furniture</option>
		        <option>Office Supplies</option>
		        <option>Stationery</option>
		      </select>
		      
		      <label for="updateStockQuantity">Stock Quantity</label>
		      <input id="updateStockQuantity" type="number" name="stock_quantity" placeholder="Update stock quantity">
		      
		      <label for="updatePrice">Price</label>
		      <input id="updatePrice" type="text" name="price" placeholder="Update price">
		      
		      <div style="text-align: right;">
		        <button class="btn" type="submit">Update</button>
		        <button class="btn close-btn" type="button" onclick="closeModal('updateOverlay')">Close</button>
		      </div>
		    </form>
		  </div>
		</div>


      
      
    </main>
  </div>

  <script>
  
    function openModal() {
      document.getElementById('overlay').classList.add('active').style.display = 'block';
    }
    function closeModal(modalId = 'overlay') {
    	  const modal = document.getElementById(modalId);
    	  modal.classList.remove('active');
    	  modal.style.display = 'none';
    }
    function openUpdateModal(id, name, category, stock, price) {
		  document.getElementById('updateProductId').value = id;
		  document.getElementById('updateProductName').value = name;
		  document.getElementById('updateCategory').value = category;
		  document.getElementById('updateStockQuantity').value = stock;
		  document.getElementById('updatePrice').value = price;
		  
		  document.getElementById('updateOverlay').classList.add('active');
		  document.getElementById('updateOverlay').style.display = 'flex';
	}
    function filterProduct() {
    	var input, filter, table, tr, td, i, txtValue;
    	input = document.getElementById("searchProduct");
    	filter = input.value.toUpperCase();
    	table = document.querySelector("table");
    	tr = table.getElementsByTagName("tr");
    	
    	for (i = 0; i < tr.length; i++) {
    		td = tr[i].getElementsByTagName("td");
    		for (var j = 0; j < td.length; j++) {
    			if (td[j]) {
    				txtValue = td[j].textContent || td[j].innerText;
    				if (txtValue.toUpperCase().indexOf(filter) > -1) {
    					tr[i].style.display = "";
    					break;
    				} else {
    					tr[i].style.display = "none";
    				}
    			}
    		}
    	}
    }
    function validateForm(){
    	var quantity = document.getElementById("stockQuantity").value;
    	var stquantity = document.getElementById("updateStockQuantity").value;
    	var price = document.getElementById("price").value;
    	var stprice = document.getElementById("updatePrice").value;
    	
    	if (quantity && quantity.value < 1){
    		alert("Quantity can not be less than 1.");
    		quantity.focus();
    		return false; // can not submit
    	}
    	
    	if (stquantity && stquantity.value < 1){
    		alert("Quantity can not be less than 1.");
    		stquantity.focus();
    		return false; // can not submit
    	}
    	
    	if (price && price.value < 1){
    		alert("Price can not be zero.");
    		price.focus();
    		return false; // can not submit
    	}
    	
    	if (stprice && stprice.value < 1){
    		alert("Price can not be zero.");
    		stprice.focus();
    		return false; // can not submit
    	}
    	
    	return true; // all validations passed
    }
    
    document.getElementById("searchProduct").addEventListener("input", filterProduct);
    
  </script> 
  

  

</body>
</html>