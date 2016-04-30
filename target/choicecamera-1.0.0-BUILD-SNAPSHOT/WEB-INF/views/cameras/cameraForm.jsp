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

    <spring:url value="/camera" var="cameraActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="cameraForm" action="${cameraActionUrl}">

        <fieldset>
            <legend>
                <c:choose>
                    <c:when test="${isNew==true}">
                        <h1><spring:message code="label.addcamera"/></h1>
                    </c:when>
                    <c:otherwise>
                        <h1><spring:message code="label.updatecamera"/></h1>
                    </c:otherwise>
                </c:choose>
            </legend>

            <form:hidden path="id"/>

            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.name"/></label>
                    <div class="col-sm-5">
                        <form:input path="name" type="text" class="form-control " id="name" placeholder="Name"/>
                        <form:errors path="name" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="price">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.price"/></label>
                    <div class="col-sm-5">
                        <form:input path="price" type="text" class="form-control " id="price" placeholder="Price"/>
                        <form:errors path="price" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="releaseDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.releasedate"/></label>
                    <div class="col-sm-5">
                        <form:input path="releaseDate" type="text" class="form-control " id="releaseDate"
                                    placeholder="ReleaseDate"/>
                        <form:errors path="releaseDate" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="manufacturer">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.manufacturer"/></label>
                    <div class="col-sm-5">
                        <form:select path="manufacturer" class="form-control">
                            <form:option value="NONE" label="--- Select ---"/>
                            <form:options items="${manufacturerList}"/>
                        </form:select>
                        <form:errors path="manufacturer" class="control-label"/>
                    </div>
                    <div class="col-sm-5"></div>
                </div>
            </spring:bind>

            <spring:bind path="apertureMin">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.aperture"/></label>
                    <div class="col-sm-5">
                        <form:input path="apertureMin" type="text" class="form-control " id="apertureMin"
                                    placeholder="ApertureMin"/>
                        <form:errors path="apertureMin" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="apertureMax">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.aperture"/></label>
                    <div class="col-sm-5">
                        <form:input path="apertureMax" type="text" class="form-control " id="apertureMax"
                                    placeholder="ApertureMax"/>
                        <form:errors path="apertureMax" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="matrixDot">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.matrixdot"/></label>
                    <div class="col-sm-5">
                        <form:input path="matrixDot" type="text" class="form-control " id="matrixDot"
                                    placeholder="MatrixDot"/>
                        <form:errors path="matrixDot" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-5">
                    <c:choose>
                        <c:when test="${isNew==true}">
                            <button type="submit" class="btn-lg btn-primary pull-right"><spring:message
                                    code="label.add"/></button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn-lg btn-primary pull-right"><spring:message
                                    code="label.update"/></button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </fieldset>
    </form:form>

</div>
</body>
</html>