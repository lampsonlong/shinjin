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
<title>区域内优惠券取得终端</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/index.js"></script>
<script src="js/bootstrap.min.js"></script>

<style type="text/css">
body
{
	position:relative;
	width:100%;
	height:100%;
	margin-top:50px;
}

.index
{
	position:relative;
	width:100%;
	height:100%;
	margin-top:50px;
}

.block
{
	position:relative;
	width:100%;
	height:10px;
}
</style>
</head>

<body>
	<h1 class="text-center">抢  票 页 面</h1>
	<div class="index">
		<div class="row">
			<div class="col-md-offset-4 col-md-4" style="text-align:center">
				<s:form id="gps_form" action="gps" method="post">
					<button id="askForTK" class="btn btn-primary btn-lg" onclick="getLocation()" type="button">&nbsp;&nbsp;&nbsp;&nbsp;抢 票&nbsp;&nbsp;&nbsp;&nbsp;</button>
					<s:hidden id="position_latitude" name="position.latitude"/>
					<s:hidden id="position_longitude" name="position.longitude"/>
					<s:hidden id="ret" name="ret"/>
					<s:hidden id="position_dst" name="position.dst"/>
					<s:hidden id="kbcode" name="position.kbcode"/>
				</s:form>
				<img id="scansnap" src="./pic/kcode_success.jpg" height="65%" width="65%" style="display:none"/>
				<div class="block"></div>    
				<label ID="index_inform" style="display:none;color:red;font-size:105%"></label>
			</div>
		</div>
	</div>
</body>
</html>