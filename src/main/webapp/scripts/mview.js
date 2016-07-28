$(document).ready(function() {
	MviewInit();
	$(".hidDatetime").each(function() {  //UTC时间转北京时间
		var strTime = $(this).html();
		var utc = parseInt(strTime);
		var date2 = new Date(utc);
		var localeString = date2.toLocaleString();
		$(this).html(localeString);
	})
})
function MviewInit() //初始化函数
{
	setFocus();
};
function setFocus() //设置焦点
{
	document.getElementById('refresh').focus();
};

