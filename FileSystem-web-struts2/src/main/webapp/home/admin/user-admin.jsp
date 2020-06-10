<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/" />
    <title>User admini</title>
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
                <div class="panel-heading" style="height:54px;"><p style="float: left;margin: 6px 0 0 0 ">All users</p>
                    <a type="button" class="btn btn-primary pull-right" data-toggle="front-modal" data-href="include/admin/modal_newuser.jsp" data-title="Add User">Add User</a></div>
                <div class="panel panel-default front-panel">
                    <div class="panel-body front-no-padding">
                        <table class="table table-striped front-table">
                            <thead>
                            <th class="col-sm-2">Name</th>
                            <th class="col-sm-2">Telephone</th>
                            <th class="col-sm-2">Change Password</th>
                            <th class="col-sm-2">Role</th>
                            <th class="col-sm-4" style="text-align: right">Operation</th>
                            </thead>
                            <tbody id="user-list">
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
        var url="account/findByRoleAndEnterpriseId";
        $.get(url,function (data) {
            $('#user-list').html(data);
        });
    });

    function resetPsw(uid) {
        $.tipModal('confirm', 'info', '确定将该用户密码重置为默认密码吗？', function (result) {
            if(result){
                $.post("account/update",{userId:uid,updateType:"RESET_PWD"},function (data) {
                    if(data.code=200){
                        $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'修改成功！'});
                    }else {
                        $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'修改失败！'});
                    }
                })
            }
        })
    }

    function cancelAdmin(uid) {
        $.tipModal('confirm', 'info', '确定取消该用户管理员权限吗？', function (result) {
            if (result) {
                var role = "ROLE_ADMIN";
                $.ajax({
                    url:"account/update",
                    type:"post",
                    data:{userId:uid,
                        updateType:"CANCEL_ADMIN"},
                    success:function(data){
                            if (data.code=200) {
                                $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'取消成功！'});
                                window.location.reload();
                            } else {
                                $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'修改失败！'});
                            }
                    }
                })
            }
        })
    }
    function setAdmin(uid) {
        $.tipModal('confirm', 'info', '确定将该用户设置为管理员吗？', function (result) {
            if (result) {
                $.ajax({
                    url:"account/update",
                    type:"post",
                    data:{userId:uid,
                    updateType:"SET_ADMIN"},
                    success:function(data){
                        if (data.code == 200) {
                            $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'设置成功！'});
                            window.location.reload();
                        } else {
                            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'修改失败！'});
                        }
                    }
                })
            }
        })
    }

    function deleteUser(uid) {
        $.tipModal('confirm', 'warning', '删除用户', function(result) {
            if(result == true){
                $.get("account/delete",{'userId':uid},function (data) {
                    if(data.code==200){
                        $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'删除成功！'});
                        window.location.reload();
                    } else {
                        $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:data.message});
                    }
                })
            }
        });
    }
</script>
</body>
</html>