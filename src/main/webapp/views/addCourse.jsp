<%@ include file="header.jsp" %>
<%@ page import="com.example.preAcademicInfo.utils.FormatUtils" %>
<%@ page import="com.example.preAcademicInfo.constants.DisplayType" %>

<form:form modelAttribute="${modelAttribute}" action="${action}" method="POST">
    <c:forEach items="${inputAttributes}" var="item" varStatus="i">
        <c:set var="it" value="${FormatUtils.capitalize(item.getName())}"/>
        <c:set var="type" value="${item.getDisplayType()}"/>
        <span class="label-input100">${it}</span>
        <c:choose>
            <c:when test="${item.isPath()}">
                <form:input path="course.${item}" type="${type.getName()}" htmlEscape="true" placeholder="${it}"
                            required="required"/>
            </c:when>
            <c:otherwise>
                <input type="checkbox" id="${item.getName()}" name="hideShow"/>
                <input type="${type.getName()}" name="${item.getName()}" min="${item.getMin()}" max="${item.getMax()}">
                <c:forEach items="${common}" var="com">
                    <c:set var="subType" value="${FormatUtils.capitalize(com.getName())}"/>
                    <span class="label-input100">${subType}</span>
                    <c:choose>
                        <c:when test="${com.getDisplayType().equals(DisplayType.CHECKBOX)}">
                            <form:checkbox path="${item.getName()}.${com.getName()}"/>
                        </c:when>
                        <c:otherwise>
                            <form:input path="${item.getName()}.${com.getName()}"
                                        type="${com.getDisplayType().getName()}" min="${com.getMin()}"
                                        max="${com.getMax()}"/>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <br>
    </c:forEach>
    <input type="submit" value="Submit"/>

</form:form>
<script type="text/javascript">
    var checks = $('[name="hideShow"]');
    checks.each(function () {
        var el = $(this);
        hideElements(el);
        el.on("click", function () {
            if (el.is(':checked')) {
                showElements(el, "fast");
            } else {
                hideElements(el, "fast");
            }
        });
    });

    function hideElements(el, speed) {
        for (var i = 0; i < 9; i++) {
            el.removeAttr("required");
            el = el.next();
            el.hide(speed);
        }
    }

    function showElements(el, speed) {
        for (var i = 0; i < 9; i++) {
            el.attr("required", "required");
            el = el.next();
            el.show(speed);
        }
    }
</script>

<%@ include file="footer.jsp" %>
