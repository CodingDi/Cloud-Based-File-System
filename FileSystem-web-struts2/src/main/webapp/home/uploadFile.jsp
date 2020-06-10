<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
    <title>Upload</title>
    <%--<link rel="stylesheet" href="dist/datetimepicker/bootstrap-datetimepicker.min.css">--%>
</head>



<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />

<body class="front-body">
<jsp:include page = "/template/_head.jsp" />
<jsp:include page="/template/_commonjs.jsp"/>
<jsp:include page="../include/_navbar.jsp"/>

<div class="front-inner front-inner-media">
    <div class="container">
        <div class="row">
            <ul class="breadcrumb col-sm-12 font-size">
                <li>
                    <a href="home/index.jsp?menu=home">Home</a> <span class="divider"></span>
                </li>
                <li class="active">Upload</li>
            </ul>
        </div>

        <div id="loading" hidden>
            <div class="front-loading">
                <div class="front-loading-block"></div>
                <div class="front-loading-block"></div>
                <div class="front-loading-block"></div>
            </div>
            <div class="panel-body text-center">Loading...</div>
        </div>

        <div class="row" id="upload_show">
            <div class="panel panel-default front-panel" style="margin-top: 10px">
                <div class="panel-body" >
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label">text</label>
                            <div class="col-md-6 col-sm-5">
                                <input type="file" id="textFile" onchange="refreshFileName(this)" style="width: 85%;display:inline-block">
                                <p style="margin: 6px 0 10px 0;" id="textFileName" hidden></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label">image</label>
                            <div class="col-md-6 col-sm-5">
                                <input type="file" id="picFile" onchange="refreshFileName(this)" style="width: 85%;display:inline-block">
                                <p id="picFileName" hidden></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label">Doc Name</label>
                            <div class="col-md-6 col-sm-5">
                                <input class="form-control" style="background-color: transparent" size="16" type="text" id="name" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label">Department</label>
                            <div class="col-md-6 col-sm-5">
                                <select class="form-control" id="departmentOption">
                                    <s:iterator id="department" value="departmentDirectoryList">
                                        <option value="<s:property value="#department.id"></s:property>">
                                            <s:property value="#department.name"></s:property></option>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label">Year</label>
                            <div class="col-md-6 col-sm-5">
                                <div class="input-group date form-datetime" >
                                    <input class="form-control" style="background-color: transparent" size="16" type="text" id="year" value="">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label">Event</label>
                            <div class="col-md-6 col-sm-5">
                                <select class="form-control" id="eventOption" style="width: 80%;float: left">
                                    <s:iterator id="event" value="eventDirectoryList">
                                        <option value="<s:property value="#event.id"></s:property>">
                                            <s:property value="#event.name"></s:property></option>
                                    </s:iterator>
                                </select>
                                <a class="btn btn-primary front-pointer" data-toggle="front-modal" data-size="modal-sm" data-title="New event" data-href="include/modal_createvent.jsp" style="float: right">New</a></td>
                            </div>
                        </div>

                        <div class="">
                            <div style="float: right">
                                <a href="">Cancel</a>&emsp;
                                <input type="button" class="btn btn-primary " onclick="upLoadFile(<s:property value="id"/>)" value="Upload"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <s:include value="/include/_footer.jsp"/>
</div>
</body>
<script src="js/fileoperation.js"></script>
<script>
    $('.form-datetime').datetimepicker({
        //language:  'fr',
        format: 'yyyy',
        autoclose: true,
        todayBtn: true,
        // startView: 'year',
        // minView:'year',
        maxView:'decade',
        language:  'zh-CN',
        startView: 4,
        minView: 4,
    });

    $(document).ready(function () {
        $("#homeTag").remove("front-active");

        var year = '<s:property value="year"/>';
        var eventId = '<s:property value="eventId"/>';
        var departmentId = '<s:property value="departmentId"/>';
        var textFileName = '<s:property value="textFileName"/>';
        var picFileName = '<s:property value="picFileName"/>';
        var fileName = '<s:property value="fileName"/>';

        if (year != "" && eventId!="" && departmentId!= "") {
            $("#year").val(year);
            $("#eventOption option[value="+eventId+"]").attr("selected","selected");
            $("#departmentOption option[value="+departmentId+"]").attr("selected","selected");
        }
        if (fileName != "") {
            $("#name").val(fileName);
        }
        if (textFileName != "") {
            $("#textFile").hide();
            $("#textFileName").text(textFileName).show();
        }
        if (picFileName != "") {
            $("#picFile").hide();
            $("#picFileName").text(picFileName).show();
        }
    });

</script>
</html>
