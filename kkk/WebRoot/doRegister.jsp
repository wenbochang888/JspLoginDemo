<%@page import="com.dao.RegisterChecked"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import = "com.po.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>doRgister...</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
	
	<%
		 request.setCharacterEncoding("utf-8");
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
     	 Users users = new Users(username, password);
     	 
     	 boolean checked = RegisterChecked.isChecked(username, password);
     	 if (checked) {
			request.getRequestDispatcher("RegisterSuccess.jsp").forward(request, response);
     	 } else {
     	 	response.sendRedirect("RegisterFaile.jsp");
     	 }
	 %>
	
  </body>
</html>
