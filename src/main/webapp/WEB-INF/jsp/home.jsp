<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="home"/></title>

    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <div id="categories" class="d-flex row justify-content-center">
                        <c:forEach items="${categories}" var="category">
                            <div class="col-md-3">
                                <a href="<spring:url value='/category/${category.getId()}/'/>">
                                    <div class="card m-3 category-card">
                                        <img class="card-img-top img-responsive" src="https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-image_large.png" alt="Card image cap" width="150">

                                        <div class="card-body text-center py-3 category-card-bottom">
                                            <h5 class="card-title m-0"><c:out value="${category.getLabel()}"/></h5>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>