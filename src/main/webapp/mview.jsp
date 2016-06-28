<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>地域取票系统管理一覧画面</title>
<s:head />
<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/mview.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />

<script>
	
</script>

</head>
<body>


<div class="title" align="center">
<h1>区域内优惠券发行终端</h1>
<h2>—— 一览画面</h2>
</div>


<div class="result" align="center">
<table class="iplist">
  <thead>
    <tr>
	    <th>已获得优惠券IP</th>
	    <th>获得时间</th>
    </tr>
  </thead>
  <s:iterator value="ipMap" id="column">
  <tr>
    <td><s:property value="value.ip"/></td>
    <td><s:property value="value.datetime"/></td>
  </tr>
  </s:iterator>
</table>
	剩余优惠券：<s:property value="masterpoint.ticket" />张
</div>

<div align="center">
	<s:form id="form" method="post" action='mview'>
	</s:form>
</div>
	
<div class="buttonbar" align="center">
  <div class="button">
    <s:url action="mview" var="mview"></s:url>
    <a href="${mview}">刷 新</a>
  </div>
  
  <div class="button">
    <s:url action="mview2master" var="master"></s:url>
    <a href="${master}">修 改</a>
  </div>
</div>

</body>
</html>