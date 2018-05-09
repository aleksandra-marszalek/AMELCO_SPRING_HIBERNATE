<%--
  Created by IntelliJ IDEA.
  User: janmadej
  Date: 08.05.2018
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Add / modify person Detail </h1>
<form:form method="post" modelAttribute="personDto">
    Login: <form:input path="login" placeholder="login"/>
    Password: <form:password path="password" placeholder="password"/>
    E-mail: <form:input path="email" placeholder="email"/>
    First name: <form:input path="firstName" placeholder="firstName"/>
    Last name: <form:input path="lastName" placeholder="lastName"/><br>
    Male: <form:radiobutton path="gender" value="M"/> Female: <form:radiobutton path="gender" value="F"/>
    Select your country: <form:select path="country" items="${countryItems}" /><br>
    Any notes? <form:textarea path="notes" cols="100" rows="10"/><br>
    Sign me to mailing list: <form:checkbox path="mailingList"/><br>
    Select your skills: <form:select path="programmingSkills" items="${skills}" multiple="true" />
    Select your hobbies: <form:checkboxes path="hobbies" items="${hobbies}"/>
    <input type="submit" value="save">
</form:form>

</body>
</html>
