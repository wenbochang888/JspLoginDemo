<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import = "com.dao.UsersDAO" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>doLogin</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    
   <%
   	   request.setCharacterEncoding("utf-8");
       session.setAttribute("username", request.getParameter("username"));
       UsersDAO ud = new UsersDAO(request.getParameter("username"), request.getParameter("password"));
   	   if (ud.usersLogin()) {
   		   request.getRequestDispatcher("success.jsp").forward(request, response);
   	   } else {
   		   response.sendRedirect("fail.jsp");
   	   }
   %>
    
  </body>
</html>













