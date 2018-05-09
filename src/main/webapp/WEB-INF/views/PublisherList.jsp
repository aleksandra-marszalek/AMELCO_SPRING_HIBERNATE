<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${publishers}" var="publisher">
        <li>
            <h3>${publisher.name}</h3>
            <ul>
                <c:forEach items="${publisher.books}" var="book">
                    <li>
                        <p>${book.title} </p>
                    </li>
                </c:forEach>
            </ul>
            <p><a href="/publisher/edit/${publisher.id}">Edit publisher</a> </p>
            <p><a href="/publisher/delete/${publisher.id}">Delete publisher</a> </p>
        </li>
    </c:forEach>
</ul>

</body>
</html>
