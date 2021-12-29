<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="category"/> ${category.getLabel()}</title>
    </head>
    <body>
        <c:if test="${category.isInPromotion()}">
            <header class="container-fluid bg-promotion-alert mx-0">
                <div class="container text-center">
                    <p id="promotion-alert" class="text-white py-md-2"><spring:message code="categoryInPromotion" arguments="${category.getPromotion().getPercentage()}, ${category.getLabel().toLowerCase()}"/> <span class="promotion-date">${category.getPromotion().getFormattedEndDate()}</span></p>
                    <%--<p id="promotion-alert" class="text-white py-md-2">Une réduction de ${category.getPromotion().getPercentage()}% est appliquée à tous les articles de ${category.getLabel().toLowerCase()} pour tout achat avant le <span class="promotion-date">${category.getPromotion().getFormattedEndDate()}</span></p>--%>
                </div>
            </header>
        </c:if>

        <div class="container">
            <div class="row mt-md-3">
                <div class="col">
                    <h3><spring:message code="category"/> ${category.getLabel()}</h3>
                    <p>${category.getDescription()}</p>
                </div>
            </div>
            <div class="row mb-5">
                <div class="col">
                    <div id="products" class="d-flex row justify-content-center">
                        <c:forEach items="${products}" var="product">
                            <div class="col-md-3">
                                <a class="product" href="<spring:url value='/product/${product.getId()}/'/>">
                                    <div class="card m-3 category-card" >

                                        <c:if test="${product.getImage() != null}">
                                            <img class="card-img-top img-responsive" src="<spring:url value='/assets/products/${product.getImage()}'/>" alt="Card image cap" width="150">
                                        </c:if>

                                        <c:if test="${product.getImage() == null}">
                                            <img class="card-img-top img-responsive" src="https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-image_large.png" alt="Card image cap" width="150">
                                        </c:if>

                                        <div class="card-body py-3">
                                            <h5 class="m-0"><c:out value="${product.getTranslation().getLabel()}"/></h5>
                                            <hr/>
                                            <p class="m-0"><c:out value="${product.getDescription()}"/></p>


                                            <c:if test="${category.isInPromotion()}">
                                                <div class="text-right mt-md-3">
                                                    <h5 class="m-0"><span class="old-price"><c:out value="${product.getPrice()}"/></span> <sup class="new-price"><c:out value="${product.getPriceWithPromotion()}"/> €</sup></h5>
                                                </div>
                                            </c:if>

                                            <c:if test="${!category.isInPromotion()}">
                                                <div class="text-right mt-md-3">
                                                    <h5 class="m-0"><c:out value="${product.getPrice()}"/> €</h5>
                                                </div>
                                            </c:if>
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