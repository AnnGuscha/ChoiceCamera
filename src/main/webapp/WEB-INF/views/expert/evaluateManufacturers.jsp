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

    <spring:url value="/expert/api/marks/manuf" var="markActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="manufacturers" action="${markActionUrl}">

        <legend>
            <spring:message code="label.addmarks"/>
        </legend>

        <%--<form:hidden path="${expert.id}"/>--%>
        <c:forEach items="${manufacturers}" var="manufacturer">
            <div class="row">
                <label class="col-sm-2 control-label">
                        ${manufacturer.key.getString()}
                </label>
                <div class="col-sm-5">
                    <form:select path="value">
                        <form:option value="0" label="--- Select ---"/>
                        <form:options items="${listMarks}"/>
                    </form:select>
                </div>
            </div>
        </c:forEach>


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