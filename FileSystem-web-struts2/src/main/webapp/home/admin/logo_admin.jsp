<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/" />
    <title>Home Administration</title>
</head>
<body class="front-body">
<jsp:include page = "/template/_head.jsp" />
<jsp:include page="/template/_commonjs.jsp"/>
<jsp:include page="../../include/_navbar.jsp"/>
<div class="front-inner front-inner-media">
    <div class="container">
        <div class="row">
            <s:include value="../../include/admin/admin_left.jsp?memu=manager"/>
            <div class="col-md-9" id="logo-content">


            </div>
        </div>
    </div>
</div>
<script>

    $(function () {
        var departUrl = "logo/findLogo";
        $.get(departUrl,
                function (data) {
                    $('#logo-content').html(data);
                });
    });

</script>
</body>
</html>