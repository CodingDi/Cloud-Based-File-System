<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Idan
  Date: 2017/7/21
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:iterator value="dirList" id="dir">
    <tr>
        <td><s:property value="#dir.name"/></td>
        <td><s:property value="#dir.date"/></td>
        <td style="text-align:right;border:none">
            <div class="text-right:center">
                <a data-toggle="front-modal" data-href="include/admin/modal_updatedepartment.jsp?name=<s:property value="#dir.name"/>&id=<s:property value="#dir.id"/>" data-title="编辑部门">Edit</a>
                <a onclick="deleteById(<s:property value="#dir.id"/>)">Delete</a>
            </div>
        </td>
    </tr>
</s:iterator>