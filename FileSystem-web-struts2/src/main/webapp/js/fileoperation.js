
//删除文件
function deleteFile(id,type) {
    $('#loading').show();
    $('#fileList').hide();
    $.ajax({
        type: "GET",
        url: "file/deleteFile",
        data: {
            'id':id,
            'type':type
        },
        error: function(){
            $.fillTipBox({type:'warning', icon:'glyphicon-exclamation-sign', content:'删除失败'})
        },
        success: function (data) {
            if (data.code==200) {
                $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'删除成功'})
                var operationType = $('#operation-type').val();
                switch (operationType) {
                    case "FILE_FIND":
                        getFile();
                        break;
                    case "FILE_SEARCH":
                        var keyword = $('#search-input').val();
                        window.location.href = "file/searchFile?keyword=" + keyword;
                        // window.location.reload();
                        break;
                }
            } else {
                $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'删除失败'})

            }
            console.log(data)
        }
    });
}

//重命名文件
function renameFile() {
    var fileName =$("#editfileName").text();
    var path = $("#path").text();
    var newName = $("#newFileName").val();
    var id = $("#id").text();

    $.ajax({
        type: "get",
        url: "renameFile",
        data: {
            currentPath: path,
            fileName: fileName,
            newName: newName,
            id:id,
        },
        error: function(){
            alert("重命名文件失败");
        },
        success: function (data) {
            if(data.statusCode != null||data.statusCode == "500") {
                alert(data.status)
            }
            else {
                $("#fileList").html(data);
                $(".modal").modal('hide');
            }
        }
    });
}



//上传文件
function upLoadFile(id) {
    var formData = new FormData();
    if(document.getElementById("textFile").files[0] != null) {
        formData.append("textFile", document.getElementById("textFile").files[0]);
    }
    if(document.getElementById("picFile").files[0] != null) {
        formData.append("picFile", document.getElementById("picFile").files[0]);
    }
    formData.append("eventId",$('#eventOption option:selected').val());
    formData.append("year",$('#year').val());
    formData.append("departmentId",$('#departmentOption option:selected').val());
    formData.append("fileName",$('#name').val())
    formData.append("id",id);
    $('#loading').show();
    $('#upload_show').hide();
    $.ajax({
        type: "post",
        url: "file/uploadFile",
        data:formData,
        contentType: false,
        processData: false,
        error: function(){
            $.fillTipBox({type:'warning', icon:'glyphicon-exclamation-sign', content:'上传文件出错'})
        },
        success: function (data) {
            if(data.errorCode == '200') {
                $.fillTipBox({type: 'success', icon: 'glyphicon-ok-sign', content: '上传文件成功'});
                setTimeout(function(){
                    window.location = 'home/index.jsp?menu=home';
                },1200)
            }
            else {
                $.fillTipBox({type:'warning', icon:'glyphicon-exclamation-sign', content:'上传文件出错'})
            }

        }
    });
}


//刷新文件名
function refreshFileName(obj) {
    var fileName = obj.files[0].name;
    console.log(fileName);
    var f = $('#name');
    console.log(f.val());
    if($("#name").val() == '') {
        $("#name").html(fileName);
        $("#name").val(fileName);
    }
}
//添加文件夹
function addDirectory() {

    var zTree = $.fn.zTree.getZTreeObj("dirTree");
    var nodes = zTree.getSelectedNodes();
    var treeNode = nodes[0];

    if (treeNode) {
        var path = $("#path").text();
        var fileName = $("#newDirName").val();
        var id = treeNode.id;
        $.ajax({
            type: "get",
            url: "creatDir",
            data: {
                currentPath: path,
                fileName: fileName,
                id:id,
            },
            error: function(){
                $.fillTipBox({type:'warning', icon:'glyphicon-exclamation-sign', content:'创建文件夹出错'})
                $(".modal").modal('hide');
            },
            success: function (data) {
                $.fillTipBox({type:'success', icon:'glyphicon-ok-sign', content:'创建文件夹成功'})
                treeNode = zTree.addNodes(treeNode, { id: data.newDirId, pId: treeNode.id, isParent: true, name: fileName,path:data.currentPath});
                console.log(data.newDirId);
                $("#id").html(data.newDirId);
                $(".modal").modal('hide');
            }
        });

    }

    else {
        $.fillTipBox({type:'warning', icon:'glyphicon-exclamation-sign', content:'请选中文件夹'})
    }



}