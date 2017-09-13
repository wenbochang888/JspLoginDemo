<%@page import="com.dao.ContentDAO"%>
<%@page import="com.util.DBHelper"%>
<%@page import="com.po.Content"%>
<%@ page language="java" import="java.util.*, java.sql.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="style/All.css">
  
    <base href="<%=basePath%>">
    <title>This is the title</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  

  <body>
  	<a class = "rightCornerLogin" href = "Login.jsp">登录</a>
  	<a class = "rightCornerRegister" href = "register.jsp">注册</a>
  	<form class = "search" action = "search.jsp" method = "post">
  		<p class = "p">搜索一下，你就知道<br/><br/></p>
		<input type = "text" name = "search">
		<input type = "submit" value = "search">
    </form>
    
    
    <%
    	ContentDAO contentDAO = new ContentDAO();
    	ArrayList<Content> list = contentDAO.getInformation();
     %>
     
    <p class = "tips">//从数据库中取数据，注意观察注册完后的变化</p>
    <p class = "content">
            热门内容:<br><br>
    <%
    	for (int i = 0; i<list.size(); i++) {
    	String username = list.get(i).getUsername();
    	%><%=i+1 + "   "%>
	 用户名 ：<a href = "search.jsp?search=<%=username %> "><%=username %></a>&nbsp;&nbsp;
	 密码： <%=list.get(i).getPassword() %><br>
    <% 
    	}
     %>
     </p>
  </body>
</html>







