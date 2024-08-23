<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false" %> 
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .login-container {
            position: absolute;
            top: 50%;
            right: 0;
            transform: translate(-50%, -50%);
            background-color: rgba(255, 255, 255, 0.5);
            padding: 20px;
            border-radius: 10px;
        }
        body {
            background-image: url('${pageContext.request.contextPath}/images/banner.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            margin: 0;
            padding: 0;
        }
        .header {
            text-align: left;
            color: white;
            font-size: 48px;
            background-color: rgb(138,43,226);
            width: 100%;
            margin: 0;
            top: 0;
            left: 0;
            padding:1.5%;
        }
        .footer {
            text-align: center;
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
            background-color: rgb(138,43,226);
            color: white;
            padding: 10px 0;
        }
        .header a {
            color: white;
            text-decoration: none; /* Remove underlines */
            font-weight: normal; /* Make the link bold */
        }
        .header a:hover {
            color: white; /* Ensure color remains white on hover */
        }
    </style>
</head>
<body>
    <div class="header">
        <a href="/" >Akash's Book Store</a>
    </div>
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="alert alert-success" role="alert">
            ${msg}
        </div>
    </c:if>
    <div class="login-container">
        <form action="/login" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Login</button>
            <p class="mt-3 text-center">Not registered? <a href="signup">Sign Up</a></p>
        </form>
    </div>
    <div class="footer">
        © 2024 Akash's Book Store. All rights reserved.
    </div>
</body>
</html>
