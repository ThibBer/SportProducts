<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
        <title><spring:message code="login"/></title>
        <meta charset="UTF-8">
    </head>
    <body class="bg-light">
        <div class="container">
            <div class="row justify-content-center w-100">
                <div class="d-flex flex-column justify-content-center w-50 py-5">
                    <div class="text-center py-3">
                        <h2><spring:message code="login"/></h2>
                    </div>

                    <div class="card">
                        <div class="card-body mx-5">
                            <div class="row text-center">
                                <div class="col">
                                    <i class="fas fa-user-circle fa-8x"></i>
                                    <br/>
                                    <h3><spring:message code="alreadyHaveAccount" /></h3>
                                </div>
                            </div>

                            <div class="row my-4">
                                <div class="col">
                                    <div class="row">
                                        <div class="col">
                                            <form:form method="post" modelAttribute="user">
                                                <div class="form-group">
                                                    <spring:message code="username" var="username"/>
                                                    <form:input path="username" cssClass="form-control bg-light" placeholder="${username}"/>
                                                    <div class="error"><form:errors path="username"/></div>
                                                </div>

                                                <div class="form-group">
                                                    <spring:message code="password" var="password"/>
                                                    <form:input path="password" cssClass="form-control bg-light" type="password" placeholder="${password}"/>
                                                    <div class="error"><form:errors path="password"/></div>
                                                </div>

                                                <c:if test="${param.error != null}">
                                                    <div class="error"><spring:message code='loginError'/></div>
                                                </c:if>

                                                <div class="form-group">
                                                    <form:button type="submit" class="btn btn-default mx-auto d-block mt-md-3"><spring:message code="login"/></form:button>
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <a class="btn btn-default btn-block text-center" href="<spring:url value='/register'/>">
                                <spring:message code="createAccount" />
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
