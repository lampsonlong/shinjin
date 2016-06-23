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
	
	initMap();
});

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
		//alert("当前位置：" + point.lng + ", " + point.lat);
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

function localSearch(dest){
	var myGeo = new BMap.Geocoder();
	myGeo.getPoint(dest, function(p){
		if (p) {
			setPoint(p);
		}
	}, "上海市");
}

function setMasterPoint(){
	if(point != null && point != undefined){
		$("#latitude").val(point.lat);
		$("#longitude").val(point.lng);
		$("#form").submit();
	} else {
		alert("地図に目的地フラグを立ってください。")
	}
}