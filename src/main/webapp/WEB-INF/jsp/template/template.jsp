<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/importTags.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>
        <link rel="stylesheet" href="<spring:url value='/css/bootstrap/v4.4.1/bootstrap.min.css'/>" />
        <link rel="stylesheet" href="<spring:url value='css/fontawesome/v6.0.0_beta/css/all.css'/>" />
    </head>
    <body>
        <header class="container-fluid bg-dark">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-dark">
                    <a class="navbar-brand" href="#">LOGO</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Accueil</a>
                            </li>
                        </ul>
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Se connecter</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Mon profile</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"><i class="fa-solid fa-basket-shopping"></i> Panier</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>

        <div class="container">
            <tiles:insertAttribute name="main-content"/>
        </div>

        <footer>

        </footer>
    </body>
</html>
