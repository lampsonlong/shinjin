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