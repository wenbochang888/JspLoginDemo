<%@page import="com.po.Customer"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>高校学籍管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
	<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<script src="bootstrap/js/myjs.js"></script>
	<link href="bootstrap/css/mycss.css" rel="stylesheet">
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  </head>
  
  <body>
    <!-- 最上面的导航栏 -->
  	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          </button>
          <a class="navbar-brand" href="index.jsp">高校学籍管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="queryCustomerServlet.do">查询</a></li>
            <li><a href="add.jsp">添加</a></li>
          </ul> 
        </div>
      </div>
    </nav><br><br><br><br>
    
	<div class="center-block" style="width:400px;">
	<form action="queryCustomerServlet.do" method = "post">
		<h2 class="form-signin-heading">Please Query</h2>
		<table>
			<tr>
				<td>Sno:</td>
				<td><input type = "text" name = "sno" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("sno")%>"></td>
			</tr>
			
			<tr>
				<td>Sname:</td>
				<td><input type = "text" name = "sname" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("sname")%>"></td>
			</tr>
			
			<tr>
				<td>Phone:</td>
				<td><input type = "text" name = "phone" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("phone")%>"></td>
			</tr>
			<!-- addCustomerServlet.do -->
			<tr>
				<td><input type = "submit" value = "Query" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	</div>
	<br><br>
	
	
	<%
		List<Customer> customers = (List<Customer>) request.getAttribute("listCustomer");
	 	if (customers != null && customers.size() > 0) {
	 %>
		
		<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-md-3">Sno</th>
				<th class="col-md-3">Sname</th>
				<th class="col-md-2">Phone</th>
				<th class="col-md-3">Update/Delete</th>
			</tr>
			
			<%
				for (Customer c : customers) {
			 %>
			
			<tr>
				<th><%=c.getSno() %></th>
				<th><%=c.getSname() %></th>
				<th><%=c.getPhone() %></th>
				<th>
					<a href = "delete.do?sno=<%=c.getSno() %>" type="button" class="btn btn-primary" data-toggle="tooltip" data-placement="left" title="你确定要删除?">Delete</a>
					<a href = "edit.do?sno=<%=c.getSno() %>" type="button" class="btn btn-primary" data-toggle="tooltip" data-placement="right" title="你确定要修改?">Update</a>
				</th>
			</tr>
			
			<%} %>
		</table>
		
	<%} %>

  </body>
  
</html>
