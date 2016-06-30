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
<script type="text/javascript" src="scripts/index.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>

<div class="container-fluid" align="center">
  <div style="margin:5em 0;">
    <h1>区域内优惠券取得终端 </h1>
  </div>
</div>

<div class="col-sm-offset-4 col-sm-4">
	<s:if test="position==null || position.kbcode==null">
	   <a class="btn btn-primary btn-lg btn-block" href="javascript:void(0);" onclick="GetGeolocation()" role="button">取 票</a>
	</s:if>
	<br/><br/><br/>
	   <ul class="list-unstyled">
	      <s:if test="errCode==1">
        <li>你已经领取过优惠券啦！不能贪心哟！</li>
        </s:if>
	      <s:if test="errCode==0">
			  <li>恭喜你获得了优惠券！</li>
			  </s:if>
			  <s:if test="errCode==-1">
        <li>非常抱歉！目前还没有可领取的优惠券！</li>
        </s:if>
        <s:if test="errCode==-2">
        <li>非常抱歉！优惠券已经领完了！下次请快哦！</li>
        </s:if>
        <s:if test="errCode==-3">
        <li>加油！再走<s:property value="position.dst" />公里就能领取到优惠券啦！</li>
        </s:if>
		    <s:if test="position.kbcode!=null">
			  <li>优惠码：<s:property value="position.kbcode" /></li>
			  <li>取得時刻：<s:property value="position.datetime" /></li>
			  </s:if>
		  </ul>
</div>

<s:form id="form1" method="post" action='gps'>
   <s:hidden id="accuracy" name="position.accuracy"></s:hidden>
   <s:hidden id="latitude" name="position.latitude"></s:hidden>
   <s:hidden id="longitude" name="position.longitude"></s:hidden>
</s:form>


</body>
</html>