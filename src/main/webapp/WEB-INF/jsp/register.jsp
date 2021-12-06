<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
        <title><spring:message code="register"/></title>
        <meta charset="UTF-8">
    </head>
    <body>
        <div class="row justify-content-center">
            <div class="d-flex flex-column justify-content-center w-50">
                <div class="text-center pt-2">
                    <h2><spring:message code="register"/></h2>
                </div>
                <form:form method="post" modelAttribute="user">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="firstname"><spring:message code="firstName"/></form:label>
                                <form:input path="firstname" cssClass="form-control"/>
<%--                                <label><spring:message code="firstName"/></label>
                                <input class="form-control" type="text" id="first_name" name="first_name" placeholder="<spring:message code="firstName"/>"/>--%>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="lastname"><spring:message code="lastName"/></form:label>
                                <form:input path="lastname" cssClass="form-control"/>
<%--                                <label><spring:message code="lastName"/></label>
                                <input class="form-control" type="text" id="last_name" name="last_name" placeholder="<spring:message code="lastName"/>"/>--%>
                            </div>
                        </div>
                    </div>

                    <div class="form-group mt-md-3">
                        <form:label path="email"><spring:message code="email"/></form:label>
                        <form:input path="email" cssClass="form-control"/>
<%--                        <label><spring:message code="email"/></label>
                        <input class="form-control" type="email" placeholder="<spring:message code="email"/>"/>--%>
                    </div>

                    <div class="form-group mt-md-3">
                        <form:label path="password"><spring:message code="password"/></form:label>
                        <form:input path="password" cssClass="form-control" type="password"/>
<%--                        <label><spring:message code="password"/></label>
                        <input class="form-control" type="password" placeholder="<spring:message code="password"/>"/>--%>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="birthDate"><spring:message code="birthDate"/></form:label>
                                <form:input path="birthDate" cssClass="form-control" type="date"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
<%--                                <label><spring:message code="phoneNumber"/></label>
                                <input class="form-control" type="text" id="last_name" name="last_name" placeholder="<spring:message code="phoneNumber"/>"/>--%>
                            </div>
                        </div>
                    </div>

                    <button class="btn text-white mx-auto d-block border-white mt-md-3">Se connecter</button>
                </form:form>
            </div>
        </div>
    </body>
</html>
