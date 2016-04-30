<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title" /></title>
</head>
<body>

<a href="<c:url value="/logout" />">
    <spring:message code="label.logout" />
</a>

<h2><spring:message code="label.title" /></h2>

<form:form method="post" action="add" commandName="camera">

    <table>
        <tr>
            <td><form:label path="name">
                <spring:message code="label.name" />
            </form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="price">
                <spring:message code="label.price" />
            </form:label></td>
            <td><form:input path="price" /></td>
        </tr>
        <tr>
            <td><form:label path="manufacturer">
                <spring:message code="label.manufacturer" />
            </form:label></td>
            <td><form:input path="manufacturer" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.addcamera"/>" /></td>
        </tr>
    </table>
</form:form>

<h3><spring:message code="label.cameras" /></h3>
<c:if test="${!empty cameraList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.name" /></th>
            <th><spring:message code="label.price" /></th>
            <th><spring:message code="label.manufacturer" /></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${cameraList}" var="camera">
            <tr>
                <td>${camera.name}</td>
                <td>${camera.price}</td>
                <td>${camera.manufacturer}</td>
                <td><a href="delete/${camera.id}"><spring:message code="label.delete" /></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
<body>

</body>
</html>
