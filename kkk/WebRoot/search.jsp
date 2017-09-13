<%@ page import="com.dao.SearchDAO"%>
<%@ page import="com.po.Content"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>searching</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    
    <%
    	request.setCharacterEncoding("utf-8");
    	String username = request.getParameter("search");
    	
    	Content content = SearchDAO.getInformation(username);
    	if (content != null) {	
    	%>
    	用户名：<%=content.getUsername()%><br>
    	密码： <%=content.getPassword() %><br>
    	学校: <%=content.getSchool() %><br>
    	性别： <%=content.getSex() %><br>
    	身高： <%=content.getHeight() %><br>
    	体重: <%=content.getWeight() %><br>
    	<% }
    	
    	if (content == null) {
    		out.print("没有此人，请重新输入");
    	}
    	%>
    	
    	
    
  </body>
</html>
