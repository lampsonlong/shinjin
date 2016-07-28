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
<title>地域取票系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>

<div class="container-fluid" align="center">
  <div class="page-header">
    <h1>区域内优惠券发行终端</h1>
    <h1><small>——异常页面</small></h1>
  </div>
  
  <p><a href="<s:url action='index' />" >返回主页</a></p>
    <p>请与系统管理员联系。</p> 
    <h4>异常情报：<s:property value="exception" /> </h4>
</div>
</body>
</html>