<%@include file="header.jsp" %>
<div class="list-group" id="myList" role="tablist">
    <c:forEach items="${courses}" var="course" varStatus="index">
        <a class="list-group-item list-group-item-action ${index.index == 0 ? "active" : ""}" data-toggle="list" href="#" role="tab">${course.getName()}</a>
    </c:forEach>
<%--</div>--%>
<%--<div class="list-group" id="myList" role="tablist">--%>
    <%--<a class="list-group-item list-group-item-action active" data-toggle="list" href="#home" role="tab">Home</a>--%>
    <%--<a class="list-group-item list-group-item-action" data-toggle="list" href="#profile" role="tab">Profile</a>--%>
    <%--<a class="list-group-item list-group-item-action" data-toggle="list" href="#messages" role="tab">Messages</a>--%>
    <%--<a class="list-group-item list-group-item-action" data-toggle="list" href="#settings" role="tab">Settings</a>--%>
<%--</div>--%>

<div class="tab-content">
    <div class="tab-pane active" id="home" role="tabpanel">A</div>
    <div class="tab-pane" id="profile" role="tabpanel">B</div>
    <div class="tab-pane" id="messages" role="tabpanel">C</div>
    <div class="tab-pane" id="settings" role="tabpanel">D</div>
</div>

<script>
    $('#myList a').on('click', function (e) {
        e.preventDefault()
        var t = $(this);
        $(".list-group").children().each(function () {
            $(this).removeClass();
            $(this).addClass("list-group-item list-group-item-action");
        });
        t.removeClass();
        t.addClass("list-group-item list-group-item-action active");
        $(this).tab('show')
    })
</script>
<%@include file="footer.jsp" %>