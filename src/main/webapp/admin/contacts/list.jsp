
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
    <head>
        <title>会员信息列表</title>

        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="this is my page">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
       <script type="text/javascript">
       		function del(contactsNo) {
       			if(confirm('确定要删除该会员吗?')){
				$.post('${pageContext.request.contextPath}/admin/contacts/delete.action',{contactsNo:contactsNo},function(data){
					if(data.msg=='OK'){
						var a = $('#'+'contactsNo_'+contactsNo).parent().parent();
						console.info(a);
						a.remove();
						alert('删除成功');
					}else{
						alert('删除失败');
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
                <li>显示会员信息</li>
            </ul>
        </div>
        <br/>
        <a href="${pageContext.request.contextPath}/admin/contacts/save.jsp">添加会员</a>
        <div class="row" style="padding: 15px;">
            <table class="table ">
                <tr>
                   
                    <th>会员编号</th>
                    <th>会员姓名</th>
                   	<th colspan="2">操作</th>
                   
                </tr>

                <c:forEach items="${list}" var ="c" varStatus="v">
                    <tr>
                        <td>${c.contactsNo}</td>
                        <td>${c.contactsName}</td>
                  		<td><a href="${pageContext.request.contextPath}/admin/contacts/toupdate/${c.contactsNo}.action" >更新</a></td>
                  		<td><a id='contactsNo_${c.contactsNo}' href="#" onclick="del('${c.contactsNo}')">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
           
        </div>
    </body>
</html>
