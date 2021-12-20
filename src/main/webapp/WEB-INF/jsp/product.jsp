<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="product" /></title>
    </head>
    <body>
        Label ${label}
        Prix ${product.getPrice()}

        <form:form
                id="addToShoppingCartForm"
                method="post"
                action="/sportProducts/product/${product.getId()}/send">

            <button><spring:message code="addToShoppingCart" /></button>
        </form:form>
    </body>
</html>
