<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import = "com.dao.UsersDAO, com.po.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎你</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    
  <%
 	  String username = (String)session.getAttribute("username");
      UsersDAO ud = new UsersDAO();
      Users u =  ud.getInformation(username);
  %>
	  用户名：<%= u.getUsername() %><br>
	  密码： <%= u.getPassword() %><br>
	  学校：<%= u.getSchool() %><br>
	  性别：<%= u.getSex() %><br>
	  身高：<%= u.getHeight() %><br>
	  体重：<%= u.getWeight() %><br>
    
    
  </body>
</html>
