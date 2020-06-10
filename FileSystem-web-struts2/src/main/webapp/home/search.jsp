<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
    <title>search</title>
    <script src="../js/fileoperation.js"></script>
</head>



<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />


<body class="front-body">
<jsp:include page = "/template/_head.jsp" />
<jsp:include page="/template/_commonjs.jsp"/>
<jsp:include page="../include/_navbar.jsp"/>

<div class="front-inner front-inner-media">
    <div class="container">

        <div class="row" id="">
            <div style="float: left;padding: 0px" class="col-sm-12 font-size" >
                <ul class="breadcrumb col-sm-12">
                    <li>
                        <a href="home/index.jsp?menu=home">Home</a> <span class="divider"></span>
                    </li>
                    <li class="active">Search Result</li>
                </ul>
            </div>
        </div>

        <div>
            <jsp:include page="../include/_search.jsp"/>
        </div>
        <input class="hidden" id="operation-type" value=<s:property value="operationType"></s:property>>
        <div class="row">
            <div id="loading" hidden>
                <div class="front-loading">
                    <div class="front-loading-block"></div>
                    <div class="front-loading-block"></div>
                    <div class="front-loading-block"></div>
                </div>
                <div class="panel-body text-center">Loading...</div>
            </div>
            <div id="fileList">
                <jsp:include page="../include/_filelist.jsp"/>
            </div>
        </div>
        <div style="text-align: center" id="file-page"></div>
    </div>

</div>
</body>

</html>
<script>
    $(function () {
        $("#homeTag").remove("front-active");
    })

    function getPage(page) {
        $('#file-page').html($.getDivPageHtml(1, 1, getPage));
    };

    getPage(1);

</script>
<script src="../js/fileoperation.js"></script>
