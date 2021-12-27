<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
    <head>
        <title><spring:message code="shoppingCart" /></title>
    </head>
    <body>
        <div class="container-fluid">
            <c:if test="${shoppingCartItems.size() == 0}">
                <div class="row">
                    <div class="col text-center">
                        <h3 class="mt-2">Votre panier est malheureusement vide 😞</h3>
                    </div>
                </div>
            </c:if>

            <c:if test="${shoppingCartItems.size() > 0}">
                <div class="row mt-5">
                    <div class="col-md-8 offset-md-1 mr-5">
                        <c:if test="${shoppingCartItems.size() > 0}">
                            <c:forEach items="${shoppingCartItems}" var="product">
                                <div class="row my-3 pb-3 border-bottom">
                                    <div class="col-md-3 text-center">
                                        <c:if test="${product.key.getImage() != null}">
                                            <img class="img-responsive" src="<spring:url value='/assets/products/${product.key.getImage()}'/>" alt="Card image cap" width="150">
                                        </c:if>

                                        <c:if test="${product.key.getImage() == null}">
                                            <img class="img-responsive" src="https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-image_large.png" alt="Card image cap" width="150">
                                        </c:if>
                                    </div>
                                    <div class="col-md-6">
                                        <h3><c:out value="${product.key.getTranslation().getLabel()}"/></h3>
                                        <p><c:out value="${product.key.getDescription()}"/></p>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <form:form method="POST" action="/sportProducts/shopping-cart/editQuantity" modelAttribute="shoppingCartItem">
                                                    <div class="input-group mb-3">
                                                        <input name="quantity" type="number" class="form-control" placeholder='<spring:message code="quantity"/>' min="0" value="${product.value}" required/>
                                                        <form:hidden path="productId" value="${product.key.getId()}"/>
                                                        <div class="input-group-append">
                                                            <button class="btn btn-primary" type="submit">
                                                                <i class="fal fa-cart-plus"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form:form>
                                            </div>
                                            <div class="col-md-4">
                                                <form:form method="POST" action="/sportProducts/shopping-cart/delete" modelAttribute="shoppingCartItem">
                                                    <form:hidden path="productId" value="${product.key.getId()}"/>
                                                    <button class="btn btn-danger" type="submit">
                                                        <i class="fal fa-trash-alt"></i>
                                                    </button>
                                                </form:form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <p>Prix Unitaire</p>

                                                <div class="row">
                                                    <c:if test="${product.key.category.isInPromotion()}">
                                                        <div class="text-right mt-md-3">
                                                            <p class="m-0"><span class="old-price"><c:out value="${product.key.getPrice()}"/></span> <sup class="new-price"><c:out value="${product.key.getPriceWithPromotion()}"/> €</sup></p>
                                                        </div>
                                                    </c:if>

                                                    <c:if test="${!product.key.category.isInPromotion()}">
                                                        <div class="text-right mt-md-3">
                                                            <p class="m-0"><c:out value="${product.key.getPrice()}"/> €</p>
                                                        </div>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Prix total</p>

                                                <div class="row">
                                                    <div class="text-right mt-md-3">
                                                        <p class="m-0"><c:out value="${product.key.getPriceWithPromotion() * product.value}"/> €</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="col-md-2">
                        <div class="card mt-md-5">
                            <h5 class="card-header"><spring:message code="shoppingCartSummary" arguments="${shoppingCartItemsCount}"/></h5>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col">

                                        <c:if test="${articlesInPromotion == 1}">
                                            <small>Votre panier contient <c:out value="${articlesInPromotion}"/> article en promotion</small>
                                        </c:if>

                                        <c:if test="${articlesInPromotion > 1}">
                                            <small>Votre panier contient <c:out value="${articlesInPromotion}"/> articles en promotion</small>
                                        </c:if>
                                    </div>
                                </div>

                                <div class="row mt-md-3">
                                    <div class="col text-center">
                                        <h5><spring:message code="totalToPay" arguments="${total}"/></h5>
                                    </div>
                                </div>

                                <div class="row text-center mt-md-3">
                                    <div class="col">
                                        <a href="#" class="btn btn-primary"><spring:message code="order"/></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>
