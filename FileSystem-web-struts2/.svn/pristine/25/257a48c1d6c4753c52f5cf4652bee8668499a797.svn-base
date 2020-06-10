<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Idan
  Date: 2017/7/21
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:iterator value="users" id="user">
    <tr>
        <td><s:property value="#user.userName"/></td>
        <td><s:property value="#user.telephone"/></td>
        <td><a onclick="resetPsw(<s:property value="#user.id"/>)">重置密码</a></td>
        <s:if test="#user.role == 'ROLE_ADMIN'">
            <td><s:property value="#user.enterpriseName"/></td>
            <td style="text-align:right;border:none">
                <div class="text-right:center">
                    <a onclick="cancelAdmin(<s:property value="#user.id"/>)">取消管理员</a>
                    <a onclick="deleteUser(<s:property value="#user.id"/>)">删除用户</a>
                </div>
            </td>
        </s:if>
    </tr>
</s:iterator>
