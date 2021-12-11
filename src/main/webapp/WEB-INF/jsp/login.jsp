<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
        <title><spring:message code="login"/></title>
        <meta charset="UTF-8">
    </head>
    <body>
        <div class="row justify-content-center">
            <div class="d-flex flex-column justify-content-center w-50">
                <div class="text-center pt-2">
                    <h2><spring:message code="login"/></h2>
                </div>
                <form:form method="post" modelAttribute="user">
                    <form:errors/>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="username"><spring:message code="username"/></form:label>
                                <form:input path="username" cssClass="form-control" required="required"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="password"><spring:message code="password"/></form:label>
                                <form:input path="password" cssClass="form-control" type="password" required="required"/>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-primary mx-auto d-block mt-md-3">Se connecter</button>
                </form:form>
            </div>
        </div>
    </body>
</html>
