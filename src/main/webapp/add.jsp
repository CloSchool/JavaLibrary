<%--
  Created by IntelliJ IDEA.
  User: princ
  Date: 2026-10-07
  Time: 11:44 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
    <form method="post">
        <div>
            <label for="title">Title</label>
            <input type="text" id="title" name="title">
        </div>

        <div>
            <label for="author">Author</label>
            <input type="text" id="author" name="author">
        </div>

        <div>
            <label for="year">Year</label>
            <input type="number" id="year" name="year">
        </div>

        <div>
            <label for="available">Available</label>
            <input type="checkbox" id="available" name="available">
        </div>

        <button type="submit">Add Book</button>
    </form>
</body>
</html>
