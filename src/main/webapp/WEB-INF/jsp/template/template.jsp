<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/importTags.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<spring:url var="localeEN" value="">
    <spring:param name="locale" value="en-US"/>
</spring:url>

<spring:url var="localeFR" value="">
    <spring:param name="locale" value="fr-BE"/>
</spring:url>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="BERNARD Nicolas & BERG Thibaut">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="<spring:url value='/css/bootstrap/v4.4.1/bootstrap.min.css'/>" />
        <link rel="stylesheet" href="<spring:url value='/css/fontawesome/v6.0.0_beta/css/all.css'/>" />
        <link rel="stylesheet" href="<spring:url value='/css/style.css'/>" />

        <!--Font Raleway-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@200;400&display=swap" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </head>
    <body>
        <header class="container-fluid bg-default">
            <div class="container">
                <nav class="navbar navbar-expand-lg bg-default">
                    <a class="navbar-brand" href="<spring:url value='/'/>">SportProducts</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="<spring:url value='/categories'/>"><spring:message code="categories"/></a>
                            </li>
                        </ul>
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <sec:authorize access="!isAuthenticated()">
                                    <a class="nav-link" href="<spring:url value='/login'/>"><spring:message code="login"/></a>
                                </sec:authorize>

                                <sec:authorize access="isAuthenticated()">
                                    <a class="nav-link" href="<spring:url value='/logout'/>"><spring:message code="logout"/>&nbsp;&nbsp;<i class="fal fa-sign-out-alt text-light"></i></a>
                                </sec:authorize>
                            </li>
                            <li class="nav-item">
                                <sec:authorize access="!isAuthenticated()">
                                    <a class="nav-link" href="<spring:url value='/register'/>"><spring:message code="register"/></a>
                                </sec:authorize>
                            </li>
                            <li class="nav-item dropdown mr-4">
                                <button class="btn text-light dropdown-toggle" type="button" id="languageSelectorDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <img src="<spring:url value='/assets/flags/${locale.getLanguage()}.png'/>" alt="Current language" width="15"/> ${locale.getDisplayLanguage(locale)}
                                </button>
                                <div class="dropdown-menu" aria-labelledby="languageSelectorDropdown">
                                    <a class="dropdown-item" href="${localeEN}">
                                        <img src="<spring:url value='/assets/flags/en.png'/>" width="15" alt="English"/>English
                                    </a>
                                    <a class="dropdown-item" href="${localeFR}">
                                        <img src="<spring:url value='/assets/flags/fr.png'/>" width="15" alt="Fran??ais"/>Fran??ais
                                    </a>
                                </div>
                            </li>
                            <sec:authorize access="isAuthenticated()">
                                <li class="nav-item">
                                    <p class="nav-link text-light my-auto"><spring:message code="welcome"/>&nbsp;<c:out value="${pageContext.request.remoteUser}"/></p>
                                </li>
                            </sec:authorize>
                            <li class="nav-item">
                                <a class="nav-link" href="<spring:url value='/shopping-cart'/>"><i class="fal fa-shopping-cart"></i></a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>

        <tiles:insertAttribute name="main-content"/>

        <footer class="bg-default fixed-bottom d-flex justify-content-center mt-auto">
            <div class="container">
                <div class="d-flex justify-content-center">
                    <a class="nav-link" href="<spring:url value='/Bergnard'/>">Bergnard</a>
                </div>
            </div>
        </footer>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
