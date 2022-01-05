<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
        <title>Paypal</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <h3><spring:message code="youWillBeRedirected" /></h3>
                    <form id="payment-form" action="https://www.sandbox.paypal.com/cgi-bin/webscr" class="text-center" method="GET">
                        <input type="hidden" name="business" value="42888business@business.be">
                        <input type="hidden" name="cmd" value="_cart">
                        <input type="hidden" name="upload" value="1">

                        <c:forEach items="${shoppingCartItems}" var="product" varStatus="loop">
                            <input type="hidden" name="item_name_<c:out value="${loop.count}" />" value="${product.key.getTranslation().getLabel()}">
                            <input type="hidden" name="quantity_<c:out value="${loop.count}" />" value="${product.value}">
                            <input type="hidden" name="amount_<c:out value="${loop.count}" />" value="${product.key.getPriceWithPromotion()}">
                        </c:forEach>

                        <input type="hidden" name="brand_name" value="SportProducts">
                        <input type="hidden" name="currency_code" value="EUR">
                        <input type="hidden" name="lc" value="${locale.getLanguage()}-${locale.getCountry()}">
                        <input type="hidden" name="return" value="http://127.0.0.1:8082/sportProducts/payments/paymentsuccess">
                        <input type="hidden" name="cancel_url" value="http://127.0.0.1:8082/sportProducts/payments/paymentcancelled">
                    </form>

                </div>
            </div>
        </div>

        <script type="text/javascript">
            document.getElementById("payment-form").submit();
        </script>
    </body>
</html>
