<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
         <h1>用户注册</h1>
     <form action="servlet1" method="post">
              用户名：<input type="text" name="uname">
       <br><br>
             密码：<input type="password" name="upass">
       <br> <br>
             性别：<input type="radio" name="sex" value="男" checked="checked">男
           <input type="radio" name="sex" value="女">女
       <br> <br>
         年龄：<input type="text" name="age">
       <br> <br>
       <input type="reset" value="重置">
       <input type="submit" value="注册">
     </form> 
     
  </body>
</html>
