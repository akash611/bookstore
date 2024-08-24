<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buy Books</title>
</head>
<body>
<%@ include file="storeheader.jsp"%>
    <div class="container">
  
<%@ include file="searchmodule.jsp"%>

        <!-- Display message if no stocks found -->
        <c:if test="${empty stocks}">
            <div class= "alert alert-danger">
            No Stocks Found
            </div>
        </c:if>

        <!-- Display table if stocks found -->
<c:if test="${not empty stocks}">
   <table class="table table-striped">
    <thead>
        <tr>
            <th>No.</th>
            <th>Book </th>
            <th>Book Title</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Price</th>
            <th>Order Volume</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="stock" items="${stocks}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td><a href="/viewbook/${stock.book.bookCode}">${stock.book.bookCode}</a></td>
                <td><a href="/viewbook/${stock.book.bookCode}">${stock.book.title}</a></td>
                <td>${stock.book.author}</td>
                <td>${stock.book.genre.name}</td>
                <td> ${stock.book.price}</td>
                <td>
                <form action="/addtocart" method="post">
                    <c:choose>
                     
                        <c:when test="${stock.quantity > 0}">
                            <select name="orderVolume" class="form-control" required>
                                <option value="">Select Quantity</option>
                                <c:forEach var="i" begin="1" end="${stock.quantity <= 5 ? stock.quantity : 5}">
                                    <option value="${i}">${i}</option>
                                </c:forEach>
                            </select>
                        </c:when>
                        <c:otherwise>
                            <p>Out of Stock</p>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${stock.quantity > 0}">
                           
                                <input type="hidden" name="bookCode" value="${stock.book.bookCode}" />
                                <button type="submit" class="btn btn-primary">Add to Cart</button>
                            
                        </c:when>
                        
                        <c:otherwise>
                            <p>Out of Stock</p>
                        </c:otherwise>
                    </c:choose>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:if>

        
    </div>
    <div class="footer">
        © 2024 Akash's Book Store. All rights reserved.
    </div>
</body>
</html>