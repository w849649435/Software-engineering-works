<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <title>添加会员信息</title>

        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="this is my page">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
    </head>
    
    <script type="text/javascript">

function createMember() {
	$.post("${pageContext.request.contextPath}/admin/member/save.action",
	$("#new_jiaoshi_form").serialize(),function(data){
	        if(data.msg =="OK"){
	            alert("添加会员信息成功！");
	            window.location.reload();
	        }else{
	            alert("添加会员信息失败！");
	            window.location.reload();
	        }
	    });
	}
    </script>
    <body>

        <div style="padding: 0px; margin: 0px;">
            <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
                <li>会员管理</li>
				<li>显示全部会员信息</li>
				<li>添加会员信息</li>
            </ul>
        </div>

        <form  method="post" class="form-horizontal" id="new_jiaoshi_form"> 
            <h5 class="page-header alert-info"
                style="margin: 0px; padding: 10px; margin-bottom: 10px">会员基本信息</h5>
           
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">会员编号</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="memberid"
							 />
							
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户名</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="username"
							 />
							
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">标题</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="title"
							  />
					
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">邮件</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="email"
							 />
							
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">内容</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="context"
							/>
					
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">日期</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="magdate"
							 />
					
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">会员</label>
					<div class="col-sm-5">
						<select  class="form-control" id="rol" name="contactsNo" >						
							<c:forEach items="${list}" var ="con" >
								<option value="${con.contactsNo}">${con.contactsName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
            <div class="row">
                <div class="col-sm-10" align="center">
                    <input type="button" value="添加会员" class="btn btn-success"  onclick="createMember()"/> 
                    
                    <a
                        href="${pageContext.request.contextPath}/admin/member/list.action" class="btn btn-danger">返回上一级</a>
                </div>
            </div>
        </form>

    </body>
</html>
