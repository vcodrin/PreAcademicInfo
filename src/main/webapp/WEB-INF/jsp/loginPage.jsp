<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>

</head>
<body>
<table>
<c:forEach items="${ items}" var="a">
    <tr>
        <td>${ a}</td>
    </tr>
</c:forEach>
</table>
<form:form action="/login" method="post" modelAttribute="user">
    <label>Username</label>
    <form:input type="text" name="username" path="username"/>
    <label>Password</label>
    <form:input path="password" type="password" name="parola"/>
    <input type="submit" value="Login"/>
</form:form>



</body>

</html>