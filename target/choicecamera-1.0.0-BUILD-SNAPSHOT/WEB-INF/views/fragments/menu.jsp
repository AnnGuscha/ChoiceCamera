<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index"><spring:message code="label.listcameras"/></a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-expanded="false"><spring:message code="label.expert"/><span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/expert"><spring:message code="label.home"/></a></li>
                        <li><a href="/expert/marks"><spring:message code="label.evalcrit"/></a></li>
                        <li><a href="/expert/marks/manuf"><spring:message code="label.evalmanuf"/></a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout"><spring:message code="label.logout"/></a></li>
            </ul>
        </div>
    </div>
</nav>