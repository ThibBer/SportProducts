<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
        <title><spring:message code="register"/></title>
        <meta charset="UTF-8">
    </head>
    <body>
        <div class="row justify-content-center w-100 mb-5">
            <div class="d-flex flex-column justify-content-center w-50">
                <div class="text-center pt-2">
                    <h2><spring:message code="register"/></h2>
                </div>
                <form:form
                        id="inscription"
                        method="post"
                        action="/sportProducts/register/"
                        modelAttribute="userForm">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="firstname"><spring:message code="firstName"/></form:label>
                                <form:input path="firstname" cssClass="form-control"/>
                                <div class="error"><form:errors path="firstname" /></div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="lastname"><spring:message code="lastName"/></form:label>
                                <form:input path="lastname" cssClass="form-control"/>
                                <div class="error"><form:errors path="lastname" /></div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group mt-md-3">
                        <form:label path="email"><spring:message code="email"/></form:label>
                        <form:input path="email" cssClass="form-control"/>
                        <c:if test="${messageEmail == 'already used'}">
                            <div class="error"><spring:message code="emailAlreadyUsed" /></div>
                        </c:if>
                        <div class="error"><form:errors path="email" /></div>
                    </div>

                    <div class="form-group mt-md-3">
                        <form:label path="username"><spring:message code="username"/></form:label>
                        <form:input path="username" cssClass="form-control"/>
                        <c:if test="${messageUsername == 'already used'}">
                            <div class="error"><spring:message code="usernameAlreadyUsed" /></div>
                        </c:if>
                        <div class="error"><form:errors path="username" /></div>
                    </div>

                    <div class="form-group mt-md-3">
                        <form:label path="password"><spring:message code="password"/></form:label>
                        <form:input path="password" cssClass="form-control" type="password"/>
                        <c:if test="${messageConfirmPassword == 'not the same'}">
                            <div class="error"><spring:message code="confirmPasswordNotTheSame" /></div>
                        </c:if>
                        <div class="error"><form:errors path="password" /></div>
                    </div>

                    <div class="form-group mt-md-3">
                        <form:label path="confirmPassword"><spring:message code="confirmPassword"/></form:label>
                        <form:input path="confirmPassword" cssClass="form-control" type="password"/>
                        <div class="error"><form:errors path="confirmPassword" /></div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="birthDate"><spring:message code="birthDate"/></form:label>
                                <form:input path="birthDate" cssClass="form-control" type="date" name="birthDate"/>
                                <div class="error"><form:errors path="birthDate" /></div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="phoneNumber"><spring:message code="phoneNumber"/></form:label>
                                <form:input path="phoneNumber" cssClass="form-control"/>
                                <div class="error"><form:errors path="phoneNumber" /></div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="city"><spring:message code="city"/></form:label>
                                <form:input path="city" cssClass="form-control"/>
                                <div class="error"><form:errors path="city" /></div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="postalCode"><spring:message code="postalCode"/></form:label>
                                <form:input path="postalCode" cssClass="form-control"/>
                                <div class="error"><form:errors path="postalCode" /></div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="street"><spring:message code="street"/></form:label>
                                <form:input path="street" cssClass="form-control"/>
                                <div class="error"><form:errors path="street" /></div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form:label path="houseNumber"><spring:message code="houseNumber"/></form:label>
                                <form:input path="houseNumber" cssClass="form-control"/>
                                <div class="error"><form:errors path="houseNumber" /></div>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-primary" type="submit"><spring:message code="register" /></button>
                </form:form>
            </div>
        </div>
    </body>
</html>
