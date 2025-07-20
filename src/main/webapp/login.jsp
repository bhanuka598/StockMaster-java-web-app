<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Stock Master - Login</title>
  <style>
    body { font-family: Arial, sans-serif; display: flex; height: 100vh; margin: 0; }
    .container { display: flex; width: 100%; }
    .left-panel {
      background: #1E50B4; color: white; width: 50%; padding: 50px;
      display: flex; flex-direction: column; justify-content: center;
    }
    .right-panel {
      width: 50%; display: flex; align-items: center; justify-content: center;
      background: #F4F4F4;
    }
    .form-container {
      background: white; padding: 30px; border-radius: 8px;
      box-shadow: 0px 4px 6px rgba(0,0,0,0.1); width: 350px;
    }
    input, button { width: 100%; padding: 10px; margin: 8px 0;
      border-radius: 5px; border: 1px solid #ccc;
    }
    button {
      background: #1E50B4; color: white; border: none; cursor: pointer;
    }
    button:hover { background: #153A80; }
    .signup-link { text-align: center; margin-top: 10px; }
  </style>
</head>
<body>
  <div class="container">
    <div class="left-panel">
      <h1><strong>Stock Master</strong></h1>
      <p>Streamline your inventory management with Stock Master.</p>
      <p>&copy; 2025 Stock Master. All rights reserved.</p>
    </div>
    <div class="right-panel">
      <div class="form-container">
        <h2>Welcome back</h2>
        <p>Enter your credentials to access your account</p>
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
          <c:if test="${not empty error}">
            <div style="color:red; margin-bottom:10px;">${error}</div>
          </c:if>
          <input
            type="email"
            name="email"
            placeholder="Enter your Gmail address"
            pattern="[a-zA-Z0-9._%+-]+@gmail\.com$"
            title="Please enter a valid Gmail address ending with @gmail.com"
            required
          >
          <input
            type="password"
            name="password"
            placeholder="Enter your password"
            required
          >
          <button type="submit">Sign in</button>
        </form>
        <p class="signup-link">
          Don’t have an account? <a href="register.jsp">Click here</a>
        </p>
      </div>
    </div>
  </div>
</body>
</html>
