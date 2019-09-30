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
		<h1>${message }</h1>
  		<p>In this Assignment we are static show the data add the data !</p> 
     </div>
</div>
  
<div class="container ">
  <div class="row">
    <div class="col-sm-4">
      <h3>Operation 1</h3>
      <p>Add student by click on Add Student Link</p>
      <p class ="bg-light text-dark" style="text-decoration: none;"><a href="signUp">Add Student</a></p>
    </div>
    <div class="col-sm-4">
      <h3>Operation 2</h3>
      <p>Show All the Student which is add in the list</p>
      <p class = "bg-light text-dark" style="text-decoration: none;"><a href="showStudent">Show Student</a></p>
    </div>
    
    <div class="col-sm-4">
      <h3>Operation 3</h3>
      <p>Search the Student By first Name And Last Name</p>
      <p class = "bg-light text-dark" style="text-decoration: none;"><a href="searchStudent">Search Student</a></p>
    </div>
  </div>
</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>