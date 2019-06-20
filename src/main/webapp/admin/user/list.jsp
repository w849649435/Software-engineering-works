<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>     
    </head>
    <body>
               
            <table class="table table-striped table-bordered" >
                <tr>
                   
                    <th>用户ID</th>
                    <th>姓名</th>
                    <th>Email</th>
                    <th>用户头像</th>
                    <th>用户类型</th>
                    <th>会员姓名</th> 
                </tr>
             
               <c:forEach items="${list}" var="user">
                <tr>
                    
                     <td>
                        ${user.userID}
                    </td>
                    <td>
                        ${user.userName}
                    </td>
                    <td>
                        ${user.email}
                    </td>
                    <td>
                 
                       <img src="${user.photo}" width="50px" height="50px"/>
                    </td>
                    <td>
                        <c:if test="${user.userType=='01'}">
                                                                                      管理员
                        </c:if>
                        <c:if test="${user.userType=='02'}">
                                                                                       普通用户
                        </c:if>
                        
                    </td>
                    <td>
                        ${user.contactsName}
                    </td>
                
                </tr>     
                </c:forEach>
              
                
            </table>
       
    </body>
</html>
