<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    
    <h2 class = "center-block" style="width:300px;"><strong>出库商品日期记录</strong></h2>
	<div>
	<h3>按年统计</h3>
	<c:if test="${not empty requestScope.yearTime }">
     	<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-sm-1">Year</th>
				<th class="col-sm-1">Num(数量)</th>
			</tr>
			<c:forEach var="s" items="${requestScope.yearTime }">
				<tr>
					<th>${s.year }</th>
			    	<th>${s.num }</th>
			    </tr>
			</c:forEach>
		</table>
	 </c:if>
	</div>
	
	<div>
	<h3>按月统计</h3>
	<c:if test="${not empty requestScope.monthTime }">
     	<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-sm-1">Month</th>
				<th class="col-sm-1">Num(数量)</th>
			</tr>
			<c:forEach var="s" items="${requestScope.monthTime}">
				<tr>
					<th>${s.month }</th>
			    	<th>${s.num }</th>
			    </tr>
			</c:forEach>
		</table>
	 </c:if>
	</div>
	
	<div>
	<h3>按日统计</h3>
	<c:if test="${not empty requestScope.dayTime }">
     	<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-sm-1">Day</th>
				<th class="col-sm-1">Num(数量)</th>
			</tr>
			<c:forEach var="s" items="${requestScope.dayTime}">
				<tr>
					<th>${s.day }</th>
			    	<th>${s.num }</th>
			    </tr>
			</c:forEach>
		</table>
	 </c:if>
	</div><br><br>
	
	<h2 class = "center-block" style="width:300px;"><strong>入库商品日期记录</strong></h2>
	<div>
	<h3>按年统计</h3>
	<c:if test="${not empty requestScope.yearInTime }">
     	<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-sm-1">Year</th>
				<th class="col-sm-1">Num(数量)</th>
			</tr>
			<c:forEach var="s" items="${requestScope.yearInTime }">
				<tr>
					<th>${s.year }</th>
			    	<th>${s.num }</th>
			    </tr>
			</c:forEach>
		</table>
	 </c:if>
	</div>
	
	<div>
	<h3>按月统计</h3>
	<c:if test="${not empty requestScope.monthInTime }">
     	<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-sm-1">Month</th>
				<th class="col-sm-1">Num(数量)</th>
			</tr>
			<c:forEach var="s" items="${requestScope.monthInTime}">
				<tr>
					<th>${s.month }</th>
			    	<th>${s.num }</th>
			    </tr>
			</c:forEach>
		</table>
	 </c:if>
	</div>
	
	<div>
	<h3>按日统计</h3>
	<c:if test="${not empty requestScope.dayInTime }">
     	<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-sm-1">Day</th>
				<th class="col-sm-1">Num(数量)</th>
			</tr>
			<c:forEach var="s" items="${requestScope.dayInTime}">
				<tr>
					<th>${s.day }</th>
			    	<th>${s.num }</th>
			    </tr>
			</c:forEach>
		</table>
	 </c:if>
	</div>
		
  </body>
</html>
