

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>jQuery EasyUI CRUD Demo</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/js/jquery-easyui-1.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/js/jquery-easyui-1.5/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/js/jquery-easyui-1.5/demo/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery-easyui-1.5/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
	<style type="text/css">
		#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			color:#666;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
	</style>
	
	<script type="text/javascript">
		var url;
		function newContacts(){
			$('#dlg').dialog('open').dialog('setTitle','新建会员');
			$('#fm').form('clear');
			url = '${pageContext.request.contextPath}/admin/contacts/save.action';
		}
		function edit(){
			var row = $('#dg').datagrid('getSelected');
			
			if (row){
				$('#dlg').dialog('open').dialog('setTitle','编辑会员');
				$('#fm').form('load',row);
				url = '${pageContext.request.contextPath}/admin/contacts/update.action'
			}
		}
		function save(){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.msg=="OK"){
						$('#dlg').dialog('close');		
						$('#dg').datagrid('reload');	
					} else {
						$.messager.show({
							title: '出错了',
							msg: result.msg
						});
					}
				}
			});
		}
		function remove(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$.messager.confirm('确认对话框','确定要删除会员吗?',function(r){
					if (r){
						$.post('${pageContext.request.contextPath}/admin/contacts/delete.action',{contactsNo:row.contactsNo},function(result){
							if (result.msg=="OK"){
								$('#dg').datagrid('reload');	
							} else {
								$.messager.show({	
									title: '出错了',
									msg: result.msg
								});
							}
						},'json');
					}
				});
			}
		}
	</script>
</head>
<body>
	
	<div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		
	</div>
	
	<table id="dg" title="会员管理" class="easyui-datagrid" style="width:700px;height:400px"
			url="${pageContext.request.contextPath}/admin/contacts/getDataGrid.action"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="contactsNo" width="50">会员编号</th>
				<th field="contactsName" width="50">会员名称</th>	
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newContacts()">新建会员</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">编辑会员</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="remove()">删除会员</a>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons">
		<div class="ftitle">分类信息</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>会员编号:</label>
				<input name="contactsNo" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>会员名称:</label>
				<input name="contactsName" class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">保存(更新)</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</body>
</html>
