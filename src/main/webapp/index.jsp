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
<title>地域取票系统</title>
<s:head />
<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/common.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" /> 

<script>
</script>

</head>
<body>
<!-- 
<h1>Hello <span id='username'></span></h1>
<p><a href="<s:url action='hello'/>">Hello World</a></p>
<s:url action="registerInput" var="registerInputLink" />
<p><a href="${registerInputLink}">Please register</a> for our prize drawing.</p>

<s:form action='hello'>

<s:textfield name="userName" label="Your name" />
   <s:submit value="Submit" />
</s:form>
 -->

<div class="title" align="center">地域取票系统</div>
<div align="center">
<s:form id="form1" method="post" action='gps'>
   <s:hidden id="accuracy" name="accuracy"></s:hidden>
   <s:hidden id="latitude" name="latitude"></s:hidden>
   <s:hidden id="longitude" name="longitude"></s:hidden>
   <s:hidden id="datetime" name="datetime"></s:hidden>
   <s:hidden id="timezone" name="timezone"></s:hidden>
   
<a href="#0" class="" onclick="GetGeolocation()">
<div class="linkbtn">
	取 票
</div>
</a>

</s:form>
</div>
<s:if test="position!=null">
<div class="result" align="left">
<ul>
<li>緯度：<s:property value="position.latitude" /></li>
<li>経度：<s:property value="position.longitude" /></li>
<li>取得時刻：<s:property value="position.datetime" /></li>
<li>Zone：<s:property value="position.timezone" /></li>
<li>距離：<s:property value="position.dst" /></li>
<li>IP：<s:property value="position.ip" /></li>
</s:if>
<ul>
</div>
</body>
</html>