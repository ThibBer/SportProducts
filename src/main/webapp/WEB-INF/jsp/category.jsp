<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="category" /></title>
    </head>
    <body>
        Category ${category.getLabel()}
        <br/>
        ${category.getDescription()}
        <br/>
        <c:forEach items="${products}" var="product">
            Prix ${product.getPrice()}  Categorie ${product.getCategory().getId()}
            <br />
        </c:forEach>
    </body>
</html>