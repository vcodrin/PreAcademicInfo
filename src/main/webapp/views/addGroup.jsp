<%@ include file="header.jsp" %>
<%@ page import="com.example.preAcademicInfo.utils.FormatUtils" %>
<form:form class="well form-horizontal" method="POST" modelAttribute="${model}">
    <div class="container">
        <table class="table table-striped">
            <tr>
                <td colspan="1">
                    <fieldset>
                        <c:forEach items="${attributes}" var="attr">
                        <div class="form-group">
                            <label class="col-md-4 control-label">${FormatUtils.capitalize(attr.getName())}</label>
                            <div class="col-md-8 inputGroupContainer">
                                <div class="input-group">
                                    <span class="input-group-addon"></span>
                                    <form:input path="${attr.getName()}"
                                                placeholder="${FormatUtils.capitalize(attr.getName())}"
                                                class="form-control"
                                                required="required" value=""
                                                type="text"/>
                                </div>
                            </div>
                            <form:errors path="${attr.getName()}" cssClass="col-md-8 control-label"
                                         cssStyle="color: red; font-size: 15px"/>
                        </div>
                    </fieldset>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-group">
                        <div class="input-group">
                            <input type="submit" value="Submit" class="btn btn-primary btn-lg active" role="button"
                                   aria-pressed="true"/>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</form:form>

