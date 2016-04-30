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

    <spring:url value="/expert" var="markActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="expertForm" action="${markActionUrl}">

        <fieldset>
            <legend>
                    <spring:message code="label.addmark"/>
            </legend>

            <form:hidden path="id"/>

            <div class="row">
                <label class="col-sm-2"><spring:message code="label.name"/></label>
                <div class="col-sm-10">${expert.name}</div>
            </div>

            <spring:bind path="markPrice">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">
                        <spring:message code="label.price"/>
                    </label>
                    <div class="col-sm-5">
                        <form:select path="price">
                            <form:option value="NONE" label="--- Select ---" />
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="price" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="markDate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.releasedate"/></label>
                    <div class="col-sm-5">
                        <form:select path="releaseDate">
                            <form:option value="NONE" label="--- Select ---" />
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="releaseDate" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="markManufacturer">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.manufacturer"/></label>
                    <div class="col-sm-5">
                        <form:select path="manufacturer">
                            <form:option value="NONE" label="--- Select ---" />
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="manufacturer" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="markAperture">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.aperture"/></label>
                    <div class="col-sm-5">
                        <form:select path="aperture">
                            <form:option value="NONE" label="--- Select ---" />
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="aperture" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="markMatrixDot">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label"><spring:message code="label.matrixdot"/></label>
                    <div class="col-sm-5">
                        <form:select path="matrixDot">
                            <form:option value="NONE" label="--- Select ---" />
                            <form:options items="${listMarks}" />
                        </form:select>
                        <form:errors path="matrixDot" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-5">
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