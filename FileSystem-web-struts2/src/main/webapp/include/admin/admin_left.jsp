<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col-md-3 nav-left-offcanvas" id="nav-left-offcanvas">
    <div class="list-group nav-left">
        <a id="logo" href="home/admin/logo_admin.jsp?manager=logo&menu=admin" class="list-group-item ${param.manager=='logo'?'active':''}">Home Administration<span class="glyphicon glyphicon-chevron-right"></span></a>


        <a id="user-manager" href="home/admin/user-admin.jsp?manager=user&menu=admin" class="list-group-item ${param.manager=='user'?'active':''}">User Administration<span class="glyphicon glyphicon-chevron-right"></span></a>

        <a id="department-manager" href="home/admin/department-admin.jsp?manager=department&menu=admin" class="list-group-item ${param.manager=='department'?'active':''}">Department Administration<span class="glyphicon glyphicon-chevron-right"></span></a>
    </div>
</div>
<!-- end 左侧栏 -->