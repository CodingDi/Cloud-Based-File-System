/**
 * 设置zTree树
 */
var setting = {
	async: {
		enable: true,
		url: getUrlByNodeId
	},
	check: {
		enable: false
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	view: {
		expandSpeed: ""
	},
	callback: {
		beforeExpand: beforeExpand,
		onAsyncSuccess: onAsyncSuccess,
		onAsyncError: onAsyncError,
		onClick: zTreeOnClick
	}
};

/**
 * 功能：通过NodeId获得节点的孩子节点
 * 调用：当父节点展开时，调用，返回该父节点的子节点
 * 后台数据格式：JSON
 * @param treeId 树控件的Id
 * @param treeNode 树节点对象：包含Id等信息
 * @return
 */
function getUrlByNodeId(treeId, treeNode) {
	return "directory/findAllDirectory?kind="+kind+"&type="+treeNode.type+"&pid="+treeNode.id;
}
/**
 * 展开之前执行的函数
 * @param treeId
 * @param treeNode
 * @return
 */
function beforeExpand(treeId, treeNode) {
	if (!treeNode.isAjaxing) {
		ajaxGetNodes(treeNode, "refresh");
		return true;
	} else {
		alert("Loading...");
		return false;
	}
}
/**
 * 加载成功后执行的函数
 * @param event 封装了js的事件
 * @param treeId 树控件的Id
 * @param treeNode 树节点对象
 * @param msg 返回的JSON格式的消息
 * @return
 */
function onAsyncSuccess(event, treeId, treeNode, msg) {
    console.log(msg);
	if (!msg || msg.length == 0) {
		return;
	}
	var zTree = $.fn.zTree.getZTreeObj("dirTree");
	treeNode.icon = "";
	zTree.updateNode(treeNode);//更新树结构
	zTree.selectNode(treeNode.children[0]);//设置为第一个子节点为选中状态
}
function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
	var zTree = $.fn.zTree.getZTreeObj("dirTree");
	alert("Error ! 异步获取数据异常");
	treeNode.icon = "";
	zTree.updateNode(treeNode);
}
function ajaxGetNodes(treeNode, reloadType) {
	var zTree = $.fn.zTree.getZTreeObj("dirTree");
	if (reloadType == "refresh") {
		treeNode.icon = "zTree/css/zTreeStyle/img/loading.gif";
		zTree.updateNode(treeNode);
	}
	zTree.reAsyncChildNodes(treeNode, reloadType, true);
}
/**
 * 功能：当点击树节点时，调用该函数
 * @param event
 * @param treeId
 * @param treeNode
 * @return
 */
function zTreeOnClick(event, treeId, treeNode) {
	var isParent = treeNode.isParent;
	// if (!isParent) {
	var zTree = $.fn.zTree.getZTreeObj("dirTree");
	var node = zTree.getSelectedNodes()[0]; //当前节点
	switch (kind) {
		case 0: //年度
			var fatherNode = node.getParentNode();  //父节点
			if (fatherNode == null) {
				eventId = null;
				year = node.name;
				departmentId = null;
			} else {
				var grandFatherNode = fatherNode.getParentNode();  //祖父节点
				if (grandFatherNode == null) {
					eventId = null;
					year = fatherNode.name;
					departmentId = node.id;
				} else {
					eventId = node.id;
					year = grandFatherNode.name;
					departmentId = fatherNode.id;
				}
			}
			break;
		case 1: //事件
			var fatherNode = node.getParentNode();  //父节点
			if (fatherNode == null) {
				eventId = node.id;
				year = null;
				departmentId = null;
			} else {
				var grandFatherNode = fatherNode.getParentNode();  //祖父节点
				if (grandFatherNode == null) {
					eventId = fatherNode.id;
					year = null;
					departmentId = node.id;
				} else {
					eventId = grandFatherNode.id;
					year = node.name;
					departmentId = fatherNode.id;
				}
			}
			break;
		case 2:  //部门
			var fatherNode = node.getParentNode();  //父节点
			if (fatherNode == null) {
				eventId = null;
				year = null;
				departmentId = node.id;
			} else {
				var grandFatherNode = fatherNode.getParentNode();  //祖父节点
				if (grandFatherNode == null) {
					eventId = null;
					year = node.name;
					departmentId = fatherNode.id;
				} else {
					year = fatherNode.name;
					eventId = node.id;
					departmentId = grandFatherNode.id;
				}
			}
			break;
	}
	getFile();
};

function getFile() {
	$.get("file/findFile", {
		'year':year,
		'eventId':eventId,
		'departmentId':departmentId
	}, function(data) {
		$('#fileList').html(data);
		$('#loading').hide();
		$('#fileList').show();
		// getPage(1);
	});
};

/**
 * 点击不同的一级标题获得数据
 */
function queryFirst(clickKind) {
	sortDirTree(clickKind);
	kind = clickKind;
	$.get("directory/findAllDirectory", {
		'kind':kind,
		'type':"INIT"
	}, function(data) {
		zNodes = JSON.parse(data);
		console.log(zNodes);
		$.fn.zTree.init($("#dirTree"), setting, zNodes);
	});
}

function sortDirTree(clickKind){
	switch (clickKind) {
		case 0: {
			$('#leftdirtree-sort-year').addClass('font-underline-bold');
			$('#leftdirtree-sort-event').removeClass('font-underline-bold');
			$('#leftdirtree-sort-topic').removeClass('font-underline-bold');
			break;
		}
		case 1: {
			$('#leftdirtree-sort-year').removeClass('font-underline-bold');
			$('#leftdirtree-sort-event').addClass('font-underline-bold');
			$('#leftdirtree-sort-topic').removeClass('font-underline-bold');
			break;
		}
		case 2: {
			$('#leftdirtree-sort-year').removeClass('font-underline-bold');
			$('#leftdirtree-sort-event').removeClass('font-underline-bold');
			$('#leftdirtree-sort-topic').addClass('font-underline-bold');
			break;
		}
		default :{
			$('#leftdirtree-sort-year').removeClass('font-underline-bold');
			$('#leftdirtree-sort-event').removeClass('font-underline-bold');
			$('#leftdirtree-sort-topic').removeClass('font-underline-bold');
			break;
		}
	}
}

