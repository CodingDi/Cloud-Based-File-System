<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal-body" style="padding: 0px;">
    <input class="hidden" value="${param.id}" id="enterprise-id">
    <div class="form-horizontal" style="width:100%;margin-top: 15px;">
        <div class="form-group">
            <label class="col-md-3 control-label">Enterprise Name</label>
            <div class="col-md-7">
                <input id="name" class="form-control front-no-radius front-no-box-shadow"  value="${param.name}" type="text" placeholder="企业名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Description</label>
            <div class="col-md-7">
                <textarea id="description" class="form-control front-no-radius front-no-box-shadow"  value="${param.description}" type="text" placeholder="相关描述">${param.description}</textarea>
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
        var enterpriseId = $('#enterprise-id').val();
      if ($("#name").val().length == 0) {
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'请填写企业名称！'});
      } else if ($("#description").val().length == 0) {
          $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'请填写企业描述！'});
      } else {
            $.ajax({
                url: "enterprise/update",
                type: 'post',
                data: {
                    "enterpriseId":enterpriseId,
                    "name":$("#name").val(),
                    'description':$('#description').val()
                },
                success: function (data) {
                    if (data.code==200) {
                        $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'修改成功！'});
                        window.location.reload();
                    } else {
                        $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:data.message});
                    }
                }
            })
        }
    }
</script>