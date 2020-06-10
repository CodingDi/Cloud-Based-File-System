<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal-body" style="padding: 0px;">
    <input class="hidden" value="${param.id}" id="department-id">
    <div class="form-horizontal" style="width:100%;margin-top: 15px;">
        <div class="form-group">
            <label class="col-md-3 control-label">Department Name</label>
            <div class="col-md-4">
                <input id="name" class="form-control front-no-radius front-no-box-shadow"  value="${param.name}" type="text" placeholder="登录用户名">
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-default" data-dismiss="modal">Cancel</a>
        <button type="button" class="btn btn-primary" onclick="modify()">Save</button>
    </div>
</div>
<script type="text/javascript">
    function modify() {
        var departmentId = $('#department-id').val();
      if ($("#name").val().length == 0) {
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'Input department name！'});
      }  else {
            $.ajax({
                url: "directory/update",
                type: 'post',
                data: {
                    "dirId":departmentId,
                    "dirName":$("#name").val(),
                    'type':'DEPARTMENT'
                },
                success: function (data) {
                    if (data.errorCode==200) {
                        $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'Add success！'});
                        window.location.reload();
                    } else {
                        $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:data.errorMessage});
                    }
                }
            })
        }
    }
</script>