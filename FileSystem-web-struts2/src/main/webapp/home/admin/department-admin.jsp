<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/" />
    <title>Department</title>
    <style type="text/css">
        .front-table > tbody > tr:last-child {
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body class="front-body">
<jsp:include page = "/template/_head.jsp" />
<jsp:include page="/template/_commonjs.jsp"/>
<jsp:include page="../../include/_navbar.jsp"/>
<div class="front-inner front-inner-media">
    <%--<s:include value="nav.jsp?act=admin"/>--%>
    <div class="container">
        <div class="row">
            <s:include value="../../include/admin/admin_left.jsp?memu=manager"/>
            <div class="col-md-9">
                <div class="panel-heading" style="height:54px;"><p style="float: left;margin: 6px 0 0 0 ">All Department</p>
                    <a type="button" class="btn btn-primary pull-right" data-toggle="front-modal" data-href="include/admin/modal_newdepartment.jsp" data-title="Add Department">Add department</a></div>
                <div class="panel panel-default front-panel">
                    <div class="panel-body front-no-padding ">
                        <table class="table table-striped front-table">
                            <thead>
                                <th class="col-sm-4">Name</th>
                                <th class="col-sm-4">Create time</th>
                                <th class="col-sm-4" style="text-align:right;">Operation</th>
                            </thead>
                            <tbody id="department-list">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">

    $(function () {
        var departUrl = "directory/findDepartmentByType";
       $.get(departUrl,
               {
                   'kind':2,
               },function (data) {
                    $('#department-list').html(data);
               });
    });

    function deleteById(uid) {
        $.tipModal('confirm', 'warning', '刪除部门', function(result) {
            if(result == true){
                $.post("directory/delete",{'dirId':uid},function (is) {
                    if(is){
                        $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'删除成功！'});
                        window.location.reload();
                    }
                })
            }
        })
    }
</script>
</body>
</html>