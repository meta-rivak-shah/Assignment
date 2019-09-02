class MetaParking{

	constructor() {}

	static validationForUser(name , email , password , cPassword , contact , gender , userId) {
		var count=0;
		var filterContact = new RegExp('([a-zA-Z!@#$%^&*()_+])');
		if(!(contact.length <= 10 && contact.length >= 8) ) {
			this.requiredError('invalidC')
			this.errorDescription('requiredNumber',"Insert Number Between 8 to 10");
			count++;
		}else if(filterContact.test(contact)) {
			this.requiredError('invalidC')
			this.errorDescription('requiredNumber',"Numeric value only allowed");
		} else {
			this.removeError('invalidC');
			this.removeDescription('requiredNumber',"");
			count--;
		}

		var filterName = new RegExp('\\d');
		if(name.length <= 2) {
			this.requiredError('invalidN');
			this.errorDescription('requiredName',"Insert name greter then 2 word");
			count++;
		} else if(filterName.test(name)) {
			this.requiredError('invalidN');
			this.errorDescription('requiredName',"Numeric value not allowed");
			count++;
		} else{
			this.removeError('invalidN');
			this.removeDescription('requiredName',"");
			count--;
		}

		var filterEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  		if (!filterEmail.test(email)) {
			this.requiredError('invalidE');
			this.errorDescription('requiredEmail' ,"Insert a Valid Email");
			count++;
		} else {
			this.removeError('invalidE');
			this.removeDescription('requiredEmail',"");
			count--;
		}


		var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
		if(password.length <= 8){
			this.requiredError('invalidP');
			this.errorDescription('requiredPassword' ,"Atleast 8 char required");
			count++;
		} else if (!filterPassword.test(password)) {
			this.requiredError('invalidP');
			this.errorDescription('requiredPassword' ,"Insert Valid password formate eg Rivak@12345");
			count++;
		} else if(password != cPassword) {
			this.requiredError('invalidCp');
			this.errorDescription('requiredPassword' ,"both password should same");
			count++;
		} else {
			this.removeError('invalidP');
			this.removeDescription('requiredPassword',"");
			count--;
		}

		if(gender === "no"){
			this.requiredError('invalidG');
			this.errorDescription('requiredGender' ,"Select Any one Gender");
			count++;
		} else{
			this.removeError('invalidG');
			this.removeDescription('requiredGender',"");
			count--;
		}

		return count;
	}

	static validationForVehicle(vName , type , vehicleNum , identity) {
		var count = 0;
		if(vName.length <= 2){
			this.requiredError('invalidVname');
			this.errorDescription('requiredVname',"Insert name greter then 2 word");
			count++;
		} else {

			this.removeError('invalidVname');
			this.removeDescription('requiredVname',"");
			count--;
		}

		if(type == "none") {
			this.requiredError('invalidType');
			this.errorDescription('requiredType',"Select Type Of Your Vehicle");
			count++;
		} else {

			this.removeError('invalidType');
			this.removeDescription('requiredType',"");
			count--;
		}

		if(vehicleNum.length <= 4) {
			this.requiredError('invalidVN');
			this.errorDescription('requiredvehicleNumber',"Vehicle Number required");
			count++;
		} else {

			this.removeError('invalidVN');
			this.removeDescription('requiredvehicleNumber',"");
			count--;
		}
		if(identity.length <= 10) {
			this.requiredError('invalidIdentity');
			this.errorDescription('requiredIdentity',"identity filled is required");
			count++;
		} else {

			this.removeError('invalidIdentity');
			this.removeDescription('requiredIdentity',"");
			count--;
		}
		return count;
	}

	static showTotalMoney(price , divId) {
		alert(price)
		this.collpaseDiv(divId);
		document.getElementById("totalAmount").innerHTML = "Total Amount is -:"+price+"$";
	}

	static requiredError(id) {
		document.getElementById(id).style.color = "green";
	}
	static errorDescription(id , text) {
		var value = document.getElementById(id).innerHTML =text;
	}
	static removeError(id) {
		document.getElementById(id).style.color = "black";
	}
	static removeDescription(id , text) {
		var value = document.getElementById(id).innerHTML =text;
	}

	static setUserId(userId , id){
		document.getElementById(id).innerHTML = "User-id :"+userId;
		this.insertReadonlyvalue('Employeeid' , userId);
		document.getElementById(id).style.display = 'block';
	}

	static collpaseDiv(id) {
		document.getElementById(id).style.display = 'none';
	}

	static showDiv(id) {
		document.getElementById(id).style.display = 'block';
	}
	static insertReadonlyvalue(id , text){
		document.getElementById(id).value =  text;
	}
}





function userRegistration(){
	var  name      = document.getElementById("name").value;
	var  email     = document.getElementById("Email").value;
	var  password  = document.getElementById("Password").value;
	var  cPassword = document.getElementById("Password-c").value;
	var  contact   = document.getElementById("Number").value;
	var  genderO    = document.getElementById("GenderO").checked;
	var  genderF    = document.getElementById("GenderF").checked;
	var  genderM    = document.getElementById("GenderM").checked;
	var gender ="";
	if(genderO == true){
		gender = "Other";
	}
	else if(genderM == true){
		gender = "Male";
	}
	else if(genderF == true){
		gender = "Female";
	}
	else{
		gender = "no";
	}
	var count = MetaParking.validationForUser(name,email,password,cPassword,contact,gender);
	if(count === -5){
		alert("Your Account is Succefully Created");
		MetaParking.setUserId(Math.floor(Math.random() * 1000) , 'user-id');
		MetaParking.collpaseDiv('Register-div');
		MetaParking.showDiv('vehicle-Register-div');
	}
}

function vehicleRegister() {
		var  vName      = document.getElementById("Vname").value;
		var  type      = document.getElementById("Type").value;
		var  vehicleNum = document.getElementById("VehicleNum").value;
		var  identity      = document.getElementById("identity").value;
		var count = MetaParking.validationForVehicle(vName , type , vehicleNum , identity);
		if(count == -4){
			alert("Your Vehicle is Register");
			MetaParking.collpaseDiv('vehicle-Register-div');
			MetaParking.showDiv('ac');
			MetaParking.showDiv('vehicle-Price-div');
			MetaParking.showDiv(type);
			MetaParking.showDiv('button');
		}
}

function changeCurrency() {
	var sign  = document.getElementsByClassName('sign');
	for (var i = 0; i < sign.length; i++) {
		sign[i].innerText = document.getElementById('price').value
	}
	var type = document.getElementById("Type").value;
	alert(type)
	var money  =  document.getElementById(type).querySelectorAll('.money');	
	var x = document.getElementById(type).querySelectorAll(".p");
	switch(document.getElementById('price').value) {
			case "USD":
				for (var i = 0; i < money.length; i++) {
					money[i].innerText = x[i].value;
				}
				break;
			case "YEN":
			    for (var i = 0; i < money.length; i++) {
					money[i].innerText =x[i].value *1.47
				}
				break;
			case "INR":
				for (var i = 0; i < money.length; i++) {
					money[i].innerText =x[i].value * 71.9491;
				}
				break;
	}
}

function takeGetPass() {
	var checkvlaueSelect = 0;
	var type = document.getElementById("Type").value;
	var x = document.getElementById(type).querySelectorAll(".p");
	for(var i = 0; i < x.length; i++) {
		 if(x[i].checked == true){
			checkvlaueSelect=1;
			MetaParking.showTotalMoney(x[i].value , "vehicle-Price-div");
		} 
	}
	if(checkvlaueSelect == 0) {
		document.getElementById("error").innerHTML = "Select Price";
	}
	
}