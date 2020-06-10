<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal-body" style="padding: 0px;">
    <div class="form-horizontal" style="width:100%;margin-top: 15px;">
        <input class="hidden" id="userId" value="${param.id}">
        <div class="form-group">
            <label class="col-md-3 control-label">User name</label>
            <div class="col-md-4">
                <input id="name" class="form-control front-no-radius front-no-box-shadow" value="${param.name}"  type="text" placeholder="登录用户名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Tel No.</label>
            <div class="col-md-4">
                <input id="telephone" class="form-control front-no-radius front-no-box-shadow"  value="${param.telephone}" type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Password</label>
            <div class="col-md-4">
                <input id="password" class="form-control front-no-radius front-no-box-shadow" value="${param.password}" type="text">
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
        var userId = $('#userId').val();
        if ($("#telephone").val().trim().length == 0) {
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'Please input telephone number！'});
        } else if ($("#name").val().length == 0) {
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'Please input user name！'});
        } else if ($("#password").val().length == 0) {
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'Please input user name and password！'});
        } else {
            $.ajax({
                url: 'account/update',
                type: 'GET',
                data: {
                    "userId":userId,
                    "tel":$("#telephone").val(),
                    "name":$("#name").val(),
                    "psw":$("#password").val(),
                },
                success: function (data) {
                    if (data.code==200) {
                        $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'Save success！'});
                        window.location.reload();
                    } else {
                        $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'Add failure！'});
                    }
                }
            })
        }
    }
</script>