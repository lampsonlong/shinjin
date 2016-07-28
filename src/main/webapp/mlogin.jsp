<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>区域内优惠券发行终端——登录页面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/mlogin.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
body{
	position: relative;
	width: 100%;
	margin-top: 5%;
}

.block {
	position: relative;
	width: 100%;
	margin-top: 8%;
}

.block_10px {
	position: relative;
	width: 100%;
	margin-top: 10px;
}

.block_50px {
	position: relative;
	width: 100%;
	margin-top: 50px;
}
</style>

</head>
<body>
	<div class="container-fluid">
		<h1 class="text-center">登 录 页 面</h1>
		<div class="block"></div>
		<s:form id="login_form" action="mlogin">
			<div class="row">
				<div class="col-xs-offset-4 col-xs-4">
					<label for="password" style="font-size: 20px">请输入密码:</label>
					<div class="block_10px"></div>
					<input id="password" name="password" class="form-control" type="password" /> 
					<label id="errMsg_label" style="position: relative; display: none; color: red">你的密码不正确!</label>
					<div class="row">
						<div class="col-md-offset-4 col-md-4" style="text-align: center">
							<br/>
							<button class="btn btn-primary btn-lg" onclick="OnSubmit()">登 录</button>
						</div>
						<s:hidden name="errMsg" id="errMsg_hidden" />
					</div>
				</div>
			</div>
		</s:form>
	</div>
</body>
</html>