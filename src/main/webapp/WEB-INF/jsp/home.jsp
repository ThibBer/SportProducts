<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="home"/></title>
    </head>
    <body>
    <div class="container">
        <div class="row mt-md-3">
            <div class="col">
                <h1><spring:message code="welcomeHome"/></h1>
            </div>
        </div>

        <div class="row mt-md-3 mb-5">
            <div class="col">
                <h2 class="mt-2"><spring:message code="randomCategories"/></h2>
                <div id="categories" class="d-flex row justify-content-center">
                    <c:forEach items="${categories}" var="category">
                        <div class="col-md-3 col-1">
                            <a class="category" href="<spring:url value='/category/${category.getId()}'/>">
                                <div class="card m-3 category-card">
                                    <c:if test="${category.isInPromotion()}">
                                        <p class="category-promotion bg-default">-${category.getPromotion().getPercentage()}%</p>
                                    </c:if>

                                    <c:if test="${category.getImage() != null}">
                                        <img class="card-img-top img-responsive" src="<spring:url value='/assets/categories/${category.getImage()}'/>" alt="Card image cap" width="150">
                                    </c:if>

                                    <c:if test="${category.getImage() == null}">
                                        <img class="card-img-top img-responsive" src="https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-image_large.png" alt="Card image cap" width="150">
                                    </c:if>

                                    <div class="card-body text-center py-3 category-card-bottom">
                                        <h5 class="card-title m-0"><c:out value="${category.getLabel()}"/></h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>

                <h2 class="mt-5"><spring:message code="randomProducts"/></h2>
                <div id="products" class="d-flex row justify-content-center">
                    <c:forEach items="${products}" var="product">
                        <div class="col-md-3 col-1">
                            <a class="" href="<spring:url value='/product/${product.getId()}/'/>">
                                <div class="card m-3 category-card">
                                    <c:if test="${product.getImage() != null}">
                                        <img class="card-img-top img-responsive" src="<spring:url value='/assets/products/${product.getImage()}'/>" alt="Card image cap" width="150" />
                                    </c:if>

                                    <c:if test="${product.getImage() == null}">
                                        <img class="card-img-top img-responsive" src="https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-image_large.png" alt="Card image cap" width="150">
                                    </c:if>

                                    <div class="card-body text-center py-3 category-card-bottom">
                                        <h5 class="card-title m-0"><c:out value="${product.getTranslation().getLabel()}"/></h5>
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