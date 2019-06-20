
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
<title>日志信息列表</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">



<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<script
	src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

<script>
	$(function() {
		$("#startTime").datetimepicker({
			format : 'YYYY-MM-DD HH:mm',
			locale : moment.locale('zh-cn')
		});
		$("#endTime").datetimepicker({
			format : 'YYYY-MM-DD HH:mm',
			locale : moment.locale('zh-cn')
		});

	});
</script>


</head>

<body>


	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>管理</li>
			<li>日志管理</li>

		</ul>
	</div>
	<br/>
	<form action="${pageContext.request.contextPath}/admin/loginfo/listByPage.action" method="post">
		<div class="row">
			<div class="col-sm-8">
				<div class="form-group">
					<label class="col-sm-1 control-label">开始时间</label>
					<div class="col-sm-3">
						<input type='text' class="form-control" id='startTime'
							name="startTime" />
					</div>

					<label class="col-sm-1 control-label">结束时间</label>
					<div class="col-sm-3">
						<input type='text' class="form-control" id='endTime'
							name="endTime" />
					</div>
					<div class="col-sm-2">
						<input type="submit" value="查询" class="btn btn-success" />
					</div>
				</div>

			</div>
		</div>


	</form>

	<div class="row" style="padding: 15px;">
		<table class="table ">
			<tr>

				<th>用户Id</th>
                <th>姓名</th>
                <th>登陆时间</th>
                <th>登录IP</th>
                <th>登录设备</th>




			</tr>

			<c:forEach items="${pageInfo.list}" var="s" varStatus="v">
				<tr>


					<td>
                  ${s.userid}
                </td>
                <td>
                    ${s.user.userName}
                </td>
                <td>
                   ${s.logintime}
                </td>
                <td>
                   ${s.ip}
                </td>
				<td>
                   ${s.shebei}
                </td>


				</tr>

			</c:forEach>
		</table>
	</div>
	<p>
		当前 ${pageInfo.pageNum }页,总${pageInfo.pages } 页,总 ${pageInfo.total}
		条记录 <a href="?pageNum=${pageInfo.firstPage}&startTime=${startTime}&endTime=${endTime}">第一页</a>
		<c:if test="${pageInfo.hasPreviousPage }">
			<a href="?pageNum=${pageInfo.pageNum-1}&startTime=${startTime}&endTime=${endTime}">上一页</a>
		</c:if>

		<c:if test="${pageInfo.hasNextPage }">
			<a href="?pageNum=${pageInfo.pageNum+1}&startTime=${startTime}&endTime=${endTime}">下一页</a>
		</c:if>

		<a href="?pageNum=${pageInfo.lastPage}&startTime=${startTime}&endTime=${endTime}">最后页</a>
</body>
</html>
