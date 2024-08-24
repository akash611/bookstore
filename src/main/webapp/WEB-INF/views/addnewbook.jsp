<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
	<%@ include file="executiveheader.jsp"%>
	<div class="container" Style="padding:50px ;">
	<c:if test="${not empty errors}">
		<div class="alert alert-danger">
		<ul style="color: red">
			<c:forEach items="${errors}" var="error">
				<li>${error.field} ${error.defaultMessage}</li>
			</c:forEach>
		</ul>
	</div>
	</c:if>
	
    <h2>Add New Book</h2>
    <form action="addnewbook" method="post">
        <label for="bookCode">Book Code:</label>
        <input type="text" id="bookCode" name="bookCode" value="${book.bookCode}" />
        
        <br />
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${book.title}" />
        
        <br />
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" value="${book.author}" />
        
        <br />
        <label for="publisher">Publisher:</label>
        <input type="text" id="publisher" name="publisher" value="${book.publisher}" />
        
        <br />
        <label for="genre">Genre:</label>
        <select id="genre" name="genre">
            <option value="">Select a genre</option>
            <c:forEach var="genre" items="${genres}">
                <option value="${genre.id}" ${book.genre.id == genre.id ? 'selected' : ''}>${genre.name}</option>
            </c:forEach>
        </select>
        </br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${book.price}" />
        <br />
        <label for="publicationYear">Publication Year:</label>
        <input type="text" id="publicationYear" name="publicationYear" value="${book.publicationYear}" />
        
        <br />
        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity" value="${stock.quantity}" />
      
        <br />
        <input type="submit" value="Add Book" />
    </form>
    </div>
    <div class="footer">
        © 2024 Akash's Book Store. All rights reserved.
    </div>
</body>
</html>