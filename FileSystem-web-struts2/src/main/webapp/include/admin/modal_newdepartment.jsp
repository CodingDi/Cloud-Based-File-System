<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal-body" style="padding: 0px;">
    <div class="form-horizontal" style="width:100%;margin-top: 15px;">
        <div class="form-group">
            <label class="col-md-3 control-label">Department</label>
            <div class="col-md-4">
                <input id="name" class="form-control front-no-radius front-no-box-shadow"  type="text" placeholder="Department name">
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-default" data-dismiss="modal">Cancel</a>
        <button type="button" class="btn btn-primary" onclick="save()">Save</button>
    </div>
</div>
<script type="text/javascript">
    function save() {
      if ($("#name").val().length == 0) {
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'Please input department name！'});
      }  else {
            $.ajax({
                url: "directory/createDirectory",
                type: 'post',
                data: {
                    "dirName":$("#name").val(),
                    'type':'DEPARTMENT'
                },
                success: function (data) {
                    if (data.errorCode==200) {
                        $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'Success save！'});
                        window.location.reload();
                    } else {
                        $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'Failure save'});
                    }
                }
            })
        }
    }
</script>
