<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="product"/> ${product.getTranslation().getLabel().toLowerCase()}</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="card mt-5">
                        <h5 class="card-header bg-default text-white">
                            <div class="row">
                                <div class="col-md-6">
                                    ${product.getTranslation().getLabel()}
                                </div>
                                <div class="col-md-6 text-right">
                                    <c:if test="${category.isInPromotion()}">
                                        <h5>- ${category.getPromotion().getPercentage()} %&nbsp;&nbsp;<i class="far fa-tags"></i></h5>
                                    </c:if>
                                </div>
                            </div>
                        </h5>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <c:if test="${product.getImage() != null}">
                                        <img class="card-img-top img-responsive" src="<spring:url value='/assets/products/${category.getImage()}'/>" alt="Card image cap" width="150">
                                    </c:if>

                                    <c:if test="${product.getImage() == null}">
                                        <img class="card-img-top img-responsive" src="https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-image_large.png" alt="Card image cap" width="150">
                                    </c:if>
                                </div>
                                <div class="col-md-6">
                                    <p>${product.getDescription()}}</p>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <form:form id="addToShoppingCartForm" method="post" action="/sportProducts/product/send" modelAttribute="shoppingCartItem">
                                                <div class="input-group mb-3">
                                                    <spring:message code="quantity" var="quantityLabel"/>

                                                    <form:hidden path="productId" value="${product.getId()}" />
                                                    <%--<form:input path="age" cssClass="form-control" placeholder="${quantityLabel}" />--%>

                                                    <input name="quantity" type="number" class="form-control" placeholder='<spring:message code="quantity"/>' min="1" required/>
                                                    <div class="input-group-append">
                                                        <button class="btn btn-primary" type="submit">
                                                            <i class="fal fa-cart-plus"></i>
                                                        </button>
                                                    </div>
                                                </div>

                                                <form:errors path="*"/>
                                            </form:form>
                                        </div>
                                        <div class="col-md-6">
                                            <c:if test="${category.isInPromotion()}">
                                                <div class="text-right mt-md-3">
                                                    <h5 class="m-0"><span class="old-price"><c:out value="${product.getPrice()}"/></span> <sup class="new-price"><c:out value="${product.getPriceWithPromotion(category.getPromotion())}"/> €</sup></h5>
                                                </div>
                                            </c:if>

                                            <c:if test="${!category.isInPromotion()}">
                                                <div class="text-right mt-md-3">
                                                    <h5 class="m-0"><c:out value="${product.getPrice()}"/> €</h5>
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
