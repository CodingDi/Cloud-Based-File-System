<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Idan
  Date: 2017/7/21
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:iterator value="enterpriseList" id="enterprise">
    <tr>
        <td><s:property value="#enterprise.name"/></td>
        <td>
            <%--<div class="description">--%>
                <s:property value="#enterprise.description"/>
            <%--</div>--%>
        </td>
        <td><s:property value="#enterprise.date"/></td>
        <td style="text-align:right;border:none">
            <div class="text-right:center">
                <a onclick="deleteById(<s:property value="#enterprise.id"/>)">删除</a>
                <a data-toggle="front-modal" data-title="编辑企业"
                   data-href="include/enterprise/modal_updateenterprise.jsp?name=<s:property value="#enterprise.name"/>&id=<s:property value="#enterprise.id"/>&description=<s:property value="#enterprise.description"/>" >编辑</a>
            </div>
        </td>
    </tr>
</s:iterator>
