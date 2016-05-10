<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action="/admin/deleteBook" method="post">
        <table class="sample">
            <tr>
                <td>Book id</td>
                <td>Author</td>
                <td>Title</td>
                <td>Books in library</td>
                <td colspan="2">Balance</td>
            </tr>
            <c:forEach var="movie" items="${movies}" varStatus="loopCounter">
                <tr>
                    <td align="center">${movie.id}</td>
                    <td>${movie.description}</td>
                    <td>${movie.title}</td>
                    <td align="center">${movie.startNumber}</td>
                    <td>${movie.balance}</td>
                    <td><input type="checkbox" name="booksIds" value="${movie.id}"><BR></td>
                </tr>
            </c:forEach>
        </table>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input type="submit" value="Delete movie">
    </form>
</div>

<c:if test="${not empty notDeletedBooks}"> You can not delete movies with id "
    <c:forEach var="notDelBook" items="${notDeletedBooks}" varStatus="loopCounter">
        <c:out value="${notDelBook}"></c:out>
    </c:forEach>
    " before users return them
</c:if>


<div>
    <form:form method="post" action="/admin/addBook" commandName="movie">

        <table>
            <tr>
                <td>Author :<form:input path="description"/></td>
            </tr>
            <tr>
                <td>Title :<form:input path="title"/></td>
            </tr>
            <tr>
                <td>Start number :<form:input path="balance"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add movie"/></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
