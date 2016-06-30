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

<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=24d29189b1799e5a0f5358961f63616c&s=1" ></script>
<script type="text/javascript" src="scripts/json2.js"></script>
<script type="text/javascript" src="scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="scripts/mmap.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>

<div class="container-fluid" align="center">
  <div class="page-header">
    <h1>区域内优惠券发行终端</h1>
    <h1><small>——设定页面</small></h1>
  </div>
  
  <div class="well" id="map" style="width:90%;margin-bottom:2em;"></div>
  
    <form class="form-horizontal">
    
    <div class="form-group" id="areaInput">
		  <label for="area" class="col-sm-offset-2 col-sm-2 control-label">区域中心</label>
		  <div class="col-sm-4">
		    <div class="input-group">
		      <input type="text" class="form-control" id="area" placeholder="地名" onblur="localSearch(this);">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" type="button">检索</button>
		      </span>
		    </div>
		  </div>
    </div>
    
    <div class="form-group" id="radInput">
      <label for="rad" class="col-sm-offset-2 col-sm-2 control-label">区域半径</label>
	    <div class="col-sm-4">
		    <div class="input-group">
				  <input type="text" class="form-control" id="rad" placeholder="2000" maxlength="6" aria-describedby="basic-addon2">
				  <span class="input-group-addon" id="basic-addon2">米</span>
		    </div>
			</div>
      <div class="col-sm-1">
        <label for="rad" class="control-label inputErr text-left text-danger" id="radErr"></label>
      </div>
		</div>
		
		<div class="form-group" id="areaInput">
      <label for="tnum" class="col-sm-offset-2 col-sm-2 control-label">优惠券数</label>
      <div class="col-sm-4">
        <div class="input-group">
          <input type="text" class="form-control" id="tnum" placeholder="50" maxlength="5" aria-describedby="basic-addon3">
          <span class="input-group-addon" id="basic-addon3">张  </span>
        </div>
      </div>
      <div class="col-sm-1">
        <label for="tnum" class="control-label inputErr text-left text-danger" id="tnumErr"></label>
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-sm-offset-4 col-sm-2">
        <a class="btn btn-primary btn-lg btn-block" href="javascript:void(0);" onclick="setMasterPoint()" role="button">設 定</a>
      </div>
      <div class="col-sm-2" id="viewDisplay" style="display:none">
        <s:url action="mview" var="mviewLink"></s:url>
        <a class="btn btn-primary btn-lg btn-block" href="${mviewLink}" role="button">一 览</a>
      </div>
    </div>
  </form>
  
</div>


<s:form id="form" method="post" action='master'>
   <s:hidden id="latitude" name="masterpoint.latitude"></s:hidden>
   <s:hidden id="longitude" name="masterpoint.longitude"></s:hidden>
   <s:hidden id="ticket" name="masterpoint.ticket"></s:hidden>
   <s:hidden id="allticket" name="masterpoint.allTicket"></s:hidden>
   <s:hidden id="radius" name="masterpoint.radius"></s:hidden>
</s:form>

</body>
</html>