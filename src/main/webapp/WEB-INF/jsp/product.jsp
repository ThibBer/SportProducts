<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="product" /></title>
    </head>
    <body>
        Label ${label}
        Prix ${product.getPrice()}
    </body>
</html>
