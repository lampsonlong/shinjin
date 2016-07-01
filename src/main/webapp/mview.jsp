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
<title>地域取票系统管理一覧画面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/mview.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	
</script>

</head>
<body>

<div class="container-fluid" align="center">
  <div class="page-header">
    <h1>区域内优惠券发行终端 </h1>
    <h1><small>——一览页面</small></h1>
  </div>

	<s:if test="ipMap != null">
	<div class="row">
	<div class="col-sm-offset-4 col-sm-4">
		<table class="table table-striped table-bordered">
		  <thead>
		    <tr>
		      <th>领取优惠券IP</th>
		      <th>领取时间</th>
		      <th>优惠券码</th>
		    </tr>
		  </thead>
		  
		  <tbody>
			  <s:iterator value="ipMap" id="column">
			  <tr>
			    <td><s:property value="value.ip"/></td>
			    <td class="dt"><s:hidden name="value.datetime"></s:hidden></td>
			    <td><s:property value="value.kbcode"/></td>
			    
			  </tr>
			  </s:iterator>
		  </tbody>
		</table>
	</div>
	</div>
	 </s:if>
	 <s:else>
	 目前还没有人领取优惠券哟~！
	 </s:else>
	 
	剩余优惠券：<s:property value="masterpoint.ticket" />张
	
	


	<form class="form-horizontal">
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-2">
	      <s:url action="mview" var="mview"></s:url>
	      <a class="btn btn-primary btn-lg btn-block" href="${mview}" role="button">刷 新</a>
	    </div>
	    <div class="col-sm-2">
	      <s:url action="mview2master" var="master"></s:url>
	      <a class="btn btn-primary btn-lg btn-block" href="${master}" role="button">修 改</a>
	    </div>
	  </div>
	</form>
	
	<s:form id="form" method="post" action='mview'>
	</s:form>

</div>
</body>
</html>