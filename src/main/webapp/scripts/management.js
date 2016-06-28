var map;
var point;
var marker;

$(function() {
	/*var lat = $("#latitude").val();
	var lng = $("#longitude").val();
	
	if(lat != "" && lng != ""){
		var reloadPoint = new BMap.Point(lat, lng);
		setPoint(reloadPoint);
	} else {
		initMap();
	}*/
	
	var lat = $("#latitude").val();
	var lng = $("#longitude").val();
	var tn = $("#ticket").val();
	var rad = $("#radius").val();
	
	if(lat != ""
		&& lng != ""
		&& tn != ""
		&& rad != ""){
		reloadMap(lng, lat, tn, rad);
	} else {
		initMap();
	}
});

function reloadMap(lng, lat, tn, rad){
	map = new BMap.Map('map');
	point = new BMap.Point(lng, lat);
	marker = new BMap.Marker(point);
	
	map.centerAndZoom(point, 19);
	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	
	marker.enableDragging();
	marker.addEventListener("dragend", function(e){
		point = e.point;
	});
	map.addOverlay(marker);
	
	$("#rad").val(rad);
	$("#tnum").val(tn);
	
	$("#viewDisplay").css("display","inline");
}

function initMap(){
	map = new BMap.Map('map');
	point = new BMap.Point(121.491, 31.233);
	marker = new BMap.Marker(point);
	
	map.centerAndZoom(point, 16);
	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	
	marker.enableDragging();
	marker.addEventListener("dragend", function(e){
		point = e.point;
	});
	map.addOverlay(marker);
}

function setPoint(p){
	map = new BMap.Map('map');
	point = p;
	marker = new BMap.Marker(point);
	
	map.centerAndZoom(point, 19);
	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	
	marker.enableDragging();
	marker.addEventListener("dragend", function(e){
		point = e.point;
		//alert("当前位置：" + point.lng + ", " + point.lat);
	});
	map.addOverlay(marker);
}

function localSearch(){
	var area = $("#area").val();
	
	var myGeo = new BMap.Geocoder();
	myGeo.getPoint(area, function(p){
		if (p) {
			setPoint(p);
		}
	}, "上海市");
}

function setMasterPoint(){
	var checkErr = false;
	var tnum = document.getElementById("tnum");
	if(!checkNum(tnum)){
		checkErr = true;
	} else {
		$("#ticket").val(tnum.value);
	}
	
	var radius = document.getElementById("rad");
	if(!checkNum(radius)){
		checkErr = true;
	} else {
		$("#radius").val(radius.value);
	}
	
	if(checkErr){
		return false;
	} else {
		
	}
	
	if(point != null && point != undefined){
		$("#latitude").val(point.lat);
		$("#longitude").val(point.lng);
		$("#form").submit();
	} else {
		alert("Please set destination on the map.")
	}
}

function checkNum(obj){
	var inputErr = $("#"+obj.id + "Err");
	if(isNaN(obj.value) || obj.value == ""){
		inputErr.text("请输入数字");
		obj.focus();
		return false;
	} else {
		inputErr.text("");
		return true;
	}
}

$(document).keypress(function(e) {  
// Enter key
   if(e.which == 13) {
	   setMasterPoint();
   }  
}); 