<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 08.05.2018
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add / modify person </h1>
<form:form method="post" modelAttribute="person">
    <form:input path="login" placeholder="login"/>
    <form:password path="password" placeholder="password"/>
    <form:input path="email" placeholder="email"/>

    <input type="submit" value="save">
</form:form>

</body>
</html>
