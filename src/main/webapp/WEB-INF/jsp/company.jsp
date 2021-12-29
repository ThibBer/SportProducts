<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
        <title>Bergnard</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-md-3">
                <div class="col text-center">
                    <h1>Bergnard</h1>
                </div>
            </div>
            <div class="row mt-md-3 text-center">
                <div class="col text-center">
                    <p><spring:message code="companyIntro"/></p>
                </div>
            </div>
            <div class="row mt-md text-center">
                <div class="col text-center">
                    <p><spring:message code="companyBody"/></p>
                </div>
            </div>
            <div class="row mt-md-3">
                <div class="col text-center">
                    <img class="img-thumbnail" src="<spring:url value='/assets/creators/berg_thibaut.png'/>" width="200">
                    <div class="row justify-content-center">
                        Thibaut BERG
                    </div>
                </div>
                <div class="col text-center">
                    <img class="img-thumbnail" src="<spring:url value='/assets/creators/bernard_nicolas.png'/>" width="200">
                    <div class="row justify-content-center">
                        Nicolas BERNARD
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
