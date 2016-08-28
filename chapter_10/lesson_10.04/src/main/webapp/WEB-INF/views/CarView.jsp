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

    <style>

        header, nav, section {
            display: block
        }

        html {
            font-size: 100%
        }

        body, html {
            padding: 0;
            margin: 0
        }

        body {
            font-weight: 400;
            font-style: normal;
            font-size: 15px;
            font-family: Arial, Helvetica, sans-serif;
            line-height: 20px;
            color: #414042;
            overflow-y: scroll
        }

        strong {
            font-style: inherit;
            font-weight: 700
        }

        em {
            font-style: italic
        }

        a {
            color: #256799;
            border-bottom: 1px solid transparent
        }

        a img {
            border: 0
        }

        h1, h2, h3 {
            font-weight: 400;
            line-height: 1.2;
            margin: 0 0 20px
        }

        h1 {
            font-size: 30px
        }

        h2 {
            font-size: 24px
        }

        h3 {
            font-size: 18px
        }

        p {
            margin: 20px 0
        }

        ul {
            margin: 0 0 1.5em 2em;
            list-style-type: disc
        }

        dd, dl {
            margin: 0
        }

        @keyframes spin {
            0% {
                transform: rotate(0)
            }
            100% {
                transform: rotate(360deg)
            }
        }

        .header-page h1 {
            font-size: 24px;
            line-height: 25px;
            display: inline-block;
            font-weight: 700;
            margin: 0
        }

        .hide {
            display: none !important
        }

        .modal {
            position: absolute;
            left: 38%;
            bottom: auto;
            right: auto;
            margin-left: -265px
        }

        /*.fade {*/
            /*opacity: 0;*/
            /*z-index: -5*/
        /*}*/

        .row {
            margin-bottom: 20px;
            margin-left: -20px
        }

        .row:after {
            display: table;
            content: "";
            clear: both
        }

        img {
            max-width: 100%;
            height: auto;
            vertical-align: middle;
            border: 0
        }

        .button-primary {
            padding: 0 15px;
            background: #219be7;
            border: 2px solid transparent;
            border-bottom-color: #045e96
        }

        .icon-search {
            width: 21px;
            height: 21px;
            margin-top: -2px
        }

        .multilang a {
            text-decoration: underline;
            border-bottom: 0 none
        }

        .showcase-main-more .photo img {
            width: 100%
        }

        section {
            margin: 0
        }

        .icon-photo-white {
            width: 16px;
            height: 13px;
            margin-top: -3px
        }

        form {
            display: block;
            margin: 0;
            padding: 0
        }

        input[type=text], select, textarea {
            margin: 0;
            padding: 4px 0;
            font-size: 15px;
            line-height: 20px;
            font-family: Arial, Helvetica, sans-serif;
            color: #414042;
            text-align: left;
            text-decoration: none;
            text-overflow: ellipsis;
            text-shadow: 1px 0 0 #fff;
            text-indent: 5px;
            white-space: nowrap;
            overflow: hidden;
            vertical-align: middle;
            outline: 0;
            border: 1px solid #e0e3e4;
            border-radius: 3px;
            box-sizing: border-box
        }

        select {
            background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABMAAAAFAQMAAACdEUUJAAAAGXRF…TAEDm2GYAAAAZSURBVAjXY/jfwMBQz8DAYAfEMkDMwcAAACb4AmFjj8TfAAAAAElFTkSuQmCC) 100% 50% no-repeat #fff;
            user-select: none;
            text-indent: 0;
            -webkit-padding-start: 6px;
            appearance: none
        }

        textarea {
            text-indent: 0;
            background-color: #fff;
            background-size: 100% 1.5em;
            overflow: auto;
            white-space: pre-wrap;
            word-wrap: break-word;
            resize: vertical;
            padding: 5px
        }

        input[type=checkbox] + label:before, input[type=radio] + label:before {
            position: relative;
            width: 19px;
            height: 19px;
            background-image: url(https://css.riastatic.com/images/icons/check-radio-sheet.png?v=1);
            background-size: 134px 57px;
            content: "";
            display: inline-block;
            vertical-align: middle
        }

        select::-ms-expand {
            display: none
        }

        input[type=checkbox], input[type=radio] {
            display: none;
            margin: 0 2px 2px;
            vertical-align: middle
        }

        input[type=checkbox] + label:before {
            margin: -4px 4px 0 0;
            background-position: 0 0
        }

        input[type=radio] + label:before {
            margin: -3px 4px 0 0;
            background-position: 0 -38px
        }

        input[type=radio]:checked + label:before {
            background-position: -38px -38px
        }

        button, input[type=submit] {
            display: inline-block;
            text-align: center;
            margin: 0;
            padding-left: 10px;
            padding-right: 10px;
            border: 0;
            border-top: 2px solid transparent;
            border-bottom: 2px solid #2370a0;
            color: #fff;
            white-space: nowrap;
            vertical-align: middle;
            outline: 0;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            text-decoration: none;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            border-radius: 5px
        }

        .span8 {
            width: 620px
        }

        .flex-group-form {
            display: table;
            width: 100%;
            white-space: normal;
            box-sizing: border-box
        }

        .flex-group-form .middle {
            display: table-cell;
            padding-right: 4px;
            box-sizing: border-box;
            width: 50%
        }

        .flex-group-form .middle:last-child {
            padding-right: 0
        }

        .search__main {
            color: #fff;
            background: #db5c4c;
            /*border-radius: 0 0 0 12px*/
        }

        .search__main .e-form {
            width: 100%;
            border: 0
        }

        .search__main .wrapper-panel {
            padding: 15px
        }

        .search__main .button-primary {
            float: right;
            font-size: 22px;
            line-height: 31px;
            width: 145px;
            padding-bottom: 1px
        }

        .form-search__main {
            display: table;
            width: 100%;
            margin-bottom: 8px
        }

        .form-search__main .m-rows {
            display: block;
            margin: 0 0 10px
        }

        .form-search__main .m-label {
            float: left;
            line-height: 30px;
            width: 110px
        }

        .form-search__main .m-indent {
            margin: 0 0 0 110px
        }

        .form-search__main .primary-column {
            display: table-cell;
            width: 60%;
            padding-right: 20px;
            border-right: 1px solid #f75b41
        }

        .form-search__main .secondary-column {
            display: table-cell;
            width: 40%;
            padding-left: 20px;
            border-left: 1px solid #b94233
        }

        .form-search__main .secondary-column .m-label {
            width: 70px
        }

        .form-search__main .secondary-column .m-indent {
            margin-left: 70px
        }

        .form-search__main .secondary-column .e-cost .middle {
            width: 33.33%
        }

        .footbar-search__main {
            display: inline-block;
            width: 100%
        }

        .footbar-search__main .checkrows {
            float: left;
            margin-top: 10px;
            margin-left: 45px
        }

        .nav-search__main {
            margin: 15px 0 20px;
            font-size: 18px
        }

        .nav-search__main input[type=radio] {
            display: none;
            margin: 0 2px 2px;
            vertical-align: middle
        }

        .nav-search__main input[type=radio] + label:before {
            position: relative;
            display: inline-block;
            width: 26px;
            height: 26px;
            margin: -5px 5px 0 0;
            vertical-align: middle;
            background: url(https://css.riastatic.com/images/icons/i-radio.png) no-repeat;
            background-size: 27px 52px;
            content: ""
        }

        .nav-search__main input[type=radio]:checked + label:before {
            background-position: 0 -26px
        }

        .nav-search__main > label {
            margin-right: 10px
        }

        .nav-search__main .m-label {
            display: inline-block;
            width: 195px
        }

        @media screen and (min-width: 769px) {
        }

        @media (min-width: 769px) {

        }

        @media (min-width: 770px) {
        }

        @media screen and (max-width: 1200px) {
        }

        @media screen and (max-width: 1040px) {
        }

        @media screen and (max-width: 768px) {

            .row {
                margin: 0
            }

            .title-head a {
                display: inline-block;
                vertical-align: top
            }

        }

        @media (max-width: 768px) {

            .form-search__main .m-indent, .form-search__main .secondary-column .m-indent {
                margin-left: 0
            }

            .search__main {
                border-radius: 0
            }

            .search__main .e-form {
                line-height: 25px
            }

            .search__main .wrapper-panel {
                padding: 15px 15px 10px
            }

            .nav-search__main {
                font-size: 15px
            }

            .nav-search__main label:after {
                position: absolute;
                border: 1px solid #fff;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                content: ""
            }

            .nav-search__main input[type=radio] + label:before {
                width: 16px;
                height: 16px;
                background: url(https://css.riastatic.com/images/icons/i-radio-m.png) no-repeat;
                background-size: 16px 37px
            }

            .nav-search__main input[type=radio]:checked + label:before {
                background-position: 0 -20px
            }

            .nav-search__main input[type=radio]:checked + label:after {
                border: 0;
                box-shadow: inset 0 0 10px rgba(0, 0, 0, .3)
            }

            .nav-search__main > label {
                margin-right: -5px;
                position: relative;
                padding: 10px
            }

            .form-search__main {
                display: block
            }

            .form-search__main .m-rows {
                margin-bottom: 15px
            }

            .form-search__main .m-label {
                display: none
            }

            .form-search__main .primary-column {
                display: block;
                width: 100%;
                padding: 0;
                border: 0;
                margin-bottom: 15px
            }

            .form-search__main .secondary-column {
                display: inline-block;
                width: 100%;
                padding: 0;
                border: 0;
                vertical-align: top
            }

            .footbar-search__main .button-primary {
                width: auto;
                line-height: 38px
            }

            .footbar-search__main .checkrows {
                display: none
            }

            .secondary-column .e-year {
                float: right;
                width: 45%
            }

            .secondary-column .e-cost {
                margin: 0 45% 0 0
            }

            .secondary-column .e-cost .m-indent {
                margin-right: 15px;
                padding-right: 15px;
                border-right: 1px solid #fff
            }

            .secondary-column .e-cost .m-label, .secondary-column .e-year .m-label {
                display: block;
                float: none;
                width: 100%;
                margin-top: -10px
            }

        }

        @media (max-width: 450px) {
        }

        @media (max-width: 360px) {
        }

        @media (max-width: 330px) {
            .secondary-column .e-year {
                float: none;
                width: 100%
            }

            .secondary-column .e-cost {
                margin: 0
            }

            .secondary-column .e-cost .m-indent {
                margin-right: 0;
                padding-right: 0;
                border-right: 0 none
            }

            .footbar-search__main .button-primary {
                width: 100%
            }
        }
    .price-icon {
        padding-left: 15px;
    }

    #myModal-queries .modal {
        width: auto!important;
        left: 38%!important;
    }

    @media (min-width: 768px) {
        #myModal-queries .modal-dialog {
            width: 960px!important;
        }
    }

    a {
        cursor: pointer;
    }

    a.show-queries {
        color: wheat;
    }
    </style>
    <script>
        $(
                $.ajax('../json', {
                    method : 'get',
                    complete: function (data) {
                        var result = "<option value=''>Any</option>";

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
                        var yearsFrom = document.getElementById("yearFrom").innerHTML;
                        var yearsTo = document.getElementById("yearTo").innerHTML;

                        var years = JSON.parse(data.responseText).years;
                        for (var i=years.length-1; i>=0; --i) {
                            yearsFrom += "<option value='"+ years[i] +"'>"+ years[i] +"</option>";
                            yearsTo += "<option value='"+ years[i] +"'>"+ years[i] +"</option>";
                        }
                        document.getElementById("yearFrom").innerHTML = yearsFrom;
                        document.getElementById("yearTo").innerHTML = yearsTo;
                    }
                })
        );

        function showQueries() {
            document.getElementById("modal-button-queries").click();
        }
    </script>
</head>
<body>
    <div class="center-block-main">

        <div class="text-right">
            <a href="${pageContext.servletContext.contextPath}/addcar" class="btn btn-info" role="button">Add your car</a>
        </div>

        <!--    .BEGIN - SearchMain    -->
        <section class="row" id="searchForm">
            <div class="span8">
                <div class="search__main">
                    <div class="wrapper-panel">

                        <div id="showFlexTextsearch"></div>

                        <div class="nav-search__main">
                            <label class="m-label">I'm looking for:</label>

                        </div>

                        <form action="${pageContext.servletContext.contextPath}/carfilter" method="post" id="mainSearchForm">
                            <input type="hidden" id="extSearch" value="0">
                            <div class="form-search__main">
                                <!--primary-->
                                <div class="primary-column">
                                    <div class="m-rows">
                                        <label class="m-label">Type body:</label>
                                        <div class="m-indent">
                                            <select class="e-form" name="type-body" id="types" data-placeholder="Any">
                                            </select>
                                        </div>
                                    </div>

                                    <div class="m-rows">
                                        <label class="m-label">Brand:</label>

                                        <div class="m-indent">
                                            <input type="text" name="brand" class="e-form" id="marks" data-field="brand"
                                                   data-placeholder="Brand">

                                            <%--<select class="e-form" id="marks" name="marka_id" data-field="brand"
                                                    data-placeholder="Brand">
                                                <option value="0">Brand</option>
                                                <option value="98">Acura (174)</option>
                                                <option value="2396" style="color: rgb(128, 125, 130);">Adler (3)</option>
                                                <option value="2" style="color: rgb(128, 125, 130);">Aixam (2)</option>
                                                <option value="3">Alfa Romeo (348)</option>
                                                <option value="100" style="color: rgb(128, 125, 130);">Alpine (3)</option>
                                            </select>--%>
                                        </div>
                                    </div>

                                    <!-- with photo -->
                                    <div class="m-rows">
                                        <label class="m-label">Model:</label>

                                        <div class="m-indent">
                                            <input type="text" name="model" class="e-form" id="models" data-field="model"
                                                   data-placeholder="Model">

                                            <%--<select class="e-form" id="models" name="model_id" data-field="model"
                                                    data-placeholder="Model">
                                                <option value="0">Model</option>
                                            </select>--%>
                                        </div>
                                    </div>

                                </div>
                                <!--end primary-->

                                <!--secondary-->
                                <div class="secondary-column">

                                    <div class="m-rows e-year">
                                        <label class="m-label">Year:</label>
                                        <div class="m-indent">
                                            <div class="flex-group-form">
                                                <div class="middle">
                                                    <select class="e-form" name="yearFrom" id="yearFrom" name="s_yers[0]" data-placeholder="from">
                                                        <option value="" selected>from</option>
                                                    </select>
                                                </div>
                                                <div class="middle">
                                                    <select class="e-form" name="yearTo" id="yearTo" name="po_yers[0]" data-placeholder="to">
                                                        <option value="" selected>to</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="m-rows e-cost">
                                        <label for="priceTo" class="m-label">Price:</label>
                                        <div class="m-indent">
                                            <div class="flex-group-form">
                                                <div class="middle">
                                                    <input class="e-form" name="priceFrom" type="text" name="price_ot" id="priceFrom"
                                                           placeholder="from">
                                                </div>
                                                <div class="middle">
                                                    <input class="e-form" name="priceTo" type="text" name="price_do" id="priceTo"
                                                           placeholder="to">
                                                </div>
                                                <div class="middle">
                                                    <span class="price-icon">$</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--end secondary-->

                            </div>

                            <div class="footbar-search__main">
                                <c:if test="${sessionScope.user != null}">
                                    <a class="show-queries" id="showQueries" onclick="showQueries()">Show History of Queries</a>
                                </c:if>
                    <%--<span class="checkrows">
                        <input type="checkbox" name="with_photo" id="with_photo" value="1">
                        <label for="with_photo">
                            <i class="icon-photo-white"></i>
                            Only with photo
                        </label>
                    </span>--%>
                                <button class="button-primary" type="submit">
                                    <i class="icon-search"></i>
                                    Search
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!--    .END - SearchMain    -->

        <!-- Modal-2 queries -->
        <div class="container">
            <button style="display: none;" id="modal-button-queries" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal-queries">Open Modal</button>

            <div class="modal fade" id="myModal-queries" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">History of Queries:</h4>
                            </div>
                            <div class="modal-body">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Type Body</th>
                                            <th>Brand</th>
                                            <th>Model</th>
                                            <th>YearFrom</th>
                                            <th>YearTo</th>
                                            <th>PriceFrom</th>
                                            <th>PriceTo</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:if test="${sessionScope.user != null}">
                                            <c:forEach var="query" items="${queries}">
                                                <tr>
                                                    <td>${query.id}</td>
                                                    <td>${query.typeBody}</td>
                                                    <td>${query.brand}</td>
                                                    <td>${query.model}</td>
                                                    <td>${query.yearFrom}</td>
                                                    <td>${query.yearTo}</td>
                                                    <td>${query.priceFrom}</td>
                                                    <td>${query.priceTo}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                    </div>

                </div>
            </div>
        </div>
        <%-- /Modal-2 queries --%>

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

        <div class="main-content">
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
    </div>
</body>
</html>
