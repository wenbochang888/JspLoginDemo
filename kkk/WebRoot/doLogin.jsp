<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import = "com.po.Users" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>loging...</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <%
        request.setCharacterEncoding("utf-8");
     	Users users = new Users(request.getParameter("username"), request.getParameter("password"));
     	if (users.usersLogin()) {
     		request.getRequestDispatcher("success.jsp").forward(request, response);
   	   	} else {
   		   response.sendRedirect("fail.jsp");
   	    }
     %>
  </body>
</html>





