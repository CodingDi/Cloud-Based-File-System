<%--
  Created by IntelliJ IDEA.
  User: lizhenhao
  Date: 2017/7/30
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<%--<div class="panel panel-default front-panel">--%>
    <%--<div class="panel-body">--%>
        <%--<div class="col-md-3" style="text-align: center;"><span><strong><s:property value="enterpriseName"/></strong></span></div>--%>
        <%--<div class="col-md-3"><s:property value="enterpriseDescription"/></div>--%>
        <%--<div class="col-md-3"><s:property value="date"/></div>--%>
        <div style="height: 50px"><a style="float: right" class="btn btn-primary" data-toggle="front-modal" data-title="编辑企业"
               data-href="include/enterprise/modal_updateenterprise.jsp?name=<s:property value="enterpriseName"/>&id=<s:property value="#session.enterpriseId"/>&description=<s:property value="enterpriseDescription"/>" >修改企业名称</a>
        </div>
    <%--</div>--%>
<%--</div>--%>

        <div class="panel panel-default front-panel">
            <div class="panel-body">
                <div class="col-md-3" style="text-align: center;"><span><strong>Change Logo</strong></span></div>
                <div class="col-md-6"><img id="LOGO_LANDING" src="<s:property value="landingLogoPath"/>" onerror="javascript:this.src='img/002.png'"style="height: 30px;width: 250px;"></div>
                <div class="col-md-3">
                    <input class="LOGO_LANDING" type="file" name="file" >
                    <input id="landLogoId" value="<s:property value="landingId"/>" hidden>
                </div>
            </div>
        </div>
        <div class="panel panel-default front-panel">
            <div class="panel-body">
                <div class="col-md-3" style="text-align: center;"><span><strong>Change Banner</strong></span></div>
                <div class="col-md-6"><img id="BANNER" src="<s:property value="bannerLogoPath"/>" onerror="javascript:this.src='img/002.png'" style="height: 80px;width: 250px;"></div>
                <div class="col-md-3">
                    <input class="BANNER" type="file" name="file" >
                    <input id="bannerLogoId" value="<s:property value="bannerId"/>" hidden>
                </div>
            </div>
        </div>
        <div class="panel panel-default front-panel">
            <div class="panel-body">
                <div class="col-md-3" style="text-align: center;"><span><strong>Change Inner Logo</strong></span></div>
                <div class="col-md-6"><img id="LOGO_INNER" src="<s:property value="innerLogoPath"/>"  onerror="javascript:this.src='img/logo.png'" style="height: 30px;width: 250px;"></div>
                <div class="col-md-3">
                    <input class="LOGO_INNER" type="file" name="file" >
                    <input id="innerLogoId" value="<s:property value="innerId"/>" hidden>
                </div>
            </div>
        </div>
<script>
    $(':file').on("change", function () {
        $.showLoading('show');
        var type = $(this).attr("class");
        var file = this.files[0];
        var formData = new FormData();
        formData.append("filename", file.name);
        formData.append("file", file);
        formData.append("type", type);
        if(type == "LOGO_LANDING") formData.append("id",$('#landLogoId').val())
        else if(type == "LOGO_INNER") formData.append("id",$('#innerLogoId').val())
        else if(type == "BANNER") formData.append("id",$('#bannerLogoId').val())

        $.ajax({
            url: "logo/uploadLogo",
            type: "POST",
            enctype: "multipart/form-data",
            data: formData,
            processData: false,
            contentType: false,
//            dataType: "json",
            success: function (data) {
                $.showLoading('reset');
                console.log(data);
                console.log(type);

                $('#' + type).attr("src", data.relativePath);
//                $('#LOGO_LANDING').attr("src", "");

            }
        });
    })
</script>