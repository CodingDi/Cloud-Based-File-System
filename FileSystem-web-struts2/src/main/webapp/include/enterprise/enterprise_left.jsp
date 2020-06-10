<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col-md-3 nav-left-offcanvas" id="nav-left-offcanvas">
    <div class="list-group nav-left">
        <a id="department-manager" href="home/enterprise/enterprise-admin.jsp?manager=enterprise&menu=root" class="list-group-item ${param.manager=='enterprise'?'active':''}">企业管理<span class="glyphicon glyphicon-chevron-right"></span></a>

        <a id="user-manager" href="home/enterprise/user-admin.jsp?manager=user&menu=root" class="list-group-item ${param.manager=='user'?'active':''}">用户管理<span class="glyphicon glyphicon-chevron-right"></span></a>
    </div>
</div>
<!-- end 左侧栏 -->