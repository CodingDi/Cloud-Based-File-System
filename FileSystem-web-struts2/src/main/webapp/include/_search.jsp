
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body onkeydown="keySearch()">
<div class="searchBox" style="margin-bottom: 20px;text-align: center">
    <div class="searchMain" style="display: inline-flex">
        <input type="text" id="search-input" style="font-size: 16px;height: 40px;"
               class="form-control front-no-box-shadow freeshare-title " placeholder="search..">
        <a style="font-size: 18px; height: 40px;" class="btn btn-primary" id="searchBar" onclick="searchFileAdvanced()">
            <span style="margin-top: 5px; " class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
        <a class="btn btn-link" style="padding-top: 20px" onclick="showSearch()">precise search&nbsp;<span id="search-icon" class="glyphicon glyphicon-chevron-down"></span></a>
    </div>
</div>
<div class="panel-body" id="searchPanel" style="background-color: white;margin-bottom: 20px;padding: 15px 15px 0 0">
    <div class="container-fuild">
        <div class="form-horizontal front-form-horizontal">
            <div class="form-group">
                <label class="col-md-1 control-label">Year</label>
                <div class="col-md-11">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="input-group date form-datetime col-md-12"
                                         data-date="1979-09-16T05:25:07Z" data-date-format="yyyy"
                                         data-link-field="dtp_input1">
                                        <input class="form-control" style="background-color: transparent" size="16"
                                               type="text" id="start-year" value="">
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-th"></span></span>
                                    </div>
                                </div>
                            </div>
                </div>
            </div>
        </div>
        <div class="form-horizontal front-form-horizontal">
            <div class="form-group">
                <label class="col-md-1 control-label">Event</label>
                <div class="col-md-11">
                    <select class="form-control col-md-6" id="event">
                    </select>
                </div>
            </div>
        </div>

        <div class="form-horizontal front-form-horizontal">
            <div class="form-group">
                <label class="col-md-1 control-label">Department</label>
                <div class="col-md-11">
                    <select class="form-control col-md-6" id="department">
                    </select>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function keySearch(){
        if (event.keyCode==13)
            $("#searchBar").click();
    }
    $(document).ready(function () {

        $('#searchPanel').hide();

        $.get(
                "directory/findAllDirectoryByType",
                function (data) {
                    var departmentDirList = data.departmentDirList;
                    var eventDirList = data.eventDirList;
                    for (var i in departmentDirList) {
                        $departmentItem = $("<option value='" + departmentDirList[i].id + "'>" + departmentDirList[i].name + "</option>");
                        $('#department').append($departmentItem);
                    }
                    for (var i in data.eventDirList) {
                        $eventItem = $("<option value='" + eventDirList[i].id + "'>" + eventDirList[i].name + "</option>");
                        $('#event').append($eventItem);
                    }
                });
    });

    function showSearch() {
        $('#searchPanel').slideToggle(500,function () {
            if ($('#searchPanel').is(':hidden')) {
                $('#search-icon').removeClass("glyphicon-chevron-up");
                $('#search-icon').addClass("glyphicon glyphicon-chevron-down");
            } else {
                $('#search-icon').removeClass("glyphicon-chevron-down");
                $('#search-icon').addClass("glyphicon glyphicon-chevron-up");
            }
        });
    };

    $('.form-datetime').datetimepicker({
        format: 'yyyy',
        autoclose: true,
        todayBtn: true,
        maxView: 'decade',
        language: 'zh-CN',
        startView: 4,
        minView: 4,
    });
    function searchFileAdvanced() {
        var keyword = $('#search-input').val();

        if ($('#searchPanel').is(':hidden')) {
            window.location.href = "file/searchFile?keyword=" + keyword;
        } else {
            var eventId = $('#event option:selected').val();
            var departmentId = $('#department option:selected').val();
            var year = $('#start-year').val();
            window.location.href = "file/searchFileAdvanced?eventId=" + eventId + "&departmentId=" + departmentId + "&year=" + year + "&keyword=" + keyword;
        }
    };
</script>
</body>
</html>
