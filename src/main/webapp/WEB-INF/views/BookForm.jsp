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

    rating: <form:input path="rating" placeholder="rating" type="number"/>
    <form:errors path="rating"/>

    <label>Publisher: </label>
    <form:select path="publisher.id"
                 items="${publishers}"
                 itemLabel="name"
                 itemValue="id"/>
    <form:errors path="publisher"/>

    Description:
    <form:textarea path="description" placeholder="description"/>
    <form:errors path="description"/>

    <label>Author: </label>
    <form:checkboxes path="authors"
                     items="${authors}"
                     itemLabel="lastName"
                     itemValue="id"/>
    <form:errors path="authors"/>

    <form:hidden path="id" value="${book.id}"/>

    Pages:
    <form:input path="pages" placeholder="pages" type="number"/>
    <form:errors path="pages"/>

    Add to proposition:
    <form:checkbox path="proposition"/>


    <input type="submit" value="save"/>


</form:form>

</body>



</html>
