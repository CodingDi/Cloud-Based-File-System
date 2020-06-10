<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/" />
    <title>Cloud Based File Management Weba Application</title>
</head>

<body class="front-body">
<jsp:include page = "/template/_head.jsp" />
<jsp:include page="/template/_commonjs.jsp"/>
<nav class="navbar navbar-default navbar-fixed-top front-nav">
    <div class="container">
        <div>
            <!-- 左侧栏移动端触发：可选  -->
            <%--<img class="nav-toggle-left" id="front-nav-toggle-left" alt="SidebarToggle"/>--%>
            <!-- 品牌图片大小为150 * 30：宽度不定，高度固定30px -->
            <div class="nav-brand"><a href="home"><img class="img-responsive" style="height:30px;" src="<s:property value="landingLogoPath"/>" onerror="javascript:this.src='img/logo.png'"alt="Babycheckup"/></a></div>
        </div>
        <!-- 导航栏右侧区域 -->
        <%--<div class="nav-right">
            <div class="area area-media" style="font-size: 14px">您好，请先登录！</div>
        </div>--%>
    </div>
</nav>
<div class="front-inner">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="panel panel-default front-panel" style="background: #e7e7e7; border: 0;">
                    <div class="panel-body" style="height: 100%;padding: 0px;">
                        <img src="<s:property value="bannerLogoPath"/>" class="change-img" onerror="javascript:this.src='img/002.png'" style="width: 100%;max-width: 100%; display: block;">
                        <%--height: 271px;width: 847.5px;--%>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="panel panel-default front-panel" style=" border: 0;">
                    <div class="panel-heading">
                        <img src="img/landing.png" onerror="javascript:this.src='img/landing.png'">
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" method="post" action="login/login" onsubmit="return preSubmit()">
                            <div class="form-group" id="tel-div">
                                <input type="text" class="form-control login-input" id="tel-input" name="tel" placeholder="tel" style="margin-right: auto;margin-left: auto;width: 90%">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <span class="help-block" id="tel-help-block" style="display: none;">invalid telephone number</span>
                                </div>
                            </div>
                            <div class="form-group" id="psw-div">
                                <input type="password" class="form-control login-input" id="psw-input" name="psw" placeholder="password">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <span class="help-block" id="psw-help-block" style="display: none;">Please input valid password</span>
                                </div>
                            </div>
                            <%--<div class="form-group">--%>
                            <%--<div class="col-sm-offset-2 col-sm-10">--%>
                            <%--<div>--%>
                            <%--<table><tbody><tr>--%>
                            <%--<td><input id="code" type="text" class="squareinput" style="width: 70px"></td>--%>
                            <%--<td><img src="statics/img/SecurityCodeImage.jpg" alt="看不清 换一张"></td>--%>
                            <%--<td><a href="">换一张</a></td>--%>
                            <%--</tr></tbody></table>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> Remember
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-info btn-block login-input">login</button>
                                <s:if test="wrongOfTelOrPsw">
                                    <div class="col-sm-8">
                                        <p class="form-control-static" style="color: red; font-size: medium">Invalid Tel. or password</p>
                                    </div>
                                </s:if>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <s:include value="/include/_footer.jsp"/>
</div>
<script src="js/landing.js"></script>
<script src="js/jquery.md5.js"></script>
</body>
</html>
