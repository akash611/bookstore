
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
</head>
<body>
<c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
</c:if>

<%@ include file="storeheader.jsp" %>
    <h1>Books</h1>
    <table>
        <thead>
            <tr>
                <th>Book Code</th>
                <th>Title</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Genre</th>
                <th>Publication Year</th>
                <th>Added By</th>
                <th>Added Date</th>
                <th>Last Modified By</th>
                <th>Last Modification Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.bookCode}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.publisher}</td>
                    <td>${book.genre.name}</td>
                    <td>${book.publicationYear}</td>
                    <td>${book.addedBy.name}</td>
                    <td>${book.additionDate}</td>
                    <td>${book.lastModifiedBy.name}</td>
                    <td>${book.lastModificationDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
       <div class="footer">
        © 2024 Akash's Book Store. All rights reserved.
    </div>
</body>
</html>