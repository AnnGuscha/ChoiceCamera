<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp"/>
<script type="text/javascript">
    $(document).ready(function () {
        var table = $('#myDataTable').dataTable({
            "bServerSide": true,
            "language": {"url": "/resources/datatable/lang/dataTables.${pageContext.response.locale}"},
            "sAjaxSource": "all",
            "bProcessing": true,
            "bRetrieve": true,
            "searching": true,
            "columnDefs": [
                {
                    "render": function (data, type, row) {
                        return ' <a  data = \"' + data + "\" href=\"/cameras/update/" + data + '\" > <img src="/resources/images/pen-20.png"/></a> |' +
                                //'<a href=\"Details/' + data + '\">Details</a> |' +
                                ' <a href=\"/cameras/delete/' + data + '\"><img src="/resources/images/delete-20.png"/></a> ';
                    },
                    "width": "120px",
                    "targets": 0
                },
                {
                    "render": function (data, type, row) {
                        return data + ' - ' + row.apertureMax;
                    },
                    "targets": 5
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
            window.location.href = "/cameras/" + href;

        });
    });

</script>
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

    <h2><spring:message code="label.cameras"/>
        <a href="/best" class="btn btn-success pull-right"><spring:message code="label.bestmodel"/></a>
    </h2>
    <p>
        <a href="/cameras/add"><spring:message code="label.addcamera"/></a>

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
</div>
</body>
</html>