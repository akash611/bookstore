
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<%@ include file="executiveheader.jsp"%>
<div class="container" style="padding:30px">

    <h3>Edit Book ${book.bookCode}</h3>
  <c:if test="${not empty errors}">
		<div class="alert alert-danger">
		<ul style="color: red">
			<c:forEach items="${errors}" var="error">
				<li>${error.field} ${error.defaultMessage}</li>
			</c:forEach>
		</ul>
	</div>
	</c:if>
    <form action="/editbook" method="POST" enctype="multipart/form-data">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title"
                   value="${book.title}">
        </div>
        <div class="form-group">
            <label for="author">Author</label>
            <input type="text" class="form-control" id="author" name="author"
                   value="${book.author}">
        </div>
        <div class="form-group">
            <label for="author">Publisher</label>
            <input type="text" class="form-control" id="publisher" name="publisher"
                   value="${book.publisher}">
        </div>
        <div class="form-group">
            <label for="genre">Genre</label>
            <select id="genre" name="genre" class="form-control">
            <c:forEach var="genre" items="${genres}">
                <option value="${genre.id}" ${book.genre.id == genre.id ? 'selected' : ''}>${genre.name}</option>
            </c:forEach>
        </select>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" id="price" name="price"
                   value="${book.price}">
        </div>
         <div class="form-group">
            <label for="price">Publication Year</label>
            <input type="text" class="form-control" id="publicationYear" name="publicationYear"
                   value="${book.publicationYear}">
        </div>
       <div class ="form-group">
            <label for="addedBy">Added By</label>
            <p>${book.addedBy.name}</p>
        </div>
        <div class="form-group">
            <label for="additionDate">Addition Date</label>
            <p>${book.additionDate}</p>
        </div>
        <div class="form-group">
            <label for="lastModifiedBy">Last Modified By</label>
            <p>${book.lastModifiedBy.name}</p>
        </div>
        <div class ="form-group">
            <label for="modificationDate">Modification Date</label>
            <p>${book.lastModificationDate}</p>
        </div>
         <input type="hidden" name="bookCode" value="${book.bookCode}" />
           <input type="hidden" name="addedBy" value="${book.addedBy.id}" />
           <input type="hidden" name="lastModifiedBy" value="${book.lastModifiedBy.id}" />
           <input type="hidden" name="additionDate" value="${book.additionDate}" />
           <input type="hidden" name="lastModificationDate" value="${book.lastModificationDate}" />
        <button type="submit" class="btn btn-primary">Save</button>

         
           </form>
</div>
<div class="footer">
        © 2024 Akash's Book Store. All rights reserved.
 </div>
</body>
</html>