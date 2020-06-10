<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/" />
    <title>Cloud Based File Management Web Application</title>
    <style type="text/css">
        .front-table > tbody > tr:last-child {
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body class="front-body">
<jsp:include page = "/template/_head.jsp" />
<jsp:include page="/template/_commonjs.jsp"/>
<jsp:include page="/include/_navbar.jsp"/>
<div class="front-inner front-inner-media">
    <%--<s:include value="nav.jsp?act=admin"/>--%>
    <div class="container">
        <div class="row">
            <s:include value="/include/enterprise/enterprise_left.jsp?memu=root&manager=enterprise"/>
            <div class="col-md-9">
                <div class="panel-heading" style="height:54px;"><p style="float: left;margin: 6px 0 0 0 ">All Enterprise</p>
                    <a type="button" class="btn btn-primary pull-right" data-toggle="front-modal" data-href="include/enterprise/modal_newenterprise.jsp" data-title="新增用户">Add Enterprise</a></div>
                <div class="panel panel-default front-panel">
                    <div class="panel-body front-no-padding">
                        <table class="table table-striped front-table">
                            <thead>
                                <th class="col-sm-3">Name</th>
                                <th class="col-sm-3">Description</th>
                                <th class="col-sm-3">Creat Time</th>
                                <th class="col-sm-3" style="text-align: right">Operation</th>
                            </thead>
                            <tbody id="enterprise-list">
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
        var enterpriseUrl = "enterprise/findAll";
       $.get(enterpriseUrl,function (data) {
           $('#enterprise-list').html(data);
       });
    });

    function deleteById(uid) {
        $.tipModal('confirm', 'warning', '刪除企业', function(result) {
            if(result == true){
                $.post("enterprise/delete",{'enterpriseId':uid},function (data) {
                    if(data.code==200){
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