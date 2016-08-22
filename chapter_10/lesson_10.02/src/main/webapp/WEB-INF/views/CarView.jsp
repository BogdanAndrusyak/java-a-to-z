<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>View</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
    <link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"/>" rel="stylesheet" id="bootstrap-css">

    <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        function showChangeStatusModal(id) {
            document.getElementById("car-id").value = id;
            $("#modal-button").click();
        }
    </script>
</head>
<body>
    <div class="center-block-main">

        <!-- Modal -->
        <div class="container">
            <button style="display: none;" id="modal-button" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <form action="${pageContext.servletContext.contextPath}/changestatus" method="post">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Change car status:</h4>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" id="car-id" name="car-id" value="1">
                                <select class="form-control" name="sold">
                                    <option value="true">Sold</option>
                                    <option value="false" selected>Not sold</option>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-default">Change</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <%-- /Modal --%>


        <div class="text-right">
            <a href="${pageContext.servletContext.contextPath}/addcar" class="btn btn-info" role="button">Add your car</a>
        </div>
        <h1>Cars: </h1>
        <table>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td>
                        <img src="data:image/jpg;base64,${car.getByteArrayString()}" width="200px">
                    </td>
                    <td>
                        <span class="my-ads-header">${car.brand} ${car.model}, ${car.year}<c:if test="${car.sold == true}"> <span class="sold">sold</span></c:if><c:if test="${car.owner.id == sessionScope.user.id}"> <span class="change-status-container"><span class="change-status">-</span> <a onclick="showChangeStatusModal(${car.id})" class="change-status">change status</a></span></c:if></span><br>
                        <span class="my-ads-content">${car.price} $</span><br>
                        <span class="my-ads-desc">${car.desc}</span>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
