<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal-body" style="padding: 0px;">
    <div class="form-horizontal" style="width:100%;margin-top: 15px;">
        <div class="form-group">
            <label class="col-md-3 control-label">联系电话</label>
            <div class="col-md-4">
                <input id="telephone" class="form-control front-no-radius front-no-box-shadow"  type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">用户名</label>
            <div class="col-md-4">
                <input id="name" class="form-control front-no-radius front-no-box-shadow"  type="text" placeholder="登录用户名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">密码</label>
            <div class="col-md-4">
                <input id="password" class="form-control front-no-radius front-no-box-shadow" value="abc123" type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">所属企业</label>
            <div class="col-md-4" id="select-enterprise">

            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-default" data-dismiss="modal">取消</a>
        <button type="button" class="btn btn-primary" onclick="save()">保存</button>
    </div>
</div>
<script type="text/javascript">

    $(function () {
        var url="enterprise/findAllBySelect";
        $.get(url,function (data) {
            $('#select-enterprise').html(data);
        });
    });

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
                    "enterpriseId":$('#enterprise').val(),
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