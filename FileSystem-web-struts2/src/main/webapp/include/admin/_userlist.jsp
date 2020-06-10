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
        <td><a onclick="resetPsw(<s:property value="#user.id"/>)">Reset</a></td>
        <s:if test="#user.role == 'ROLE_ADMIN'">
            <td>Manager</td>
            <td style="text-align:right;border:none">
                <div class="text-right:center">
                    <a onclick="cancelAdmin(<s:property value="#user.id"/>)">Cancel Manager</a>
                    <a onclick="deleteUser(<s:property value="#user.id"/>)">Delete User</a>
                </div>
            </td>
        </s:if>
        <s:elseif test="#user.role == 'ROLE_USER'">
            <td>Normal</td>
            <td style="text-align:right;border:none">
                <div class="text-right:center">
                    <a onclick="setAdmin(<s:property value="#user.id"/>)">Set as Manager</a>
                    <a onclick="deleteUser(<s:property value="#user.id"/>)">Delete User</a>
                </div>
            </td>
        </s:elseif>
    </tr>
</s:iterator>
