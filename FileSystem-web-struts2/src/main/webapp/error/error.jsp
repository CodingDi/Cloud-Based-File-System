<%--
  Created by IntelliJ IDEA.
  User: lizhenhao
  Date: 2017/2/19
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Error</title>
</head>
<body>


<h1>error page</h1>
<a href="javascript:e=document.getElementById('es').style;if(e.display=='')e.display='none';else e.display='';void(0);">see more</a>
<div id="es" style="display:none;text-align: left">${exceptionStack}
</div>

</body>
</html>
