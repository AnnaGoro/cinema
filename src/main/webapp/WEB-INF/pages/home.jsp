<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Kovantonlenko
  Date: 12/25/2015
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    table.sample {
        border-width: 1px;
        border-spacing: 2px;
        border-style: outset;
        border-color: gray;
        border-collapse: separate;
        background-color: white;
    }

    table.sample th {
        border-width: 1px;
        padding: 1px;
        border-style: inset;
        border-color: gray;
        background-color: white;
    }

    table.sample td {
        width: auto;
        border-width: 1px;
        padding: 1px;
        border-style: inset;
        border-color: gray;
        background-color: white;
    }

</style>


<head>
    <title></title>
</head>
<body>
<div align="right">
    <jsp:include page="logout.jsp"/>
</div>
<div align="center">
    <form action="/library/applyBook" method="post">
        <table class="sample">
            <tr>
                <td>Book №</td>
                <td>Author</td>
                <td>Title</td>
                <td colspan="2">Balance</td>
            </tr>
            <c:forEach var="movie" items="${movies}" varStatus="loopCounter">
                <tr>
                    <td align="center">${movie.id}</td>
                    <td>${movie.description}</td>
                    <td>${movie.title}</td>
                    <td>${movie.balance}</td>
                    <td><input type="radio" name="book_id" value="${movie.id}"><BR></td>
                </tr>
            </c:forEach>
        </table>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input type="submit" value="Get movie">
    </form>

    <form action="/library/returnBook" method="post">
        <table class="sample">
            <tr>
                <td>Book №</td>
                <td>Author</td>
                <td colspan="2">Title</td>
            </tr>
            <c:forEach var="userMovie" items="${userBooks}" varStatus="loopCounter">
                <tr>
                    <td align="center">${userMovie.id}</td>
                    <td>${userMovie.description}</td>
                    <td>${userMovie.title}</td>
                    <td><input type="checkbox" name="booksIds" value="${userMovie.id}"><BR></td>
                </tr>
            </c:forEach>
        </table>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input type="submit" value="Return movie">
    </form>
</div>
<c:if test="${not empty errMsg}">${errMsg}</c:if>

</body>
</html>
