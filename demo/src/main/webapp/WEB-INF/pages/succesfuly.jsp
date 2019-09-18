<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<title>Home page</title>
</head>
<body>
	
	
<div class = "container" >
	<div class="jumbotron text-center bg-warning text-white">
  		<h1>${success}</h1>
  		<h3>${Name}  ${lname}</h3>
  		<p>click on the link go Home Page</p> 
     </div>
</div>
  
<div class="container text-center">
  <div class="row">
  
    
    <div class="col-sm-12">
    <div class="alert alert-primary alert-dismissible">
    	<button type="button" class="close" data-dismiss="alert">&times;</button>
  	    <strong>Your Details....!</strong><br>Father Name : ${fathername } <br> Email : ${Email} <br> Class : ${classs} <br>
    </div>
    </div>
    
  
  
    <div class="col-sm-12">
      <h3>Operation 1</h3>
      <p>click on the link to go Home Page</p>
      <p class ="bg-light text-dark" style="text-decoration: none;"><a href="home">Home Page</a></p>
    </div>
    
  </div>
</div>
	
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>