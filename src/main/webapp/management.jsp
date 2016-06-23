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
<title>地域取票系统管理画面</title>
<s:head />
<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/management.js"></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=24d29189b1799e5a0f5358961f63616c" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" /> 

<script>
</script>

</head>
<body>


<div class="title" align="center">地域取票系统管理画面</div>


<div class="result" align="center">
<s:if test="message!=null">
  <s:property value="message" />
</s:if>
</div>
<div id="map" align="center" style="width:500px;height:320px"></div>

<div class="search" align="center">
目的地座標検索：<input type="text" size="32" style="font-size:1.2em;" onblur="localSearch(this.value)" />
</div>
<br/>
<br/>
<div align="center">
<s:form id="form" method="post" action='master'>
   <s:hidden id="latitude" name="latitude"></s:hidden>
   <s:hidden id="longitude" name="longitude"></s:hidden>
<a href="#0" class="" onclick="setMasterPoint()">
<div class="linkbtn">目的地座標設定</div>
</a>

</s:form>
</div>



</body>
</html>