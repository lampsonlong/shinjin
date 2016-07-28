$(function() {
	Init();
})

/**
 * 函数名：Init()
 * 函数说明： 页面初始化函数
 * 
 * @returns
 */
function Init() {
	// 获取服务器返回值
	var ret = $("#ret").val();
	
	// 设置图片不可见
	$("#scansnap").hide();
	
	// 根据服务器返回结果显示不同画面
	if (ret != "") {
		switch (ret) {
		case "-9999":	// 提交了错误的参数
			$("#index_inform").html("您的设备未能正常获取到地理位置数据，请尝试刷新页面或打开浏览器地理位置权限。");
			$("#scansnap").attr("src","pic/kcode_gps.jpg");
			$("#scansnap").show();
			$("#index_inform").show();
			break;
		case "-3":	// 设备不在优惠券领取范围内
			var dst = $("#position_dst").val();
			$("#index_inform").html("您离优惠券领取范围太远啦！还有"+ dst + "千米到达取票范围");
			$("#scansnap").attr("src","pic/kcode_dst.jpg");
			$("#scansnap").show();
			$("#index_inform").show();
			break;
		case "-2":	// 优惠券已领取完
			$("#index_inform").html("剩余优惠券数不足，请耐心等待下次活动开启");
			$("#scansnap").attr("src","pic/kcode_none.jpg");
			$("#scansnap").show();
			$("#index_inform").show();
			break;
		case "-1":	// 没有Master数据
			$("#index_inform").html("活动还没有开始，请耐心等待");
			$("#scansnap").attr("src","pic/kcode_wait.jpg");
			$("#scansnap").show();
			$("#index_inform").show();
			break;
		case "0":	// 成功领取优惠券
		case "1":	// 已经领取过优惠券
			var kbcode = $("#kbcode").val();
			$("#index_inform").html("你已经成功领取了PFU SV600扫描仪的优惠码：" + kbcode);
			$("#scansnap").show();
			$("#index_inform").show();
			$("#askForTK").hide();
			break;
		default:	// 第一次进入抢票页面
			$("#index_inform").hide();
		}
	}
}

/**
 * 函数名：getLocation()
 * 说明： 获取设备地理位置
 * 
 * @returns
 */
function getLocation() {
	if (navigator.geolocation) {	// 成功获取到地理位置
		// 上传地理位置到服务器进行抢票
		navigator.geolocation.getCurrentPosition(ShowPosition, errCallback);
    }
}

/**
 * 函数名：ShowPosition()
 * 说明： 抢票操作
 * 
 * @param position
 * @returns
 */
function ShowPosition(position) {
	// 获取设备经纬度
	$("#position_latitude").val(position.coords.latitude);
	$("#position_longitude").val(position.coords.longitude);

	// 进行抢票
	$("#gps_form").submit();
}

function errCallback(err){
	$("#index_inform").html("您的设备未能正常获取到地理位置数据，请尝试刷新页面或打开浏览器地理位置权限。");
	$("#scansnap").attr("src","pic/kcode_gps.jpg");
	$("#scansnap").show();
	$("#index_inform").show();
}