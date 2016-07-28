$(document).ready(function() {
	MviewInit();
	$(".hidDatetime").each(function() { // UTC时间转本地时间
		var strTime = $(this).html();//取String型的UTC时间码
		var utc = parseInt(strTime);//将strTime转为Int型
		var date2 = new Date(utc);//将UTC时间转为本地时间
		var localeString = date2.toLocaleString();
		$(this).html(localeString);
	});
})

// 初始化函数
function MviewInit() {
	document.getElementById('refresh').focus(); // 设置焦点在刷新按钮上
}
