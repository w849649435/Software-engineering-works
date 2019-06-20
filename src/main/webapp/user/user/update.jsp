<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>修改</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function updateUser() {
		$.ajax({
		    type: 'POST',
		    url: '${pageContext.request.contextPath}/user/user/updateUser.action',
		    data: new FormData($("#update_user_form")[0]),
		    async : false,
		    cache : false,
		    contentType : false,
		    processData : false,
		    success : function(data) {
		    	if (data == "OK") {
					alert("修改成功！");
					window.location='${pageContext.request.contextPath}/user/user/toUpdateUser.action'; 
				} else {
					alert("修改失败！");
				}
		}});
	}
</script>
</head>
<body>
	<h3 class="title">修改用户信息</h3>
	
	<form id="update_user_form" method="post" enctype="multipart/form-data">
		<input type="text" id="userID" name="userID" value="${user.userID}" hidden="true"/>
		<div>
			<span>姓名:</span> <input type="text" id="userName" name="userName"
				value="${user.userName}">
		</div>
		<br/>
		<div>
			<span>邮箱:</span> <input type="text" id="email" name="email"
				value="${user.email}">
		</div>
		<br/>
		<div>
			<span>图片:</span><img id="pic" alt="照片" width="50" height="50" class="imgShow" src="${user.photo }" />		
			 <input  type="file" name="file" id="file"
				size="40" />
		</div>
		<br/>
		<div>
			<input type="submit" value="修改" onclick="updateUser()"/>
		</div>
	</form>
</body>

</html>