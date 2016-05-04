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

    <spring:url value="/expert/api/marks" var="markActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="expertForm" action="${markActionUrl}">
        <fieldset>
            <legend>
                    <spring:message code="label.addmark"/>
            </legend>

            <form:hidden path="id"/>
            <form:hidden path="user"/>
            <form:hidden path="name"/>

            <spring:bind path="markPrice">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-lg-2 control-label">
                        <spring:message code="label.price"/>
                    </label>
                    <div class="col-lg-2">
                        <form:select path="markPrice" class="form-control" id="select">
                            <form:option value="0" label="--- Select ---"/>
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="markPrice" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="markDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-lg-2 control-label"><spring:message code="label.releasedate"/></label>
                    <div class="col-lg-2">
                        <form:select path="markDate" class="form-control" id="select">
                            <form:option value="0" label="--- Select ---"/>
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="markDate" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="markManufacturer">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-lg-2 control-label"><spring:message code="label.manufacturer"/></label>
                    <div class="col-lg-2">
                        <form:select path="markManufacturer" class="form-control" id="select">
                            <form:option value="0" label="--- Select ---"/>
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="markManufacturer" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="markAperture">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-lg-2 control-label"><spring:message code="label.aperture"/></label>
                    <div class="col-lg-2">
                        <form:select path="markAperture" class="form-control" id="select">
                            <form:option value="0" label="--- Select ---"/>
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="markAperture" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="markMatrixDot">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-lg-2 control-label"><spring:message code="label.matrixdot"/></label>
                    <div class="col-lg-2">
                        <form:select path="markMatrixDot" class="form-control" id="select">
                            <form:option value="0" label="--- Select ---"/>
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="markMatrixDot" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <div class="form-group">
                <div class="col-lg-3 col-lg-offset-3">
                    <button type="submit" class="btn-lg btn-primary pull-right">
                        <spring:message code="label.edit"/>
                    </button>
                </div>
            </div>
        </fieldset>
    </form:form>

</div>
</body>
</html>