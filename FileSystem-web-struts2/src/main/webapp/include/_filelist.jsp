
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <base
    href="<%=request.getScheme() + "://" + request.getServerName()
        + ":" + request.getServerPort() + request.getContextPath()%>">
</head>
<body>

<div style="height: 40px">
        <s:if test="operation == \"2\" ">
            <span class="font-size">Found <strong><s:property value="%{searchDetails.size()}"/></strong> files <strong><s:property value="keyword"/></strong> relevant
            </span>
        </s:if>
        <div class="button-style">
            <a class="btn btn-primary font-style" href="directory/uploadFilePage?id=0">Upload</a>
    </div>
</div>

<input class="hidden" id="operation-type" value=<s:property value="operationType"/>>
<div class="panel panel-default front-panel">
<table class="table table-striped" style="text-align: center; margin-bottom:0px">
    <thead style="font-weight: bold">
        <tr>
            <td>Name</td>
            <td style="width: 100px">Year</td>
            <td style="width: 120px">Department</td>
            <td style="width: 160px">Operation</td>
        </tr>
    </thead>
    <tbody>
        <s:iterator id="file" value="searchDetails">
            <tr>
                <s:if test="operation == \"1\" ">
                    <td>
                        <div>
                            <s:property  value="#file.fileName"/>
                        </div>
                    </td>
                </s:if>
                <s:else>
                    <td style="text-align: left">
                        <div class="title">
                            <s:property escape="false" value="#file.title"/>
                        </div>
                        <div class="description">
                            <s:property escape="false" value="#file.describtion"/>
                        </div>
                    </td>
                </s:else>
                <td>
                    <div><s:property value="#file.year"/></div>
                </td>
                <td>
                    <div><s:property value="#file.departmentName"/></div>
                </td>
                <td>
                        <input class="hidden filetype" value=<s:property value="#file.id"/>>
                        <input class="hidden" id="<s:property value="#file.id"/>text" value=<s:property value="#file.textFilePath"/>>
                        <input class="hidden" id="<s:property value="#file.id"/>pic" value=<s:property value="#file.picFilePath"/>>
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a style="padding: 0 10px 0 0" href="#" class="dropdown-toggle" data-toggle="dropdown">Download<span class="caret" ></span></a>
                                <ul class="dropdown-menu nav-dropdown">
                                    <li>
                                        <a id="<s:property value="#file.id"/>down-text" href="file/downFile?path=<s:property value="#file.textFilePath"/><s:property value="#file.textFileName"/>">Text</a>
                                    </li>
                                    <li>
                                        <a id="<s:property value="#file.id"/>down-pic" href="file/downFile?path=<s:property value="#file.picFilePath"/><s:property value="#file.picFileName"/>">Image</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                        <a style="padding: 0 10px 0 0" href="javascript:void(0)" onclick="editFile(<s:property value="#file.id"/>)">Edit</a>
                            <%--<a style="padding: 0 10px 0 0" href="javascript:void(0)">编辑</a>--%>
                            </li>
                            <li>
                                <a style="padding: 0 10px 0 0" href="javascript:void(0)" onclick="deleteFile('<s:property value="#file.id"/>')">Delete</a>
                                <%--<a style="padding: 0 10px 0 0" href="javascript:void(0)">删除</a>--%>
                        </li>
                        </ul>
                    </div>
                </td>
            </tr>
        </s:iterator>
    </tbody>

</table>
</div>

<div style="text-align: center" id="file-page"></div>

</body>
</html>
<script>
    var fileList = {};
    <s:iterator id="file" value="searchDetails">
    var fileInfo = {
        id: '<s:property value="#file.id"/>',
        departmentId: '<s:property value="#file.departmentId"/>',
        year: '<s:property value="#file.year"/>',
        eventId: '<s:property value="#file.eventId"/>',
        textFileName: '<s:property value="#file.textFileName"/>',
        picFileName: '<s:property value="#file.picFileName"/>',
        fileName: '<s:property value="#file.fileName"/>'

    };
    fileList['<s:property value="#file.id"/>'] = fileInfo;
    </s:iterator>

    $(function () {
        var typeArr = $('input.filetype');
        if (typeArr.length!=0) {
            for (index in typeArr) {
                var fileId = typeArr[index].value;
                $('#'+fileId+'down-div').hide();
                var filetext = $("#"+fileId+"text").val();
                console.log(filetext);
                var filepic = $("#"+fileId+"pic").val();
                if (filetext == "") {
                    $('#'+fileId+'down-text').removeAttr('href');
                    $('#'+fileId+'down-text').css('color','gray');
                }
                if (filepic == "") {
                    $('#'+fileId+'down-pic').removeAttr("href");
                    $('#'+fileId+'down-pic').css('color','gray');
                }
            }
        }

    });
    function editFile(id) {
        console.log(fileList[id].fileName);
        window.location.href = "directory/uploadFilePage?eventId=" + fileList[id].eventId + "&departmentId=" + fileList[id].departmentId + "&year=" + fileList[id].year +"&id=" + id + "&textFileName=" + fileList[id].textFileName + "&picFileName=" + fileList[id].picFileName + "&fileName=" + fileList[id].fileName;
    }

    function showDownLoad(id) {
        $('#'+id+'down-div').slideToggle(500,function () {
            if ($('#'+id+'down-div').is(':hidden')) {
                $('#'+id+'down-icon').removeClass("glyphicon-chevron-up");
                $('#'+id+'down-icon').addClass("glyphicon glyphicon-chevron-down");
            } else {
                $('#'+id+'down-icon').removeClass("glyphicon-chevron-down");
                $('#'+id+'down-icon').addClass("glyphicon glyphicon-chevron-up");
            }
        });
    };
</script>