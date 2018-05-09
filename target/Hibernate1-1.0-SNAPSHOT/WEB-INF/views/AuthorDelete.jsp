<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 08.05.2018
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete</h1>
<p>Are you sure you want to delete this author?</p>
<form method="post" action="/author/delete/${author.id}">
    yes: <input type="radio" name="agree" value="yes">
    no: <input type="radio" name="agree" value="no">
    <input type="submit" value="save">
</form>

</body>
</html>
