<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 08.05.2018
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    title: <form:input path="title" placeholder="title"/>
    <form:errors path="title"/>

    Description:
    <form:textarea path="description" placeholder="description"/>
    <form:errors path="description"/>

    <form:hidden path="proposition" value="true"/>


    <input type="submit" value="save"/>


</form:form>

</body>



</html>
