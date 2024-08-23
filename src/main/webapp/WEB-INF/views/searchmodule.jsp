<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <script>
        function handleChange() {
            var opt = document.getElementById("searchBy");
            var select = document.getElementById("searchValueSelect");
            var textBox = document.getElementById("searchValue");
            if (opt.value === 'genre') {
            	textBox.setAttribute("hidden", "true");
                textBox.removeAttribute("name");
                select.removeAttribute("hidden");
                select.setAttribute("name", "searchValue");
                
            } else {
                select.setAttribute("hidden", "true");
                select.removeAttribute("name");
                textBox.removeAttribute("hidden");
                textBox.setAttribute("name", "searchValue");
            }
        }
        window.onload = function() {
            handleChange();
        }
    </script>
</head>
<body>
<div class="row">
    <form action="/search" class="col-md-9" style="padding: 5px;" method="POST">
        <input type="hidden" name="origin" value="${origin}">
        <div class="row">
            <div class="col-md-4">
                <div class="form-group">
                    <label for="searchBy">Search by:</label>
                    <select id="searchBy" name="searchBy" class="form-control" onchange="handleChange()" required>
                        <option value="title" ${searchBy eq 'title'? 'selected' : ''}>Title</option>
                        <option value="author" ${searchBy eq 'author'? 'selected' : ''}>Author</option>
                        <option value="genre" ${searchBy eq 'genre'? 'selected' : ''}>Genre</option>
                    </select>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label for="searchValue">Search value:</label>
                    <input type="text" id="searchValue" name="searchValue" value="${searchValue}" class="form-control" />
                    <select id="searchValueSelect" class="form-control" hidden="true">
                        <c:forEach var="genre" items="${genres}">
                            <option value="${genre.name}" ${searchValue eq genre.name? 'selected' : ''} >${genre.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-4">
            	<div style="padding-top: 30px;">
                <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </div>
    </form>

    <!-- "Discard Searched Stocks" Button (if flag equals 1) -->
<c:if test="${flag == 1}">
    <div class="col-md-2">
        <form action="/removeSearchedStocks" method="post" style="padding: 5px;">
            <input type="hidden" name="origin" value="${origin}">
            <div style="padding-top: 30px;">
            <button type="submit" class="btn btn-danger">Discard Search</button>
            </div>
        </form>
    </div>
</c:if>

    
</div>

</body>
</html>