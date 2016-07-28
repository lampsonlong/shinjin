var map;  //地图
var marker;  //地图上的标注
var searchCompleteFlag;	 //搜索结果flag

//页面加载时自动运行
$(document).ready(function(){
	WebInit();
});

//页面初始化函数
function WebInit() {
	$("#area_center").focus();  //设置焦点在区域中心输入框
	var lng = $("#longitude").val();
	var lat = $("#latitude").val();
	if(lng == "") {  //取不到经度数据时
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(ShowPosition);  //定位
		} else {
			$("#msg").innerHTML="该浏览器不支持获取地理位置。";
		}
	} else {
		MapInit(lng, lat);  //根据获取的经纬度值来初始化地图
	}	
}

function ShowPosition(position) {
	$("#latitude").val(position.coords.latitude);
	$("#longitude").val(position.coords.longitude);
	MapInit($("#longitude").val(),$("#latitude").val());
	$("#btn_list").attr("disabled", true);  //禁用一栏按钮
	$("#a_list").removeAttr("href");
}

//地图初始化
function MapInit(lng, lat) {
	map = new BMap.Map("map");    // 创建Map实例
	map.centerAndZoom(new BMap.Point(lng, lat), 14);  // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
	map.setCurrentCity("上海");          // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
	marker = new BMap.Marker(new BMap.Point(lng,lat));  // 创建标注
	map.addOverlay(marker);  //添加标注
	marker.enableDragging();  //设置标注可拖动
}

//提交表单
function FormSubmit() {
	var res = InputCheck();
	if(res) {
		//获取标注的经纬度
		var lng = marker.getPosition().lng;
		var lat = marker.getPosition().lat;
		//将经纬度的值填入表单
		$("#longitude").val(lng);  
		$("#latitude").val(lat);
		$("#form_master").submit();  //提交表单
	} else {
		return;
	}
}

//对区域半径和优惠券数进行检查
function InputCheck() {
	var checkFlag = true;  //检查结果flag
	var message = "";
	//取得区域半径和优惠券数的值
	var radius = $("#area_radius").val();
	var number = $("#coupon_number").val();
	var parnt1 = /^[1-9]\d*(\.\d+)?$/;  //大于0的数的正则表达式
	if(radius == "") {
    	message = "区域半径不能为空！";
    	checkFlag = false;
    }else if(!parnt1.exec(radius)){
       message = "区域半径仅可以输入大于0的数！";
        checkFlag = false;
    }
    var parnt2 = /^[0-9]*[1-9][0-9]*$/;  //大于0的整数的正则表达式
    
    if(number == "") {
    	message = message + "优惠券数不能为空！";
    	checkFlag = false;
    }else if(!parnt2.exec(number)){
    	message = message + "优惠券数仅可以输入大于0的整数！";
        checkFlag = false;
    }
    $("#msg").html(message);
    return checkFlag;
}

//对输入的地址进行检索
function PointSearch() {
	var addr = $("#area_center").val();  //取得区域中心输入框的值
	if(addr == "") {  //如果输入为空则什么都不做
		return;
	}
	map = new BMap.Map("map");
	map.enableScrollWheelZoom(true);
	searchCompleteFlag = true;
	var options = {
			onSearchComplete: function(results){
				if(searchCompleteFlag){
					// 判断状态是否正确
					if(local.getStatus() == BMAP_STATUS_SUCCESS){
						var lng = results.getPoi(0).point.lng;  //搜索结果的第一条数据的经度
						var lat = results.getPoi(0).point.lat;  //搜索结果的第一条数据的纬度
						$("#longitude").val(lng);
						$("#latitude").val(lat);
						map.centerAndZoom(new BMap.Point(lng,lat), 16);
						marker = new BMap.Marker(new BMap.Point(lng,lat));  // 创建标注
						map.addOverlay(marker);  
						marker.enableDragging();
						searchCompleteFlag = false;
					} else {
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
	local.search(addr);  //搜索地址
}

//百度地图的异步加载
function loadJScript() {
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = "https://api.map.baidu.com/api?v=2.0&ak=24d29189b1799e5a0f5358961f63616c&s=1&callback=init";
	document.body.appendChild(script);
}

//window.onload = loadJScript;  //异步加载地图