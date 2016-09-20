<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add new car</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">

    <link href="<c:url value="/resources/css/jasny-bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" id="bootstrap-css">

    <script src="<c:url value="/resources/js/jquery-3.1.0.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

    <script src="<c:url value="/resources/js/jasny-bootstrap.min.js"/>"></script>
    <script>
        $(
                $.ajax('../json.do', {
                    method : 'get',
                    complete: function (data) {
                        var result = "<option value=''>---<option>";

                        var years = JSON.parse(data.responseText).years;
                        for (var i=years.length-1; i>=0; --i) {
                            result += "<option value='"+ years[i] +"'>"+ years[i] +"</option>";
                        }
                        document.getElementById("years").innerHTML = result;
                    }
                })
        );

        $(
                $.ajax('../json.do', {
                    method : 'get',
                    complete: function (data) {
                        var result = "<option value=''>---<option>";

                        var types = JSON.parse(data.responseText).types;
                        for (var i=0; i!=types.length; ++i) {
                            result += "<option value='"+ types[i] +"'>"+ types[i] +"</option>";
                        }
                        document.getElementById("types").innerHTML = result;
                    }
                })
        );

        $(
                $.ajax('../json.do', {
                    method : 'get',
                    complete: function (data) {
                        var result = "";

                        var engines = JSON.parse(data.responseText).engines;
                        for (var i=0; i!=engines.length; ++i) {
                            result += "<option>"+ engines[i] +"</option>";
                        }
                        document.getElementById("engines").innerHTML = result;
                    }
                })
        );

        $(
                $.ajax('../json.do', {
                    method : 'get',
                    complete: function (data) {
                        var result = "";

                        var transmissions = JSON.parse(data.responseText).transmissions;
                        for (var i=0; i!=transmissions.length; ++i) {
                            result += "<option>"+ transmissions[i] +"</option>";
                        }
                        document.getElementById("transmissions").innerHTML = result;
                    }
                })
        );

        $(
                $.ajax('../json.do', {
                    method : 'get',
                    complete: function (data) {
                        var result = "";

                        var gearboxes = JSON.parse(data.responseText).gearboxes;
                        for (var i=0; i!=gearboxes.length; ++i) {
                            result += "<option>"+ gearboxes[i] +"</option>";
                        }
                        document.getElementById("gearboxes").innerHTML = result;
                    }
                })
        );
    </script>

</head>
<body>
    <div class="center-block-main">
            <h2>Add your car</h2>
            <form:form commandName="carAddForm" action="${pageContext.servletContext.contextPath}/car/add.do" method="post" cssClass="form-horizontal" >
                    <form:input path="user.id"/>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Brand</label>
                    <div class="col-sm-10">
                            <form:input path="car.brand" class="form-control" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Model</label>
                    <div class="col-sm-10">
                            <form:input path="car.model" class="form-control" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Year</label>
                    <div class="col-sm-10">
                            <form:select path="car.year" cssClass="form-control" id="years"  oninvalid="this.setCustomValidity ( 'Please select your country from the list.')"
                                    oninput = "setCustomValidity ( '')">
                            </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Type body</label>
                    <div class="col-sm-10">
                        <spring:bind path="car.typeBody">
                            <form:select path="car.typeBody" cssClass="form-control" id="types"  oninvalid="this.setCustomValidity ( 'Please select your country from the list.')"
                                    oninput = "setCustomValidity ( '')">
                            </form:select>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Engine</label>
                    <div class="col-sm-10">
                            <form:input path="engine.name" cssClass="form-control" placeholder="choose or enter your..." type="text" list="engines" />
                            <datalist id="engines">
                            </datalist>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Transmission</label>
                    <div class="col-sm-10">
                            <form:input path="transmission.name" cssClass="form-control" type="text" list="transmissions" />
                            <datalist id="transmissions">
                            </datalist>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Gearbox</label>
                    <div class="col-sm-10">
                            <form:input path="gearbox.name" value="${status.value}" cssClass="form-control" type="text" list="gearboxes" />
                            <datalist id="gearboxes">
                            </datalist>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-10">
                        <spring:bind path="car.desc">
                            <form:textarea path="car.desc" cssClass="form-control" rows="4"></form:textarea>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-10">
                            <form:input path="car.price" class="form-control" type="text" value="0" />
                    </div>
                </div>
                <%--<div class="form-group">
                    <label class="col-sm-2 control-label">Photo</label>
                    <div class="col-sm-10">
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
                                    <img src="<c:url value="/resources/img/car-icon.png"/>" alt="...">
                                </div>
                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                <div>
                                    <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span>
                                            <form:input path="image" type="file" />
                                    </span>
                                    <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
                                </div>
                            </div>
                    </div>
                </div>--%>
                <hr class="hr-my">
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10 text-right">
                        <form:button type="submit" cssClass="btn btn-success btn-my">Add</form:button>
                    </div>
                </div>
            </form:form>
    </div>
</body>
</html>
