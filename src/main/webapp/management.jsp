<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>区域内优惠券发行终端</title>

<script type="text/javascript" src="https://api.map.baidu.com/getscript?v=2.0&ak=24d29189b1799e5a0f5358961f63616c&services=&t=20160627141851" ></script>
<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/management.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css" /> 

<script>
</script>

</head>
<body>


<div class="title" align="center">
<h1>区域内优惠券发行终端</h1>
<h2>—— 设定画面</h2>
</div>



<div id="map" align="center"></div>

<div class="search" align="left">
区域中心：<input type="text" id="area" size="32" style="font-size:1.2em;" onblur="localSearch(this)" />&nbsp;&nbsp;<a href="javascript:void(0);" onclick="localSearch(this);">定位检索</a><br/>
区域半径：<input type="text" id="rad" size="10" maxlength="5" style="font-size:1.2em;" /> 米 <b id="radErr" class="inputErr"></b><br/>
优惠券数：<input type="text" id="tnum" size="10" maxlength="5" style="font-size:1.2em;" /> 张 <b id="tnumErr" class="inputErr"></b><br/>
</div>
<br/>
<br/>
<div align="center">
<s:form id="form" method="post" action='master'>
   <s:hidden id="latitude" name="masterpoint.latitude"></s:hidden>
   <s:hidden id="longitude" name="masterpoint.longitude"></s:hidden>
   <s:hidden id="ticket" name="masterpoint.ticket"></s:hidden>
   <s:hidden id="radius" name="masterpoint.radius"></s:hidden>
</s:form>
</div>

<div class="buttonbar" align="center">
	<div class="button">
		<a href="javascript:void(0);" onclick="setMasterPoint()">設 定</a>
	</div>
	

	<div class="button" id="viewDisplay" style="display:none">
		<s:url action="mview" var="mviewLink"></s:url>
		<a href="${mviewLink}">一 览</a>
	</div>
</div>

</body>
</html>