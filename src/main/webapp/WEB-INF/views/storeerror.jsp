<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<%@ include file="storeheader.jsp"%>
<div class="container">
<c:if test="${not empty error}">
        <div class="alert alert-danger " role="alert">
        <h2>You Encountered an Error</h2>
            ${error}
        </div>
    </c:if>
 </div>
<div class="footer">
        © 2024 Akash's Book Store. All rights reserved.
 </div>
</body>
</html>