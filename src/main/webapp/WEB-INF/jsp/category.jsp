<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="category"/> ${category.getLabel()}</title>
    </head>
    <body>

        <div class="container">
            <div class="row mt-md-3">
                <div class="col">
                    <h3><spring:message code="category"/> ${category.getLabel()}</h3>
                    <p>${category.getDescription()}</p>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div id="categories" class="d-flex row justify-content-center">
                        <c:forEach items="${products}" var="product">
                            <div class="col-md-3">
                                <a class="category" href="<spring:url value='/product/${product.getId()}/'/>">
                                    <div class="card m-3 category-card">
                                        <img class="card-img-top img-responsive" src="https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-image_large.png" alt="Card image cap" width="150">


                                        <div class="card-body text-center py-3 category-card-bottom">
                                            <h5 class="card-title m-0"><c:out value="${product.getPrice()}"/> €</h5>
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