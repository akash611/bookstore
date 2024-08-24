<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
	<%@ include file="executiveheader.jsp"%>
	<div class="container" Style="padding:50px ;">
	<div class="alert">
	<c:if test="${not empty errors}">
		
		<ul style="color: red">
			<c:forEach items="${errors}" var="error">
				<li>${error.field} ${error.defaultMessage}</li>
			</c:forEach>
		</ul>
	</c:if>
	</div>
    <h2>Sign Up</h2>
    <form action="signup" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${buyer.name}" />
        
        <br />
        <label for="username">User Name:</label>
        <input type="text" id="username" name="username" value="${buyer.username}" />
        
        <br />
        <label for="emailId">Email Id:</label>
        <input type="text" id="emailId" name="emailId" value="${buyer.emailId}" />
        
        <br />
        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" value="${buyer.phoneNumber}" />
        
        <br />
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${buyer.address}" />
        <br />
        
    
        <label for="city">City:</label>
        <input type="text" id="city" name="city" value="${buyer.city}" />
        <br />
        <label for="pinCode">PIN Code:</label>
        <input type="text" id="pinCode" name="pinCode" value="${buyer.pinCode}" />
        
        <br />
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${buyer.password}" />
        
        <br />
         <label for="password2">Confirm Password:</label>
        <input type="password" id="password2" name="password2" value="${buyer.password}" />
        <br />
     
        
        <input type="submit" value="Sign Up" />
    </form>
    </div>
    <div class="footer">
        © 2024 Akash's Book Store. All rights reserved.
    </div>
</body>
</html>