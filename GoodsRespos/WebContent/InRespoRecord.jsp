<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
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
    </nav><br><br><br><br>
    
    <div class="center-block" style="width:400px;">
	<form action="InRespoRecord.do?page=1" method = "post">
		<h2 class="form-signin-heading">Please Query</h2>
		<table>
		
			<tr>
				<td>GoodsName:</td>
				<td><input type = "text" name = "goodsName" class = "form-control" value = "${param.goodsName }"></td>
			</tr>
			
			<tr>
				<td>DateTime:</td>
				<td><input type = "text" name = "dateTime" class = "form-control" value = "${param.dateTime }"></td>
			</tr>
			
			<tr>
				<td><input type = "submit" value = "Query" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	</div><br><br>
    
    <c:if test="${not empty requestScope.showInView }">
		<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-md-1">Id</th>
				<th class="col-md-2">GoodsName</th>
				<th class="col-md-2">Manuf</th>
				<th class="col-md-1">Version</th>
				<th class="col-md-1">Num</th>
				<th class="col-md-2">InTime</th>
				<th class="col-md-2">InCompany</th>
				<th class="col-md-2">InName</th>
			</tr>
			
			<c:forEach var="c" items="${requestScope.showInView }">
			
			<tr>
				<th>${c.id }</th>
				<th>${c.goodsName }</th>
				<th>${c.manuf }</th>
				<th>${c.version }</th>
				<th>${c.num }</th>
				<th>${c.inTime }</th>
				<th>${c.inCompany }</th>
				<th>${c.inName }</th>
			</tr>
			</c:forEach>
		</table>
	</c:if><br>
	
	<c:if test="${requestScope.number != 0}">
		<ul class = "pager">
		<li><a href = "InRespoRecord.do?page=1&goodsName=${param.goodsName }&dateTime=${param.dateTime }">首页</a></li>
		<c:forEach var="i" begin="1" end="${requestScope.number/5 + 1 }" step="1">
			<li><a href = "InRespoRecord.do?page=${i }&goodsName=${param.goodsName }&dateTime=${param.dateTime }">第${i }页</a></li>
		</c:forEach>
		<li><a href = "InRespoRecord.do?page=<fmt:formatNumber type="number" value="${requestScope.number/5 + 1 }" maxFractionDigits="0"/>&goodsName=${param.goodsName }&dateTime=${param.dateTime } ">末页</a><br><br><br></li></ul>
	</c:if>
    
  </body>
</html>

