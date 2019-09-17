function changeCurrency() {
	var sign  = document.getElementsByClassName('p');
	for (var i = 0; i < sign.length; i++) {
		sign[i].innerText = document.getElementById('price').value
	}
	var type = document.getElementById("Type").innerText;
	alert(type)
	var money  =  document.getElementById(type).querySelectorAll(".m");	
	var x = document.getElementById(type).querySelectorAll(".p1");
	switch(document.getElementById('price').value) {
			case "USD":
				for (var i = 0; i < money.length; i++) {
					money[i].innerText =Math.ceil(x[i].value /71.9491);
					
				}
				break;
			case "YEN":
			    for (var i = 0; i < money.length; i++) {
					money[i].innerText =Math.ceil(x[i].value / 1.47)
				}
				break;
			case "INR":
				for (var i = 0; i < money.length; i++) {
					money[i].innerText = x[i].value;
				}
				break;
	}
}
