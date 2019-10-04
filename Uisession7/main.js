var userName;
var vechile;
var pass;
class Validation {  
    validateName(name) {
        userName = name;
        var filterName = new RegExp('\\d');
		if(name.length <= 2) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "name size should be greater then 2";
		} else if(filterName.test(name)) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "digit are not allowed";
		} else{
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "Hello "+name+" Now tell me Your Email";
            document.getElementById("input-filled").value="";
            document.getElementById("progress").style.width="16.66%";
            return true;
        } 
        setTimeout(function(){ 
            document.getElementById("foot5").style.display="none";
         }, 3000);
        return false
    } 

    validateEmail(email) {
        var filterEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  		if (!filterEmail.test(email)) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "Email should be valid";
		} else {
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "Very Nice "+ userName+".., Now share Your Contact Number";
            document.getElementById("input-filled").value="";
            document.getElementById("progress").style.width="33%";
            return true;
        }
        setTimeout(function(){ 
            document.getElementById("foot5").style.display="none";
         }, 3000);
        return false
    }
    
    validateContact(contact) {

        var filterContact = new RegExp('\\d');
		if(!(contact.length <= 10 && contact.length >= 8)) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText ="contact must in between 10 to 8";
		}else if(!filterContact.test(contact)) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "name size should be greater then 2";
		} else {
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "good...! For security purpose  choose good password which contain number,alphabate,small and upper case";
            document.getElementById("input-filled").value="";
            document.getElementById("progress").style.width="49%";
            return true;
        }
        setTimeout(function(){ 
            document.getElementById("foot5").style.display="none";
         }, 3000);
        return false
    }

    validatePassword(password) {
        pass = password;
        var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
        if(password.length <= 8){
             document.getElementById("input-filled").className = "form-control border border-danger";
             document.getElementById("foot5").style.display="block";
             document.getElementById("error").innerText = "password greater then 8 words";
        } else if (!filterPassword.test(password)) {
            document.getElementById("input-filled").className = "form-control border border-warning";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "password should beb valid formate";
        }  else {
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "Awesome ....!now again enter it to confirm";
            document.getElementById("input-filled").value="";
            document.getElementById("progress").style.width="62%";
            return true;
        }
        setTimeout(function(){ 
            document.getElementById("foot5").style.display="none";
         }, 3000);
         return false
    }

    validateConfirmPassword(confirmPassword) {
        if(confirmPassword != pass) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "password should be same";
        } else {
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "Select Your gender And being a part of meta-parking";
            document.getElementById("input-filled").value="";
            document.getElementById("progress").style.width="78%";
            document.getElementById("foot1").style.display="none";
            document.getElementById("foot2").style.display="block";
            return true;
        }
        setTimeout(function(){ 
            document.getElementById("foot5").style.display="none";
         }, 3000);
        return false;
    }
    insertGender(){
        document.getElementById("label-filled").innerText = "Congratulation Your Account is Register";
        document.getElementById("progress").style.width="100%";
        document.getElementById("foot1").style.display="none";
        document.getElementById("foot2").style.display="none";
        setTimeout(function(){ 
            alert("Wait 2 second "+this.userName+"  i am setting vechile Regstration-form  for you")
            document.getElementById("progress").style.width="0%";
            document.getElementById("label-filled").innerText = "Hey "+ userName +" which vechile your are using"
            document.getElementById("foot1").style.display="block";
            document.getElementById("register-block").innerText = "Vechile Registration Form"
            document.getElementById("b").className = "b2";;
         }, 3000);
    }

    validateVechileName(vechileName) {
        var filterName = new RegExp('^[A-Za-z][0-9]$');
        if(vechileName.length <= 2) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "name size should be greater then 2";
		} else if(filterName.test(vechileName)) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "only contain digit and alphabate";
		} else{
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "What is vechile Number of Your "+vechileName;
            document.getElementById("input-filled").value="";
            document.getElementById("progress").style.width="25%";
            return true;
        } 
        setTimeout(function(){ 
            document.getElementById("foot4").style.display="none";
         }, 3000);
        return false
    }
    
    validateVechilNumber(vechileNumber) {
        var filterName = new RegExp('^[A-Za-z]{2}[0-9]{6}$');
        if(filterName.test(vechileNumber)) {
            document.getElementById("input-filled").className = "form-control border border-danger";
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "vechile number should in valid formate eg:rj 12 1212";
        } else {
            document.getElementById("input-filled").className = "form-control border border-success";
            document.getElementById("label-filled").innerText = "which type of vehcile it is select any one image";
            document.getElementById("input-filled").value="";
            document.getElementById("progress").style.width="50%";
            document.getElementById("foot1").style.display="none";
            document.getElementById("foot3").style.display="block";
            return true;
        }
        setTimeout(function(){ 
            document.getElementById("foot5").style.display="none";
         }, 3000);
        return false
    }
    insertVechileType(vechileType) {
        vechile = vechileType;
        document.getElementById("label-filled").innerText = "Enter some identification of your "+vechileType;
        document.getElementById("progress").style.width="75%";
        document.getElementById("foot1").style.display="block";
        document.getElementById("foot3").style.display="none";
    }

    identification(identification) {
        if(identification.length >= 10 && identification.length <= 100) {
            document.getElementById("label-filled").innerText = "Congratulation Your Vechile is Register";
            document.getElementById("progress").style.width="100%";
            document.getElementById("foot1").style.display="none";
            setTimeout(function(){ 
                alert("Wait 2 second "+this.userName+"  i am setting Gate Pass for you")
                document.getElementById("progress").style.width="0%";
                document.getElementById("label-filled").innerText = "Hey "+ userName+" Select Your Plain"
                document.getElementById("foot4").style.display="block";
                alert(vechile)
                document.getElementById(vechile).style.display="flex";
                document.getElementById("register-block").innerText = "Gate Pass Form";
                document.getElementById("b").className = "b1";
             }, 3000);
            return true;
        } 
        return false;
    }

    showTotalMoney(price) {
        document.getElementById("foot4").style.display="none";
        document.getElementById("progress").style.width="100%";
        document.getElementById("label-filled").innerText = "Thanks for being part of  meta-parking";
        document.getElementById("totalAmount").innerHTML = "Total Amount is -:"+price+"$";
        document.getElementById("b").className = "b3";
	}
}

