<%--
  Created by IntelliJ IDEA.
  User: lizhenhao
  Date: 2017/7/3
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<div class="modal-body" id="createEvent">
    <div class="form-inline text-right" >
        <div class="form-group " style="margin-bottom:10px">
            <label for="newEventName" style="font-weight:normal ;text-align:left">Event Name:&nbsp;</label>
            <input class="form-control front-no-radius front-no-box-shadow" id="newEventName" />
        </div>
    </div>
    <div class="text-right">
        <a href="" class="btn btn-default modal-close" data-dismiss="modal">Cancel</a>
        <input type="button" class="btn btn-primary " onclick="addEvent()" value="Yes">
    </div>

</div>

<script>
    function addEvent() {
        var eventName =$("#newEventName").val();
        console.log(eventName);
        var type = 'EVENT';
        $.ajax({
            type: "post",
            url: "directory/createDirectory",
            data: {
                dirName: eventName,
                type:type
            },
            success: function (data) {
                if(data.errorCode == '200') {
                    $.ajax({
                        type: "get",
                        url: "directory/findEventDirectory",
                        data :{
                            kind:'1'
                        },
                        success: function (data) {
                            if(data.errorCode == '200') {
                                debugger;
                                $('#eventOption').html("");
                                for (var i in data.dirList) {
                                    $eventItem = $("<option value='" + data.dirList[i].id + "'>" + data.dirList[i].name + "</option>");
                                    $('#eventOption').append($eventItem);
                                }
                                $(".modal").modal('hide');
                            }
                            else {
                                $.fillTipBox({type:'warning', icon:'glyphicon-exclamation-sign', content:'重载事件出错'})
                            }
                        }
                    });
                }
                else {
                    $.fillTipBox({type:'warning', icon:'glyphicon-exclamation-sign', content:'创建事件出错'})
                }
            }
        });
    }

</script>
