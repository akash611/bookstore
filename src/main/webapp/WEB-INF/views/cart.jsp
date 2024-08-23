<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
<%@ include file="storeheader.jsp"%>
 <div class="container">
 <c:choose>
    <c:when test="${empty cart}">
        <div class="alert alert-danger"> Cart is empty</div>
    </c:when>
    <c:otherwise>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Book </th>
                    <th>Book Title</th>
                    <th>Author</th>
                    <th>Genre</th>
                    <th>Price</th>
                    <th>Order Volume</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${cart}">
                    <tr>
                        <td>${entry.key.bookCode}</td>
                        <td>${entry.key.title}</td>
                        <td>${entry.key.author}</td>
                        <td>${entry.key.genre.name}</td>
                        <td>${entry.key.price}</td>
                        <td>${entry.value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
 </div>
 <div class="footer">
        © 2024 Akash's Book Store. All rights reserved.
 </div>
</body>
</html>