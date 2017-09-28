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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
	
	<form action="queryCustomerServlet.do" method = "post">
		<table>
			<tr>
				<td>CustomerSno:</td>
				<td><input type = "text" name = "sno" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("sno")%>"></td>
			</tr>
			
			<tr>
				<td>CustomerSname:</td>
				<td><input type = "text" name = "sname" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("sname")%>"></td>
			</tr>
			
			<tr>
				<td>CustomerPhone:</td>
				<td><input type = "text" name = "phone" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("phone")%>"></td>
			</tr>
			<!-- addCustomerServlet.do -->
			<tr>
				<td><input type = "submit" value = "Query"></td>
				<td><a href = "newCustomer.jsp">Add New Customer</a></td>
			</tr>
		</table>
	</form>
	<br><br>
	
	
<!-- 我是分割线 -->


	<%
		List<Customer> customers = (List<Customer>) request.getAttribute("listCustomer");
	 	if (customers != null && customers.size() > 0) {
	 %>
		
		<hr><br><br>
		
		<table border="1" cellpadding="10" cellspacing="1">
			<tr>
				<th>Sno</th>
				<th>Sname</th>
				<th>Phone</th>
				<th>Update/Delete</th>
			</tr>
			
			<%
				for (Customer c : customers) {
			 %>
			
			<tr>
				<th><%=c.getSno() %></th>
				<th><%=c.getSname() %></th>
				<th><%=c.getPhone() %></th>
				<th>
					<a href = "edit.do?sno=<%=c.getSno() %>">Update</a>
					<a href = "delete.do?sno=<%=c.getSno() %>">Delete</a>
				</th>
			</tr>
			
			<%} %>
		</table>
		
	<%} %>

  </body>
</html>



