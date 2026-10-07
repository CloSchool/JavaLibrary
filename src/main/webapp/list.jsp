<%@ page import="entities.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Books</title>
</head>
<body>
    <table border="2px">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Year</th>
            <th>Available</th>
            <th>Actions</th>
        </tr>
        <% List<Book> books = (List<Book>) request.getAttribute("books"); %>
        <% if (books.size() > 0) { %>
            <% for (Book book : books) { %>
                <tr>
                    <td><%= book.getId() %></td>
                    <td><%= book.getTitle() %></td>
                    <td><%= book.getAuthor() %></td>
                    <td><%= book.getYear() %></td>
                    <td><%= book.isAvailable() ? "Yes" : "No" %></td>
                    <td><a href="${pageContext.request.contextPath}/update?id=<%= book.getId() %>">Toggle Status</a></td>
                </tr>
            <% } %>
        <% } %>
    </table>
</body>
</html>
