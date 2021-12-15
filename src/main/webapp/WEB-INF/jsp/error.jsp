<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
        <title><spring:message code="error" /></title>
    </head>
    <body>
        <h1><spring:message code="errorHasOccured" /></h1>
        Message ${error}
    </body>
</html>
