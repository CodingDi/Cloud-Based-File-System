<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal-body" style="padding: 0px;">
    <div class="form-horizontal" style="width:100%;margin-top: 15px;">
        <div class="form-group">
            <label class="col-md-3 control-label">Enterprise Name</label>
            <div class="col-md-7">
                <input id="name" class="form-control front-no-radius front-no-box-shadow"  type="text" placeholder="企业名称">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Description</label>
            <div class="col-md-7">
                <textarea id="description" class="form-control front-no-radius front-no-box-shadow" type="text" placeholder="相关描述"/>
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
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'请填写企业名称！'});
      } else if ($("#description").val().length == 0) {
          $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'请填写企业描述！'});
      } else {
            $.ajax({
                url: "enterprise/add",
                type: 'post',
                data: {
                    "name":$("#name").val(),
                    "description":$("#description").val(),
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