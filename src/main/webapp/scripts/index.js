function GetGeolocation(){
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(successCallback, errorCallback,{
	        enableHighAccuracy: true,
	        timeout: 5000,
	        maximumAge: 3000,
	    });
	}else{
	    alert("Your browser does not support Geolocation!");
	}
}

function successCallback(position){
    var coords = position.coords;
	
	$("#latitude").val(coords.latitude);
	$("#longitude").val(coords.longitude);
	
	$("#form1").submit();
}

function errorCallback(error){
	alert(error.message);
    /*switch(error.code) {
        case error.TIMEOUT:
            alert("A timeout occured! Please try again!");
            break;
        case error.POSITION_UNAVAILABLE:
            alert('We can\'t detect your location. Sorry!');
            break;
        case error.PERMISSION_DENIED:
            alert('Please allow geolocation access for this to work.');
            break;
        case error.UNKNOWN_ERROR:
            alert('An unknown error occured!');
            break;
    }*/
}

$(document).ready(function(){
	var millis = $("#datetime").val();
	if(millis != ""){
		var dt = new Date(parseInt(millis)).toLocaleString();
		$("#getTime").text(dt);
	}
})
