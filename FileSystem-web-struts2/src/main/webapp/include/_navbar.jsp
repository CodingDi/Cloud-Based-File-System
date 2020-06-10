<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lizhenhao
  Date: 2017/2/28
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="dist/datetimepicker/bootstrap-datetimepicker.min.css">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top front-nav">
    <div class="container">
        <div>
            <!-- 左侧栏移动端触发：可选  -->
            <%--<img class="nav-toggle-left" id="front-nav-toggle-left" alt="SidebarToggle"/>--%>
            <!-- -->
            <!-- 品牌图片大小为150 * 30：宽度不定，高度固定30px -->
            <div class="nav-brand"><a href="javascript:void(0)">
                <img src="img/logo.png" alt="brand" style="height: 30px" class="img-responsive"/>
            </a></div>
            <ul class="nav navbar-nav">
                <%
                    if (((String)session.getAttribute("role")).equals("ROLE_ADMIN")){
                %>
                <li class="${param.menu=='home'?'front-active':''}">
                    <a href="home/index.jsp?menu=home" class="font-style" >Home</a>
                </li> <!-- 激活菜单 -->
                <li id="admin-li" class="${param.menu=='admin'?'front-active':''}">
                    <a href="home/admin/logo_admin.jsp?menu=admin&manager=logo" class="font-style">Enterprise Admini.</a>
                </li>
                <%}%>
                <%
                    if (((String)session.getAttribute("role")).equals("ROLE_ROOT")){
                %>
                <li id="admin-li" class="${param.menu=='root'?'front-active':''}">
                    <a href="home/enterprise/enterprise-admin.jsp?menu=root&manager=enterprise" class="font-style">App Admin.</a>
                </li>
                <%}%>
            </ul>
        </div>

        <div class="nav-right">
            <!-- 产品导航-->
            <div class="area area-media"><span class="font-size">[<s:property value="#session.enterpriseName"/>]<s:property value="#session.name"/> ,hello！
             <a data-toggle="front-modal" data-title="修改密码" data-href="include/modal_changepassword.jsp">Change Password</a>
            <a id="logout-btn" href="login/logout" class="font-size">logout</a></span></div>
        </div>
    </div>
</nav>

</body>
</html>
