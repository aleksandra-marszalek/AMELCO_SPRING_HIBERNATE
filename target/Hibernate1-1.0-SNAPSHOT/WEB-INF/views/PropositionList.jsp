<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 09.05.2018
  Time: 16:15
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
    <c:forEach items="${propositions}" var="book">
        <li>
            <h3>${book.title}</h3>
            <p>${book.description}</p>
            <ul>
                <c:forEach items="${book.authors}" var="author">
                    <li>
                        <p>${author.firstName} ${author.lastName}</p>
                    </li>
                </c:forEach>
            </ul>
            <p>${book.publisher.name}</p>
            <%--<p><a href="/book/edit/${book.id}">Edit book</a> </p>--%>
            <%--<p><a href="/book/delete/${book.id}">Delete book</a> </p>--%>
        </li>
    </c:forEach>
</ul>

</body>
</html>