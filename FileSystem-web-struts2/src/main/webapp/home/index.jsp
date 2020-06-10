<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<html>
    <head>
        <title>Cloud Based File Management Web Application</title>
        <script src="../js/fileoperation.js"></script>
        <script src="../js/diroperate.js"></script>
    </head>

    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />

    <body class="front-body">
    <jsp:include page = "/template/_head.jsp" />
    <jsp:include page="/template/_commonjs.jsp"/>
    <jsp:include page="../include/_navbar.jsp?memu=home"/>

    <div class="front-inner front-inner-media">
        <div class="container">
            <div>
                <jsp:include page="../include/_search.jsp"/>
            </div>
            <div class="row front-canvas" id="front-canvas">
                <!-- 左侧栏 -->
                <div class="col-md-4" style="padding-right: 10px">
                    <jsp:include page="../include/_leftdirtree.jsp"/>
                </div>
                <div class="col-md-8" style="padding-left: 10px">
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
            </div>
        </div>
    </div>

    </body>





</html>
<script>
    $(function () {
      $("#homeTag").addClass("front-active");
    })
</script>
