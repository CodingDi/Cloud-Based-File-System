<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Idan
  Date: 2017/7/29
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<select class="form-control" id="enterprise">
    <s:iterator value="enterpriseList" id="enterprise">
        <option value="<s:property value="#enterprise.id"/>"><s:property value="#enterprise.name"/></option>
    </s:iterator>
</select>
