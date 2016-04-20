<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <%--<link rel='stylesheet' href="/ext/bootstrap/css/bootstrap-theme.min.css">--%>
    <link rel='stylesheet' href="/resources/css/jquery.dataTables.min.css">
    <link rel='stylesheet' href="/ext/bootstrap/css/bootstrap.css">
    <script type='text/javascript' src="/ext/jquery/js/jquery.js"></script>
    <script type='text/javascript' src="/ext/bootstrap/js/bootstrap.js"></script>
    <script type='text/javascript' src="/resources/js/jquery.dataTables.min.js"></script>
</head>


<script type="text/javascript">
    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
//            "language": {"url": "/resources/datatable/lang/dataTables.en_US"},
            "sAjaxSource": "camera",
            "bProcessing": true,
            "bRetrieve": true,
            "searching": true,
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        return ' <a  data = \"' + data + "\" href=\"/admin/course/edit/" + data + '\" > <img src="/content/images/pen-20.png"/></a> |' +
                                //'<a href=\"Details/' + data + '\">Details</a> |' +
                                ' <a href=\"/admin/course/delete/' + data + '\"><img src="/content/images/delete-20.png"/></a> ';
                    },
                    "width": "120px",
                    "targets": 0
                },
                {
                    "render": function (data, type, row) {
                        return data + ' - ' + row.apertureMax;
                    },
                    "targets": 5a
                },
                {
                    "visible": false,
                    "targets": 6
                }
            ],
            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "price"},
                {"data": "releaseDate"},
                {"data": "manufacturer"},
                {"data": "apertureMin"},
                {"data": "apertureMax"},
                {"data": "matrixDot"}
            ]
        });

        $('#myDataTable tbody').on('click', 'tr', function () {

            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
            var href = $('a:contains(" ")', this).attr('data');
            window.location.href = "course/details/" + href;

        });
    });

</script>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="">
                <spring:message code="label.home"/>
            </a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" role="navigation">
                <li><a href="/admin/student" class="navbar-brand"></a></li>
                <li><a href="/admin/professor" class="navbar-brand"></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/profile" class="navbar-brand">
                        <spring:message code="label.hi"/>
                    </a>
                </li>
                <li>
                    <a href="/logout">
                        <spring:message code="label.logout"/>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="demo">
    <h2><spring:message code="label.cameras"/></h2>
    <p>
        <a href="/admin/course/create"><spring:message code="label.addcamera"/></a>
    </p>
    <table id="myDataTable" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th></th>
            <th><spring:message code="label.name"/></th>
            <th><spring:message code="label.price"/></th>
            <th><spring:message code="label.date"/></th>
            <th><spring:message code="label.manufacturer"/></th>
            <th><spring:message code="label.aperture"/></th>
            <th></th>
            <th><spring:message code="label.matrixdot"/></th>
        </tr>
        </thead>

    </table>
    <button class="btn" type="button">Go</button>
</div>
</body>
</html>