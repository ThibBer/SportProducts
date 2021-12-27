<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="shoppingCart" /></title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <c:if test="${shoppingCartItems.size() == 0}">
                    <div class="col text-center">
                        <h3 class="mt-2">Votre panier est malheureusement vide 😞</h3>
                    </div>
                </c:if>

                <c:if test="${shoppingCartItems.size() > 0}">
                    <c:forEach items="${shoppingCartItems}" var="product">
                        <c:out value="${product.key.toString()}" />
                        <c:out value="${product.value}" />
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </body>
</html>
