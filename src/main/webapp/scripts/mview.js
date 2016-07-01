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
	$(".dt").each(function(){
		var millis = $(this).text();
		if(millis != ""){
			var dt = new Date(parseInt(millis)).toLocaleString();
			$(this).text(dt);
		}
		
	})
})