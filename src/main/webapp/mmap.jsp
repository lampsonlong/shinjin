<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>区域内优惠券发行终端——设定页面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=24d29189b1799e5a0f5358961f63616c&s=1" ></script>
<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/mmap.js"></script>
<script src="js/bootstrap.min.js"></script>


</head>
<body>
	<h1 align="center">设 定 页 面</h1>
	<div id="map" style="width:80%;height:400px;margin:0 auto;"></div>
	<div style="margin-top:20px;" align="center">
		<div class="form-inline">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<div class="form-group">
						<label style="font-size:20px;">区域中心</label>
						<input class="form-control" type="text" id="area_center" style="width:200px;font-size:20px;">
						<button class="btn btn-primary" onclick="PointSearch()" >检索</button><br>
					</div>
				</div>
			</div>
		</div>
		<form action="master" method="post" id="form_master" class="form-horizontal" >
			<input type="hidden" id="longitude" name="masterPoint.longitude" value="${requestScope.masterPoint.longitude}"/>
			<input type="hidden" id="latitude" name="masterPoint.latitude" value="${requestScope.masterPoint.latitude}"/>
			<div class="form-inline" style="margin-top:20px;">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<div class="form-group">
							<label style="font-size:20px;">区域半径</label>
							<div class="input-group">
			      				<input type="text" class="form-control" id="area_radius" name="masterPoint.radius" style="width:215px;font-size:20px;" value="${requestScope.masterPoint.radius}">
			      				<div class="input-group-addon">米</div>
			    			</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-inline" style="margin-top:20px;">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<div class="form-group">
							<label style="font-size:20px;">优惠券数</label>
							<div class="input-group">
			      				<input type="text" class="form-control" id="coupon_number" name="masterPoint.allTicket" style="width:215px;font-size:20px;" value="${requestScope.masterPoint.allTicket}">
			      				<div class="input-group-addon">张</div>
			    			</div>
						</div>
					</div>
				</div>
			</div>	
		</form>
		<label id="msg" style="color:#ff0000;"></label>
		<div class="row">
			<div class="col-md-4"></div>	
			<div class="col-md-4" style="margin-top:20px;">
				<s:url var="list" action="mview"></s:url>
				<button class="btn btn-primary btn-lg" onclick="FormSubmit()">设定</button>
				<s:a class="btn btn-primary btn-lg" href="%{list}" id="a_list"><button  type="button"  id="btn_list" class="btn btn-primary btn-lg" >一览</button></s:a>
			</div>
		</div>
	</div>	
</body>
</html>

