<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 08.05.2018
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
    Name: <form:input path="name" placeholder=" name"/>
    <form:errors path="name"/>

    Nip: <form:input path="nip" placeholder="nip"/>
    <form:errors path="nip"/>

    Regon: <form:input path="regon" placeholder="regon"/>
    <form:errors path="regon"/>


    <form:hidden path="id" value="${publisher.id}"/>

    <input type="submit" value="save"/>


</form:form>

</body>



</html>