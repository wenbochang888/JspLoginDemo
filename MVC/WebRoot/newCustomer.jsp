<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newCustomer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
	
	<%
		Object msg = request.getAttribute("msg");
		if (msg != null) { %><br><br><% 
			out.println(msg);
		}%><hr><br><br>
	
	
	<form action="addCustomerServlet.do" method = "post">
		<table>
			<tr>
				<td>CustomerSno:</td>
				<td><input type = "text" name = "sno" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("sno")%>"></td>
			</tr>
			
			<tr>
				<td>CustomerSname:</td>
				<td><input type = "text" name = "sname" value = "<%=request.getParameter("sname") == null ? "" : request.getParameter("sname")%>"></td>
			</tr>
			
			<tr>
				<td>CustomerPhone:</td>
				<td><input type = "text" name = "phone" value = "<%=request.getParameter("phone") == null ? "" : request.getParameter("phone")%>"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value = "register" /></td>
				<td><a href = "queryCustomerServlet.do">return</a></td>
			</tr>
		</table>
	</form>


  </body>
</html>









