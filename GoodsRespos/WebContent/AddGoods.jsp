<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库存物资管理系统</title>
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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  
  <body>

    <!-- 最上面的导航栏 -->
  	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          </button>
          <a class="navbar-brand" href="index.jsp">库存物资管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
             <li><a href="GoodsRespForQuery.do?page=1">商品仓库</a></li>
             <li><a href="InRespoRecord.do?page=1">入库记录</a></li>
             <li><a href="OutRespoRecord.do?page=1">出库记录</a></li>
            <li><a href="AddGoods.jsp">我要入库</a></li>
            <li><a href="ShowTime.do">出入库商品数量按日期统计</a></li>
          </ul> 
        </div>
      </div>
    </nav><br><br><br>
    
    <div class="alert alert-danger" role="alert">
        <strong>你必须要注意的：</strong> 每个ID对应唯一一个商品，如果添加ID相同的商品，
        		只会在num(数量)上增加，而不会添加任何商品，但入库仍有记录.ID不能为空，为空将会报错.date必须按照20171020这种格式，否则报错
    </div>
    <c:if test="${not empty requestScope.msg }">
		<div class="alert alert-info" role="alert"><h4>
		<c:out value="${requestScope.msg }"></c:out>
		</h4></div> 
	</c:if>
	
    <div class="center-block" style="width:400px;">
	<form action="AddGoods.do" method = "post">
		<h2 class="form-signin-heading">Add Goods</h2>
		<table>
			
			<tr>
				<td>ID:</td>
				<td><input type = "text" name = "id" class = "form-control" value = "${param.id }"></td>
			</tr>
			
			<tr>
				<td>GoodsName:</td>
				<td><input type = "text" name = "goodsName" class = "form-control" value = "${param.goodsName }"></td>
			</tr>
			
			<tr>
				<td>Manf:</td>
				<td><input type = "text" name = "manf" class = "form-control" value = "${param.manf }"></td>
			</tr>
			
			<tr>
				<td>Version:</td>
				<td><input type = "text" name = "version" class = "form-control" value = "${param.version }"></td>
			</tr>
			
			<tr>
				<td>Num:</td>
				<td><input type = "text" name = "num" class = "form-control" value = "${param.num }"></td>
			</tr>
			
			<tr>
				<td>DateTime:</td>
				<td><input type = "text" name = "dateTime" class = "form-control" value = "${param.dateTime }"></td>
			</tr>
			
			<tr>
				<td>InCompany:</td>
				<td><input type = "text" name = "company" class = "form-control" value = "${param.company }"></td>
			</tr>
			
			<tr>
				<td>name:</td>
				<td><input type = "text" name = "name" class = "form-control" value = "${param.name }"></td>
			</tr>
			
			<tr>
				<td><input type = "submit" value = "Add" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	</div><br><br>
    
    
  </body>
</html>


