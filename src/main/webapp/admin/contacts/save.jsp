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



function createContacts() {
	$.post("${pageContext.request.contextPath}/admin/contacts/save.action",
	$("#new_contacts_form").serialize(),function(data){
	        if(data.msg =="OK"){
	            alert("会员创建成功！");
	            window.location.reload();
	        }else{
	            alert("会员创建失败！");
	            window.location.reload();
	        }
	    });
	}


    </script>
    <body>

        <div style="padding: 0px; margin: 0px;">
            <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
                <li>会员信息管理</li>
                <li>显示会员信息</li>
                <li>添加会员信息</li>
            </ul>
        </div>

        <form  method="post" class="form-horizontal" id="new_contacts_form"> 
            <h5 class="page-header alert-info"
                style="margin: 0px; padding: 10px; margin-bottom: 10px">会员基本信息</h5>
            <div class="row">
                <div class="col-sm-5">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">会员编号</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="contactsNo"
                                   placeholder="请在这里输入会员编号"    />
                        </div>
                    </div>
                </div>
                <div class="col-sm-5">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">会员名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="contactsName"
                                   placeholder="请在这里输入会员名称"   />
                        </div>
                    </div>
                </div>
               


            </div>


            <div class="row">
                <div class="col-sm-10" align="center">
                    <input type="button" value="添加会员" class="btn btn-success"  onclick="createContacts()"/> 
                    
                    <a
                        href="${pageContext.request.contextPath}/admin/contacts/list.action" class="btn btn-danger">返回上一级</a>
                </div>
            </div>
        </form>

    </body>
</html>
