$(function() {
	Init();
})

/**
 * 函数名	： Init()
 * 函数说明： 画面初始化函数
 * 
 * @returns
 */
function Init() {
	// 取得服务器返回值
	var errMsg = document.getElementById("errMsg_hidden");
	
	// 初始化页面
	$("#errMsg_label").hide();
	$("#password").focus();
	
	// 返回值不为空时显示错误提示
	if (errMsg.value != "") {
		$("#errMsg_label").show();
	}
}

/**
 * 函数名：	OnSubmit()
 * 函数说明	登陆操作
 * 
 * @returns
 */
function OnSubmit() {	// 登陆
	$("#login_form").submit();
}