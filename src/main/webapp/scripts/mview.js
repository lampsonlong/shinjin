function Refresh(){
	$("#form").submit();
}

$(document).keypress(function(e) {  
// Enter key
   if(e.which == 13) {
	   e.preventDefault();
	   Refresh();
   }  
});

$(document).ready(function(){
	$(".dt input").each(function(){
		var millis = $(this).val();
		if(millis != ""){
			var dt = new Date(parseInt(millis)).toLocaleString();
			$(this).parent().text(dt);
		}
		
	})
})