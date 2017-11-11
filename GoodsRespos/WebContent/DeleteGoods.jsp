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
        <strong>你必须要注意的：</strong> 仓库中每件商品的num(数量)是固定的，
                                                你不能出库的num大于在仓库中的num,date必须按照20171020这种格式，否则报错
    </div>
    <c:if test="${not empty requestScope.msg }">
		<div class="alert alert-info" role="alert"><h4>
		<c:out value="${requestScope.msg }"></c:out>
		</h4></div> 
	</c:if>
	
    <div class="center-block" style="width:400px;">
	<form action="DeleteGoods.do" method = "post">
		<h2 class="form-signin-heading">Out Goods</h2>
		<table>
			
			<tr>
				<td>ID:</td>
				<td><p class = "form-control"><strong>${param.id }</strong></td>
				<td><input type = "hidden" name = "id" value = "${param.id }"></td>
			</tr>
			
			<tr>
				<td>GoodsName:</td>
				<td><p class = "form-control"><strong>${param.goodsName }</strong></td>
				<td><input type = "hidden" name = "goodsName" value = "${param.goodsName }"></td>
			</tr>
			
			<tr>
				<td>Manuf:</td>
				<td><p class = "form-control"><strong>${param.manuf }</strong></td>
				<td><input type = "hidden" name = "manuf" value = "${param.manuf }"></td>
			</tr>
			
			<tr>
				<td>Version:</td>
				<td><p class = "form-control" ><strong>${param.version }</strong></td>
				<td><input type = "hidden" name = "version" value = "${param.version }"></td>
			</tr>
			
			<tr>
				<td>Num:</td>
				<td><input type = "text" name = "num" class = "form-control" value = "you must <= ${param.num }"></td>
				<td><input type = "hidden" name = "oldNum" value = "${param.num }"></td>
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
				<td><input type = "submit" value = "Out" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	</div><br><br>
    
    
  </body>
</html>


