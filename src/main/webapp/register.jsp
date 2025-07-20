<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock Master - Sign Up</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            height: 100vh;
            margin: 0;
        }
        .container {
            display: flex;
            width: 100%;
        }
        .left-panel {
            background: #1E50B4;
            color: white;
            width: 50%;
            padding: 50px;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        .right-panel {
            width: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            background: #F4F4F4;
        }
        .form-container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        h2 {
            margin-bottom: 10px;
        }
        input, select, button {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        button {
            background: #1E50B4;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background: #153A80;
        }
        .login-link {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="left-panel">
            <h1><strong>Stock Master</strong></h1>
            <p>Streamline your inventory management with Stock Master - The ultimate solution for efficient stock control and sales tracking.</p>
            <p>&copy; 2025 Stock Master. All rights reserved.</p>
        </div>
        <div class="right-panel">
            <div class="form-container">
                <h2>Create an account</h2>
                <p>Sign up to get started with Stock Master</p>
                <form action="insertServlet" method="post">
                    <input type="text" name="full_name" placeholder="Enter your full name" required>
                    <input type="email" name="email" placeholder="Enter your email" required>
                    <input type="password" name="password" placeholder="Create a password" required>
                    
                    <button type="submit" value="submit ">Create account</button>
                </form>
                <p class="login-link">Already have an account? <a href="login.jsp">Click here</a></p>
            </div>
        </div>
    </div>
</body>
</html>
