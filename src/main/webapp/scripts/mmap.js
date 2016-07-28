var map;
var marker;
var searchCompleteFlag;

$(document).ready(function(){
	WebInit();
});

function WebInit() {
	$("#area_center").focus();
	var lng = $("#longitude").val();
	var lat = $("#latitude").val();
	if(lng == "") {
		MapInit(121.4005,31.1722);
		$("#longitude").val("121.4005");
		$("#latitude").val("31.1722");
		$("#btn_list").attr("disabled", true);
		$("#a_list").removeAttr("href");
	} else {
		MapInit(lng, lat);
	}	
}

function MapInit(lng, lat) {
	map = new BMap.Map("map");    // 创建Map实例
	map.centerAndZoom(new BMap.Point(lng, lat), 14);  // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
	map.setCurrentCity("上海");          // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
	marker = new BMap.Marker(new BMap.Point(lng,lat));  // 创建标注
	map.addOverlay(marker);
	marker.enableDragging();
}

function FormSubmit() {
	var lng = marker.getPosition().lng;
	var lat = marker.getPosition().lat;
	$("#longitude").val(lng);
	$("#latitude").val(lat);
	var res = InputCheck();
	if(res == 1) {
		$("#form_master").submit();
	} else {
		return;
	}
}

function InputCheck() {
	var radius = $("#area_radius").val();
	var number = $("#coupon_number").val();
	var parnt1 = /^[1-9]\d*(\.\d+)?$/;
	if(radius == "") {
    	$("#msg_radius").html("区域半径不能为空");
    	return 0;
    }else if(!parnt1.exec(radius)){
        $("#msg_radius").html("区域半径仅可以输入大于0的数！");
        return 0;
    } else {
    	$("#msg_radius").html("");
    }
    var parnt2 = /^[0-9]*[1-9][0-9]*$/;
    if(number == "") {
    	$("#msg_number").html("优惠券数不能为空！");
    	return 0;
    }else if(!parnt2.exec(number)){
        $("#msg_number").html("优惠券数仅可以输入大于0的整数！");
        return 0;
    } else {
    	$("#msg_number").html("");
    }
    return 1;
}

function PointSearch() {
	var addr = $("#area_center").val();
	if(addr == "") {
		return
	}
	map = new BMap.Map("map");
	map.enableScrollWheelZoom(true);
	searchCompleteFlag = true;
	var options = {
			onSearchComplete: function(results){
				if(searchCompleteFlag){
					// 判断状态是否正确
					if (local.getStatus() == BMAP_STATUS_SUCCESS){
						var lng = results.getPoi(0).point.lng;
						var lat = results.getPoi(0).point.lat;
						$("#longitude").val(lng);
						$("#latitude").val(lat);
						map.centerAndZoom(new BMap.Point(lng,lat), 16);
						marker = new BMap.Marker(new BMap.Point(lng,lat));  // 创建标注
						map.addOverlay(marker);
						marker.enableDragging();
						searchCompleteFlag = false;
					}else{
						map.centerAndZoom(new BMap.Point(marker.getPosition().lng,marker.getPosition().lat), 16);
						marker = new BMap.Marker(new BMap.Point(marker.getPosition().lng,marker.getPosition().lat));  // 创建标注
						map.addOverlay(marker);
						marker.enableDragging();
						searchCompleteFlag = false;
					}
				}
			}
		};
	var local = new BMap.LocalSearch(map, options);
	local.search(addr);
}

function loadJScript() {
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = "http://api.map.baidu.com/api?v=2.0&ak=24d29189b1799e5a0f5358961f63616c&callback=init";
	document.body.appendChild(script);
}

window.onload = loadJScript;  //异步加载地图