<%@ include file="headerLogin.jsp" %>

<div class="limiter">
    <div class="container-login100"
         style="background-image: url('${pageContext.request.contextPath}/resources/images/bg-01.jpg');">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
            <form:form modelAttribute="user" action="${action}" method="POST" class="login100-form validate-form">
					<span class="login100-form-title p-b-49">
						Login
					</span>

                <div class="wrap-input100 validate-input m-b-23">
                    <span class="label-input100">Username</span>
                    <form:input class="input100" type="text" path="username" placeholder="Username" htmlEscape="true"
                                required="required"/>
                </div>
                <div class="wrap-input100 validate-input">
                    <span class="label-input100">Password</span>
                    <form:input class="input100" type="password" placeholder="Password" path="password" htmlEscape="true"
                                required="required"/>
                </div>
                <c:if test="${error!=null}">
                    <label style="color: red">${error.message}</label>
                </c:if>
                <div class="text-right p-t-8 p-b-31">
                    <a href="${forgotPassword}">
                        Forgot password?
                    </a>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" type="submit">
                            Login
                        </button>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
