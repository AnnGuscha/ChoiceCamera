<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragments/header.jsp"/>
<body>
<jsp:include page="../fragments/menu.jsp"/>
<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1><spring:message code="label.detailscamera"/></h1>
    <br/>

    <%--<div class="row">--%>
    <%--<label class="col-sm-2">ID</label>--%>
    <%--<div class="col-sm-10">${camera.id}</div>--%>
    <%--</div>--%>

    <div class="row">
        <label class="col-sm-2"><spring:message code="label.name"/></label>
        <div class="col-sm-10">${camera.name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="label.price"/></label>
        <div class="col-sm-10">${camera.price}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="label.releasedate"/></label>
        <div class="col-sm-10">${camera.releaseDate}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="label.manufacturer"/></label>
        <div class="col-sm-10">${camera.manufacturer}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="label.aperture"/></label>
        <div class="col-sm-10">${camera.apertureMin} - ${camera.apertureMax}</div>
    </div>

    <div class="row">
        <label class="col-sm-2"><spring:message code="label.matrixdot"/></label>
        <div class="col-sm-10">${camera.matrixDot}</div>
    </div>

</div>

</body>
</html>