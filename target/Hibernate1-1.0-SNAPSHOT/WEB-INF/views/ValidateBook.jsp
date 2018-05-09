<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 09.05.2018
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${valid}" var="error">
        <h3>nazwa pola : nazwa bledu</h3>
        <p><c:out value="${error.propertyPath} : ${error.message}"/></p>
    </c:forEach>
</ul>

</body>
</html>