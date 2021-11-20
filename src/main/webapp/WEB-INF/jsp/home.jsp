<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
        <title><spring:message code="home"/></title>
    </head>
    <body>
        <div class="d-flex row justify-content-center">
            <div class="col-md-3">
                <div class="card m-3 product-card">
                    <img class="card-img-top img-responsive" src="https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-image_large.png" alt="Card image cap" width="150">

                    <hr/>

                    <div class="card-body pt-0 pl-2">
                        <h5 class="card-title">Titre article</h5>
                        <p class="card-text">Prix</p>
                    </div>
                    <div class="card-footer p-2">
                        <div class="input-group">
                            <div class="input-group-prepend mx-md-2">
                                <button class="btn btn-danger"><i class="fa-solid fa-basket-shopping"></i> Ajouter</button>
                            </div>
                            <input type="number" class="form-control" min="0" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex row justify-content-center">
            <c:forEach items="${categories}" var="category">
                <div class="col-md-3">
                    <div class="card m-3 product-card">
                        <div class="card-body pt-0 pl-2">
                            <h5 class="card-title">Catégorie : <c:out value="${category.getLabel()}" /></h5>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
