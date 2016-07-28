<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>区域内优惠券发行终端——一览页面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/mview.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
html, body {
	margin: 0px;
	height: 100%;
}

.tab_cover {
	padding-bottom: 0px;
	margin-bottom: 0px;
}

.mlist {
	margin-top: 50px;
	overflow-y: scroll;
	height: 71.5%;
}

.flt {
	position: absolute;
	width: 90%;
	top: 110px;
	left: 5%;
}
</style>
</head>
<body class="text-center">
	<div class="container-fluid flt">
		<table class="table tab_cover">
			<tr bgcolor=rgb(187,187,187)>
				<td style="width: 33%; border: 1px solid rgb(221, 221, 221);">IP地址</td>
				<td style="width: 33%; border: 1px solid rgb(221, 221, 221);">取票时间</td>
				<td style="width: 33%; border: 1px solid rgb(221, 221, 221);">优惠码</td>
				<td style="width: 10px; border: 1px solid white"
					bgcolor=rgb(255,255,255)></td>
			</tr>
		</table>
	</div>
	<div class="container-fluid" style="width: 90%; height: 100%">
		<h1>一 览 页 面</h1>
		<div class="mlist">
			<table class="table table-bordered table-hover">
				<tr>
					<td>IP地址</td>
					<td>取票时间</td>
					<td>优惠码</td>
				</tr>
					<s:iterator value="ipMap" id="colum">
					<tr>
						<td style="width: 33.33%"><s:property value="value.ip" /></td>
						<td style="width: 33.33%" class="hidDatetime"><s:property
								value="value.datetime" /></td>						
						<td style="width: 33.33%"><s:property value="value.kbcode" /></td>
						<s:hidden name="value.datetime" />
					</tr>
				</s:iterator>
			</table>
		</div>
		<label style="font-size: 20px; margin-top: 10px;">
			剩余优惠券：
			<s:property value="masterPoint.ticket" />
			张
		</label>
		<div>
			<s:url var="mview" action="mview"></s:url>
			<s:a href="%{mview}">
				<button type="button" class="btn btn-primary btn-lg" id="refresh">刷新</button>
			</s:a>
			<s:url var="mview2master" action="mview2master"></s:url>
			<s:a href="%{mview2master}">
				<button type="button" class="btn btn-primary btn-lg">修改</button>
			</s:a>
		</div>
	</div>
</body>
</html>