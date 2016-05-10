<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Insert title here</title>

</head>

<body>

<form:form method="Post" action="/registration"

           commandName="user">

    <table>
        <tr>
            <td>Firts name:<form:errors path="firstName"/></td>
        </tr>
        <tr>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last name:<form:errors path="lastName"/></td>
        </tr>
        <tr>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Birthday:
            <form:errors path="birthday"/></tr>
        <tr>
            <td><form:input path="birthday"/></td>
        </tr>
        <tr>
            <td>Email:
            <form:errors path="email"/></tr>
        <tr>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Login:<form:errors path="login"/></td>
        </tr>
        <tr>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td>Password:
            <form:errors path="password"/></tr>
        <tr>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>

</form:form>
${errMsg}
</body>

</html>