function changeCurrency() {
	var sign  = document.getElementsByClassName('sign');
	for (var i = 0; i < sign.length; i++) {
		sign[i].innerText = document.getElementById('price').value
	}
	var type = document.getElementById(vechile).value;
	alert(vechile)
	var money  =  document.getElementById(vechile).querySelectorAll('.money');	
	var x = document.getElementById(vechile).querySelectorAll(".p");
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


var count = 0;
function validateData() { 
    var formValue = document.getElementById("input-filled").value;
    var validationObj  = new Validation();
    if(count == 0) {
        if(validationObj.validateName(formValue)){
            count=1;
            console.log("Name");
        }
    } 

    else if(count == 1) {
        if(validationObj.validateEmail(formValue)){
            count=2;
            console.log("Email");
        }
       
    } 
    else if(count == 2) {
       if(validationObj.validateContact(formValue)){
            count=4;
            console.log("Contact");
       }
    } 
    else if(count == 4) {
        if(validationObj.validatePassword(formValue)){
            count=5;
            console.log("password");
        }
       
    }
    else if(count == 5) {
     if(validationObj.validateConfirmPassword(formValue)){
            count=6;
            console.log("confirm password");
        }
    }
    else if(count == 6) {
        if(document.getElementById("male").value != null){
            validationObj.insertGender(document.getElementById("male").value);
            count = 7;
        } else {
            validationObj.insertGender("female");
            count = 7;
        }
    } 
    else if(count == 7) {
        if(validationObj.validateVechileName(formValue)){
            count=8;
            console.log("Vechile Name");
        }
    }
    else if(count == 8) {
        if(validationObj.validateVechilNumber(formValue)){
            count=9;
            console.log("Vechile Number");
        }
    }
    else if(count == 9) {
        if(document.getElementById("cycle").value != null){
            validationObj.insertVechileType(document.getElementById("cycle").value);
            count = 10;
        } else if(document.getElementById("moter").value != null){
            validationObj.insertVechileType(document.getElementById("moter").value);
            count = 10;
        }
        else {
            validationObj.insertVechileType("ForWheeler");
            count = 10;
        }
    } 
    else if(count == 10) {
        if(validationObj.identification(formValue)){
            count=11;
            console.log("indetification");
        }
    } 
    else if(count == 11) {
        var checkvlaueSelect = 0;
	    var type = document.getElementById(vechile).value;
	    var x = document.getElementsByClassName("p");
	    for(var i = 0; i < x.length; i++) {
		 if(x[i].checked == true){
			checkvlaueSelect=1;
			validationObj.showTotalMoney(x[i].value);
        } 
        if(checkvlaueSelect == 0) {
            document.getElementById("foot5").style.display="block";
            document.getElementById("error").innerText = "Select any plain";
            setTimeout(function(){ 
                document.getElementById("foot5").style.display="none";
             }, 3000);
        }
	}
    }

}

