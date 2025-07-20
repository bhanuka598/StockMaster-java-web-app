<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Stock Management System</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
    <div class="layout">
        <aside class="sidebar">
            <div class="nav-brand">
                <h1>StockMaster</h1>
            </div>
            <nav class="nav-menu">
                <a href="dashboard.html" class="nav-item active">Dashboard</a>
                <a href="Product_viewServlet" class="nav-item">Products</a>
                <a href="Suppliers.jsp" class="nav-item">Suppliers</a>
                <a href="Purchase_viewServlet" class="nav-item">Purchases</a>
                <a href="SalesviewServlet" class="nav-item">Sales</a>
            </nav>
        </aside>
        <main class="main-content">
            <header class="header">
                <h1>Dashboard</h1>
                <<a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Logout</a>
            </header>
            <div class="stats-grid">
                <div class="stat-card">
                    <h3>Total Products</h3>
                    <p class="stat-value">247</p>
                </div>
                <div class="stat-card">
                    <h3>Active Suppliers</h3>
                    <p class="stat-value">36</p>
                </div>
                <div class="stat-card">
                    <h3>Monthly Purchases</h3>
                    <p class="stat-value">89</p>
                </div>
                <div class="stat-card">
                    <h3>Monthly Sales</h3>
                    <p class="stat-value">124</p>
                </div>
            </div>
            <div class="table-container">
                <h2 style="padding: 1rem;">Low Stock Items</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th>Category</th>
                            <th>Quantity</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Laptop Charger Type-C</td>
                            <td>Electronics</td>
                            <td>5</td>
                            <td><span class="badge badge-warning">Low Stock</span></td>
                        </tr>
                        <tr>
                            <td>Office Chair (Black)</td>
                            <td>Furniture</td>
                            <td>3</td>
                            <td><span class="badge badge-danger">Critical Stock</span></td>
                        </tr>
                        <tr>
                            <td>Printer Paper A4</td>
                            <td>Office Supplies</td>
                            <td>12</td>
                            <td><span class="badge badge-warning">Low Stock</span></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</body>
</html>