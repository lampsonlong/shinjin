function Refresh(){
	$("#form").submit();
}

$(document).keypress(function(e) {  
// Enter key
   if(e.which == 13) {
	   Refresh();
   }  
}); 