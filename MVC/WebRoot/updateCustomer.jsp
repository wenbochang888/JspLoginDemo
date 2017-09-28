<%@page import="com.po.Customer"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateCustomer.jsp' starting page</title>
    
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
    
    <%
    	Customer c = (Customer) request.getAttribute("customer");
     %>
    
    <form action="update.do" method = "post">
    	
    	<input type = "hidden" name = "oldSno" value = "<%=c.getSno() %>"></input>
    
		<table>
			<tr>
				<td>CustomerSno:</td>
				<td><input type = "text" name = "sno" value = "<%=c.getSno() %>"></td>
			</tr>
			
			<tr>
				<td>CustomerSname:</td>
				<td><input type = "text" name = "sname" value = "<%=c.getSname()%>"></td>
			</tr>
			
			<tr>
				<td>CustomerPhone:</td>
				<td><input type = "text" name = "phone" value = "<%=c.getPhone()%>"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value = "update" /></td>
				<td><a href = "queryCustomerServlet.do">return</a></td>
			</tr>
		</table>
	</form>
    
    
  </body>
</html>













