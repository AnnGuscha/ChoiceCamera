<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp"/>

<body>
<jsp:include page="../fragments/menu.jsp"/>
<div id="demo">
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>
    <label><spring:message code="label.expert"/></label>
    <h3>${expert.name}</h3>
    <p>
        <a href="/expert/edit"><spring:message code="label.edit"/></a>
    </p>
    <h4><spring:message code="label.marks"/></h4>
    <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th><spring:message code="label.price"/></th>
            <th><spring:message code="label.releasedate"/></th>
            <th><spring:message code="label.manufacturer"/></th>
            <th><spring:message code="label.aperture"/></th>
            <th><spring:message code="label.matrixdot"/></th>
        </tr>
        <tr>
            <th><a href="/expert/marks"> <img src="/resources/images/pen-20.png"/></a></th>
            <th>${expert.markPrice}</th>
            <th>${expert.markDate}</th>
            <th>${expert.markManufacturer}</th>
            <th>${expert.markAperture}</th>
            <th>${expert.markMatrixDot}</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>