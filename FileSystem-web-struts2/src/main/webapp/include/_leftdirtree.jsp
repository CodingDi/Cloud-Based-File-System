<%@ taglib prefix="s" uri="/struts-tags" %>
<%--

  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>

<%--0年度  1事件   2部门--%>
<html>
<head>
    <base href="<%=request.getScheme() + "://" + request.getServerName()
        + ":" + request.getServerPort() + request.getContextPath()%>">
</head>
<body>

    <div class="panel panel-default front-panel" style="height: 50%">
        <div class="panel-heading font-style">
            <a href="javascript:queryFirst(0)" style="cursor: pointer" id="leftdirtree-sort-year" >Year</a>&emsp;
            <a href="javascript:queryFirst(1)" style="cursor: pointer" id="leftdirtree-sort-event">Event</a>&emsp;
            <a href="javascript:queryFirst(2)" style="cursor: pointer" id="leftdirtree-sort-topic">Department</a>
            <a style="float: right; cursor: pointer"><span style="margin-top: 3px;" class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>
        </div>
            <div style="min-height: 500px;background-color: white;">
                <ul class="ztree" id="dirTree" ></ul>
            </div>
    </div>

</body>
</html>

<script>
    var kind = 0;
    $(function() {
        $("")
        $.get("directory/findAllDirectory", {
                    'kind':kind,
                    'type':"INIT"
        }, function(data) {
            zNodes = JSON.parse(data);
            $.fn.zTree.init($("#dirTree"), setting, zNodes);
            sortDirTree(0);
        });
    });
</script>