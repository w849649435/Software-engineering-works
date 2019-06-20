
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
<title>课程信息列表</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>


</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">

			<li>教师管理</li>
			<li>显示教师信息</li>

		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath}/user/jiaoshi/listByPage.action"
		method="post" id="f1" class="form-inline">
		<div class="row alert alert-info form-inline"
			style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>课程号</label> <input type="text" class="form-control"
					name="keyword" placeholder="请输入教师姓名" />
			</div>
			<input type="submit" value="查询教师" class="btn btn-success" />

		</div>
	</form>
	<div class="row" style="padding: 15px;">
		<table class="table ">
			<tr>
				
				 	<th>教师编号</th>
               		<th>教师用户名</th>
               		<th>密码</th>
			   		<th>教师号</th>
               		<th>教师真实姓名</th>
               		<th>性别</th>
               		<th>生日</th>
               		<th>毕业院校</th>
               		<th>所学专业</th>
               		<th>电话</th>
               		<th>家庭住址</th>
               		<th>邮箱</th>
               		<th>用户身份</th>
               		<th>院系号</th>
               		<th>院系名</th>
			</tr>

			<c:forEach items="${pageInfo.list}" var="s" varStatus="v">
				<tr>

					 <td>
                        ${s.id}
                    </td>
                    <td>
                        ${s.name}
                    </td>
                    <td>
                        ${s.pwd}
                    </td>
                    <td>
                        ${s.jiaoshihao}
                    </td>
                    <td>
                        ${s.zhenming}
                    </td>
                    <td>
                        ${s.sex}
                    </td>
                    <td>
                        ${s.shengri}
                    </td>
                    <td>
                        ${s.yuanxiao}
                    </td>
                    <td>
                        ${s.zhuanye}
                    </td>
                    <td>
                        ${s.phone}
                    </td>
                    <td>
                        ${s.address}
                    </td>
                    <td>
                        ${s.email}
                    </td>
                    <td>
                        ${s.shenfen}
                    </td>
                    <td>
                        ${s.depId}
                    </td>
                    <td>
                        ${s.department.depName}
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
