<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal-body" style="padding: 0px;">
    <div class="form-horizontal" style="width:100%;margin-top: 15px;">
        <div class="form-group">
            <label class="col-md-3 control-label">Tel.</label>
            <div class="col-md-4">
                <input id="telephone" class="form-control front-no-radius front-no-box-shadow"  type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">User Name</label>
            <div class="col-md-4">
                <input id="name" class="form-control front-no-radius front-no-box-shadow"  type="text" placeholder="Account name">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Password</label>
            <div class="col-md-4">
                <input id="password" class="form-control front-no-radius front-no-box-shadow" value="abc123" type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">User role</label>
            <div class="col-md-4">
                <select class="form-control" id="role">
                    <option value="ROLE_USER">Normal</option>
                    <option value="ROLE_ADMIN">Manager</option>
                </select>
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
        if ($("#telephone").val().trim().length == 0) {
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'请填写联系电话！'});
        } else if ($("#name").val().length == 0) {
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'请填写用户姓名！'});
        } else if ($("#password").val().length == 0) {
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'请填写用户密码！'});
        } else {
            $.ajax({
                url: 'account/add',
                type: 'post',
                data: {
                    "tel":$("#telephone").val(),
                    "name":$("#name").val(),
                    "psw":$("#password").val(),
                    "role":$('#role').val(),
                },
                success: function (data) {
                    if (data.code==200) {
                        $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'保存成功！'});
                        window.location.reload();
                    } else {
                        $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'添加失败！'});
                    }
                }
            })
        }
    }
</script>