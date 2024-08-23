<!DOCTYPE html>
<html>
<head>
    <title>Executive Dashboard</title>
</head>
<body>
<%@ include file="executiveheader.jsp"%>
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
            <tr> <th>No.</th>
                <th>Book </th>
                <th>Book Title</th>
                <th>Author</th>
                <th>Genre</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Update</th>
                 <th>Un-List</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach var="stock" items="${stocks}" varStatus="loop">
                <tr>  <td>${loop.index + 1}</td>
                    <td><a href="/viewbook/${stock.book.bookCode}">${stock.book.bookCode}</a></td>
                    <td><a href="/viewbook/${stock.book.bookCode}">${stock.book.title}</a></td>
                    <td>${stock.book.author}</td>
                    <td>${stock.book.genre.name}</td>
                    <td> ${stock.book.price}</td>
                    <td>
                        <form action="/updatestock" method="post">
                            <input type="hidden" name="id" value="${stock.id}" />
                            <input type="number" name="quantity" value="${stock.quantity}" min="0" required />
                    </td>
                    <td>
                            <button type="submit" class="btn btn-primary">Update</button>
                        </td> 
                        </form>
                        <form action="/unlistbookfromstock" method="post">
                            <input type="hidden" name="id" value="${stock.id}" />
                            <td>
                            <button type="submit" class="btn btn-danger">Un-List</button>
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