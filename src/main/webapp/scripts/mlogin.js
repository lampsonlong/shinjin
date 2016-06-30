$(document).ready(function(){
	$("#password").focus();
	if($("#hidErrMsg").val() != ""){
		$("#pwdInput").addClass("has-error");
	}
})

function MLogin(){
	var pwd = $("#password").val();
	$("#hidpwd").val(pwd);
	$("#form").submit();
}

$(document).keypress(function(e) {  
// Enter key
   if(e.which == 13) {
	   MLogin();
   }
});