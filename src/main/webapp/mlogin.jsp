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
<title>区域内优惠券发行终端</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/mlogin.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>

<div class="container-fluid" align="center">
	<div style="margin:5em 0;">
		<h1>区域内优惠券发行终端 </h1>
		<h1><small>——登陆画面</small></h1>
	</div>

	<form class="form-horizontal">
	  <div class="form-group" id="pwdInput">
	    <label for="password" class="col-sm-offset-2 col-sm-2 control-label">密码</label>
	    <div class="col-sm-4">
	      <input type="password" class="form-control" id="password" placeholder="密码">
	    </div>
	     <s:if test="errMsg!=null">
			   <label for="passwordError" class="col-sm-2 control-label">无效的密码！</label>
			 </s:if>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-4">
	      <a class="btn btn-primary btn-lg btn-block" href="javascript:void(0);" onclick="MLogin()" role="button">登 録</a>
	    </div>
	  </div>
	</form>

	<s:form id="form" method="post" action='mlogin'>
	  <s:hidden id="hidpwd" name="hidpwd"></s:hidden>
	  <s:hidden id="hidErrMsg" name="errMsg"></s:hidden>
	</s:form>
</div>
</body>
</html>