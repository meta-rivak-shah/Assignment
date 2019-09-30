<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<form:form modelAttribute="SearchCommand">
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
			
			<button type="submit" class="btn btn-primary">Submit</button> 
			<a href="/home" class="btn btn-primary btn-sm text-center">Return To Home Page</a>
		</form:form>
	</div>
 	<c:if test="${not empty studentData}">
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Father Name</th>
						<th>Class</th>
						<th>Email</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${studentData}"
						varStatus="loopcounter">
    					<tr>
							<td>${loopcounter.count }</td>
							<td>${student.firstName }</td>
							<td>${student.lastName}</td>
							<td>${student.fatherName}</td>
							<td>${student.studentClass }</td>
							<td>${student.email}</td>
							<td>${student.studentAge}</td>
						</tr>		
 	  				</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>