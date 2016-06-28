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

<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/mlogin.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" /> 

</head>
<body>


<div class="title" align="center">
<h1>区域内优惠券发行终端</h1>
<h2>——登陆画面</h2>
</div>

<div class="search" align="center">
Password：<input type="password" id="password" size="20" style="font-size:1.0em;"/><br/>
 <s:if test="errMsg!=null">
   <b class="inputErr">无效的密码！</b>
 </s:if>
</div>
<br/>
<br/>
<div align="center">
<s:form id="form" method="post" action='mlogin'>
  <s:hidden id="hidpwd" name="hidpwd"></s:hidden>
</s:form>
</div>

  
<div class="buttonbar" align="center">
  <div class="button">
    <a href="javascript:void(0);" onclick="MLogin()">登 録</a>
  </div>
</div>


</body>
</html>