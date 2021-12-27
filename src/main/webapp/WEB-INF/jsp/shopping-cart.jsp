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

                                    <form action="https://www.sandbox.paypal.com/cgi bin/webscr">

                                        <input type="hidden" name="business" value="42888business@business.be">
                                        <input type="hidden" name="password" value="ELP3xkoFodSVW2DSyzZGiw1_Xf0h-x3KZo6IRpGGcKzn6RghXhzfF83hh4wwfjw89r--mOsROP6SOpuE">
                                        <input type="hidden" name="cert_id" value="AQFmAgERQt6ouoZ78-GfCsBapnDwBOrb5_J9MHx9FRv40obAcYQOb-mIuRscuuc3szTcHyXC2uOB62tN">
                                        <input type="hidden" name="cmd" value="_xclick">
                                        <input type="hidden" name="amount" value="${total}">
                                        <input type="hidden" name="currency_code" value="EUR">
                                        <input type="hidden" name="lc" value="${locale.getLanguage()}">
                                        <input type="hidden" name="return" value="http://127.0.0.1:8082/sportProducts">
                                        <input type="image" name="submit"
                                               src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
                                               alt="PayPal - The safer, easier way to pay online">

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>
