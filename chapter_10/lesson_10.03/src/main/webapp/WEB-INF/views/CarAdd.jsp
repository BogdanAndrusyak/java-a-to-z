<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new car</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">

    <link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"/>" rel="stylesheet" id="bootstrap-css">
    <link href="<c:url value="/resources/css/jasny-bootstrap.min.css"/>" rel="stylesheet">

    <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<c:url value="/resources/js/jasny-bootstrap.min.js"/>"></script>
    <script>
        $(
                $.ajax('../json', {
                    method : 'get',
                    complete: function (data) {
                        var result = "<option value=''>---</option>";

                        var years = JSON.parse(data.responseText).years;
                        for (var i=years.length-1; i>=0; --i) {
                            result += "<option value='"+ years[i] +"'>"+ years[i] +"</option>";
                        }
                        document.getElementById("years").innerHTML = result;
                    }
                })
        );

        $(
                $.ajax('../json', {
                    method : 'get',
                    complete: function (data) {
                        var result = "<option value=''>---</option>";

                        var types = JSON.parse(data.responseText).types;
                        for (var i=0; i!=types.length; ++i) {
                            result += "<option value='"+ types[i] +"'>"+ types[i] +"</option>";
                        }
                        document.getElementById("types").innerHTML = result;
                    }
                })
        );

        $(
                $.ajax('../json', {
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
                $.ajax('../json', {
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
                $.ajax('../json', {
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
            <form action="${pageContext.servletContext.contextPath}/addcar" method="post" class="form-horizontal" enctype="multipart/form-data">
                <input name="owner-id" type="hidden" value="${user.id}">

                <div class="form-group">
                    <label class="col-sm-2 control-label">Brand</label>
                    <div class="col-sm-10">
                        <input name="brand" class="form-control" type="text" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Model</label>
                    <div class="col-sm-10">
                        <input name="model" class="form-control" type="text" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Year</label>
                    <div class="col-sm-10">
                        <select name="year" class="form-control" id="years" required oninvalid="this.setCustomValidity ( 'Please select your country from the list.')"
                                oninput = "setCustomValidity ( '')">
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Type body</label>
                    <div class="col-sm-10">
                        <select name="type-body" class="form-control" id="types" required oninvalid="this.setCustomValidity ( 'Please select your country from the list.')"
                                oninput = "setCustomValidity ( '')">
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Engine</label>
                    <div class="col-sm-10">
                        <input name="engine" class="form-control" placeholder="choose or enter your..." type="text" list="engines" required>
                        <datalist id="engines">
                        </datalist>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Transmission</label>
                    <div class="col-sm-10">
                        <input name="transmission" class="form-control" type="text" list="transmissions" required>
                        <datalist id="transmissions">
                        </datalist>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Gearbox</label>
                    <div class="col-sm-10">
                        <input name="gearbox" class="form-control" type="text" list="gearboxes" required>
                        <datalist id="gearboxes">
                        </datalist>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-10">
                        <textarea name="description" class="form-control" rows="4"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-10">
                        <input name="price" class="form-control" type="text" value="0">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Photo</label>
                    <div class="col-sm-10">
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
                                    <img src="<c:url value="/resources/img/car-icon.png"/>" alt="...">
                                </div>
                                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                <div>
                                    <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span><input type="file" name="photo"></span>
                                    <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
                                </div>
                            </div>
                    </div>
                </div>
                <hr class="hr-my">
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10 text-right">
                        <button type="submit" class="btn btn-success btn-my">Add</button>
                    </div>
                </div>
            </form>
    </div>
</body>
</html>
