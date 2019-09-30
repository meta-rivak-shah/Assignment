<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Add Student</title>
</head>
<body>

	<div class="container">
		<div class="jumbotron text-center bg-warning text-white">
			<h1>Add Student Operation Page</h1>
			<p>In this ADD we are Insert the data and add into list and show
				into console!</p>
				<h1>${succes }</h1>
		</div>
	</div>
	<div class="container ">
		<h2>Insert Data</h2>
		<form:form modelAttribute="studentCommand">
			<form:errors path="${Email}" cssClass="error text-warning" />
			<div class="form-group">
				<form:label path="firstName">First Name:</form:label> 
				<form:input path="firstName" cssClass="form-control" id="firstName" placeholder="Enter Student frist Name" />
				<form:errors cssClass="error text-warning" path="firstName"/> 
			</div>
			
			<div class="form-group">
				<form:label path="lastName">Last Name:</form:label> 
				<form:input path="lastName" cssClass="form-control" id="lastName" placeholder="Enter Student Last Name" />
				<form:errors cssClass="error text-warning" path="lastName"/>
			</div>
			
				
			<div class="form-group">
				<form:label path="fatherName">Father Name:</form:label> 
				<form:input path="fatherName" cssClass="form-control" id="fatherName" placeholder="Enter Father  Name" />
				<form:errors cssClass="error text-warning" path="fatherName"/>
			</div>
		
			<div class="form-group">
				<form:label path="email">Email:</form:label> 
				<form:input path="email" cssClass="form-control" id="Email" placeholder="Enter Email" />
				<form:errors cssClass="error text-warning" path="email"/>
			</div>

			<div class="form-group">
				<form:label path="studentClass">Class:</form:label>
				<form:input path="studentClass" class="form-control" id="class" max="12" min="1" placeholder="Enter your class"  />
				<form:errors cssClass="error text-warning" path="studentClass"/> 
			</div>
			
			<div class="form-group">
				<form:label path="studentAge">Age:</form:label>
				<form:input path="studentAge" class="form-control" id="class" max="12" min="1" placeholder="Enter your class"  />
				<form:errors cssClass="error text-warning" path="studentAge"/> 
			</div>
			<button type="submit" class="btn btn-primary">Submit</button> 
			<a href="/home" class="btn btn-primary btn-sm text-center">Return To Home Page</a>
		</form:form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>