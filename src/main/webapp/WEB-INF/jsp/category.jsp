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

        <div class="row">
            <div class="col-2 py-4">
                <div id="vertical-action-bar">
                    <div class="row text-center">
                        <div class="col">
                            <h4><spring:message code="products" /></h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-left">
                            <div class="bg-light">
                                <hr class="m-0 p-0"/>
                                <c:forEach items="${products}" var="product">
                                    <a class="btn w-100 my-md-2" href="<spring:url value='/product/${product.getId()}/'/>"><c:out value="${product.getId()}"/></a>
                                    <hr class="m-0 p-0"/>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>