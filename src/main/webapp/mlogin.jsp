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
<title>地域取票系统管理登録画面</title>
<s:head />
<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/mlogin.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" /> 

</head>
<body>


<div class="title" align="center">地域取票系统管理登録画面</div>

<div class="search" align="center">
<s:textfield id="password" label="Password" name="password" size="20" style="font-size:1.0em;"/>
</div>
<div class="result" align="center">
	<s:if test="errMsg!=null">
	  <s:property value="errMsg" />
	</s:if>
</div>
<br/>
<br/>
<div align="center">
<s:form id="form" method="post" action='mlogin'>
  <s:hidden id="hidpwd" name="hidpwd"></s:hidden>
  <a href="#0" class="" onclick="MLogin()">
	 <div class="linkbtn">登録</div>
	</a>
</s:form>
</div>




</body>
</html>