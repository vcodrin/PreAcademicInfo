<%@ include file="header.jsp" %>


<div class="container">
    <h2>Some items</h2>
    <div class="list-group">
        <c:forEach var="item" items="${functions}">
            <a href="${item.getUrl()}" class="list-group-item">${item.getName()}</a>
        </c:forEach>
    </div>
</div>


<%@ include file="footer.jsp" %>
