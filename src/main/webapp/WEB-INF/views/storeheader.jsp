<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- Retrieve username from session --%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            background-color: rgb(138,43,226);
            color: white;
           
        }
        .nav-links ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
        }
        .nav-links li {
            margin-right: 20px;
        }
        .nav-links a {
            color: white;
            text-decoration: none;
        }
         .user-section a {
            color: white;
            text-decoration: none;
        }
        .nav-links a:hover {
            color: #f8f9fa;
        }
        .user-section {
            display: flex;
            align-items: center;
        }
        .user-section p {
            margin-right: 10px;
        }
        .btn {
            margin-left: 10px;
        }
          .footer {
            text-align: center;
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
            background-color: rgb(138,43,226);
            color: white;
            padding: 10px 0;}
            .title a {
            color: white;
            text-decoration: none; /* Remove underlines */
            font-weight: normal; /* Make the link bold */
            font-size:32px;
           
        }
        .title a:hover {
            color: #f8f9fa; /* Ensure color blue on hover */
        }
    </style>
</head>
<body>
    <header class="header">
    	<div class="title">
          <a  href="/" >Akash's Book Store</a>
          </div>
        <nav class="nav-links">
            <ul>
                <li><a href="/bookstore">Order Books</a></li>
                <li><a href="/orders">My Orders</a></li>
                <li><a href="/cart">Cart</a></li>
            </ul>
        </nav>
        <nav class="user-section">
           <c:choose>
                        <c:when test="${empty user}">
                            <a class="btn btn-primary" href="/login">Log In</a>
                            <a class="btn btn-primary" href="/signup">Sign Up</a>
                        </c:when>
                        <c:otherwise>
            			<a href="/profile">${user.name}</a>
            			<a class="btn btn-primary" href="/logout">Log Out</a>
                        </c:otherwise>
                    </c:choose>
        </nav>
    </header>
    <c:if test="${not empty msg}">
    <div class="alert alert-success">${msg}</div>
</c:if>
    
</body>
</html>
