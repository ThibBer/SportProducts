<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="shoppingCart" /></title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <c:forEach items="${shoppingCart}" var="entry">
                    <c:out value="${entry.key.id}" />
                </c:forEach>
            </div>
        </div>
    </body>
</html>
