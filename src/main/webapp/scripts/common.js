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

    d = new Date();
    var timezone = -d.getTimezoneOffset() / 60; // �A�W�A+08:00��-8�ŕ\��
    var datetime = new Date(position.timestamp);
	
	$("#accuracy").val(coords.accuracy);
	$("#latitude").val(coords.latitude);
	$("#longitude").val(coords.longitude);
	$("#datetime").val(datetime);
	$("#timezone").val(timezone);
	
	$("#form1").submit();
}

function errorCallback(error){
    switch(error.code) {
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
    }
}

