<%@ include file="header.jsp" %>
<%@ page import="com.example.preAcademicInfo.constants.DisplayType" %>

<form:form modelAttribute="${modelAttribute}" action="${action}" method="POST">
    <c:forEach items="${inputAttributes}" var="item" varStatus="i">
        <c:set var="it" value="${item.getName().substring(0,1).toUpperCase().concat(item.getName().substring(1))}"/>
        <c:set var="type" value="${item.getDisplayType()}"/>
        <span class="label-input100">${it}</span>
        <c:choose>
            <c:when test="${!type.equals(DisplayType.CHECKBOX)}">
                <form:input path="${item}" type="${type.getName()}" htmlEscape="true" placeholder="${it}"
                            required="required"/>
            </c:when>
            <c:otherwise>
                <input type="${type.getName()}" name="${item.getName()}"/> <input type="number" name="${item.getName()}" min="7" max="14" name="${i.index}">
                <script>
                    console.log('${i.index}');
                </script>
            </c:otherwise>
        </c:choose>
        <br>
    </c:forEach>
    <input type="submit" value="Submit"/>

</form:form>

<%@ include file="footer.jsp" %>
