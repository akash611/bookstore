<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Book</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body>
<%@ include file="storeheader.jsp"%>
<div class="container" style="padding:30px">

    <h3>Book Details</h3>
    <table>
        <tr>
            <th>Book Code</th>
            <td>${book.bookCode}</td>
        </tr>
        <tr>
            <th>Title</th>
            <td>${book.title}</td>
        </tr>
        <tr>
            <th>Author</th>
            <td> ${book.author}</td>
        </tr>
        <tr>
            <th>Genre</th>
            <td>${book.genre.name}</td>
        </tr>
        <tr>
            <th>Price</th>
            <td>${book.price}</td>
        </tr>
        <tr>
            <th>Publication Year</th>
            <td>${book.publicationYear}</td>
        </tr>
    </table>
</div>
<div class="footer">
        © 2024 Akash's Book Store. All rights reserved.
</div>
</body>
</html>