
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>会员信息列表</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function checkAll() {
		var d = $("input:checkbox[name='ck']");
		$.each(d, function(i, n) {
			n.checked = !n.checked;
		})
	}

	function updateJiaoshi() {
		var ck = document.getElementsByName("ck");
		var s = 0;
		var v = "";
		for (var i = 0; i < ck.length; i++) {
			if (ck[i].checked) {
				v = ck[i].value;
				s++;
			}
		}
		if (s != 1) {
			alert("只能一次修改一个 请重新选择！");
		} else {
			console.info(v);
			window.location.href = "${pageContext.request.contextPath}/admin/member/toupdate/"+v+".action";
		}
	}

	function deleteMember() {
		var ck = document.getElementsByName("ck");
		var tr = $("input:checked").parent().parent();
		var s = "";
		for (var i = 0; i < ck.length; i++) {
			if (ck[i].checked) {
				s += ck[i].value + ",";
			}
		}
		console.info(s);
		if (s == "") {
			alert("请至少选择一个被删除的会员");
			return;
		}
		if (confirm('确实要删除该会员吗?')) {
			$.ajax({
						type : "post",
						url : "${pageContext.request.contextPath}/admin/member/deleteBatch.action",
						dataType : "json",
						data : {
							"ids" : s
						},
						success : function(data) {

							if (data.msg == "OK") {
								alert("会员删除成功！");
								tr.remove();
								
							} else {
								alert("会员删除失败！");
								
							}
						}
					});
		}
	}
</script>

</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">

			<li>会员管理</li>
			<li>显示全部会员信息</li>

		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath}/admin/member/list.action"
		method="post" id="f1" class="form-inline">
		<div class="row alert alert-info form-inline"
			style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<input type="text" class="form-control"
					name="keyword" placeholder="请输入用户姓名" />
			</div>
			<input type="submit" value="查询会员" class="btn btn-success" /> <a
				href="${pageContext.request.contextPath}/admin/member/tosave.action"
				class="btn btn-info">添加会员</a> <input type="button" id="upd"
				value="修改会员" class="btn btn-info" onclick="updateJiaoshi()" /> <input
				type="button" id="del" value="删除会员" class="btn btn-danger"
				onclick="deleteMember()" /> <a
				href="${pageContext.request.contextPath}/admin/member/upload.jsp"
				class="btn btn-info">导入会员</a> <a
				href="${pageContext.request.contextPath}/admin/member/exportExcel.action"
				class="btn btn-info">导出会员</a>

		</div>
	</form>
	<div class="row" style="padding: 15px;">
		<table class="table ">
			<tr>
				<th><input type="checkbox" onclick="checkAll()" /></th>
				<th>会员编号</th>
               		<th>用户名</th>
               		<th>标题</th>
			   		<th>邮件</th>
               		<th>内容</th>
               		<th>日期</th>
               		<th>会员编号</th>
               		<th>会员姓名</th>
			</tr>

			<c:forEach items="${pageInfo.list}" var="s" varStatus="v">
				<tr>
					<td><input type="checkbox" id="ids" class="bianhao" name="ck"
						value="${s.memberid}"></td>

					 <td>
                        ${s.memberid}
                    </td>
                    <td>
                        ${s.username}
                    </td>
                    <td>
                        ${s.title}
                    </td>
                    <td>
                        ${s.email}
                    </td>
                    <td>
                        ${s.context}
                    </td>
                    <td>
                        ${s.magdate}
                    </td>
                    <td>
                        ${s.contactsNo}
                    </td>
                    <td>
                        ${s.contactsName}
                    </td>
				</tr>

			</c:forEach>
		</table>
		<nav class="navbar navbar-default navbar-fixed-bottom">
			<ul class="pagination">
				<li><a
					href="?keyword=${keyword}&pageNum=${pageInfo.pageNum-1 }"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach var="i" begin="1" end="${pageInfo.pages}" step="1">
					<li><a
						href="?keyword=${keyword}&pageNum=${i}">${i}</a></li>
				</c:forEach>
				<li><a
					href="?keyword=${keyword}&pageNum=${pageInfo.pageNum+1 }"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>
