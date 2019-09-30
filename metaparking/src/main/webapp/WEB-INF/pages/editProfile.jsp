<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="/css/index.css">
<title>Edit Profile</title>
</head>
<body>
	<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
	<div class="container space">
		<div class="row">
			<div class="col-md-3">
			</div>
			<div class="col-md-6 formPart">
				<div class="space">
					<h5 class="text-center text-muted">Parking Registration From</h5>
				</div>
				<div class="container">
				  <form:form modelAttribute="editProfile">
					 <div class="form-group">
						<form:label path="name">Name:</form:label> 
						<form:input path="name" cssClass="form-control" id="name" value="Rivak shah" placeholder="Enter Your Name" />
						<form:errors cssClass="error text-danger" path="name"/> 
					 </div>
				    <div class="form-group">
						<form:label path="profile">Profile:</form:label> 
						<form:input path="profile" type="file" cssClass="form-control" id="email" placeholder="Enter Your Name" />
						<form:errors cssClass="error text-danger" path="profile"/> 
					 </div>
				    <div class="form-group">
						<form:label path="password">Password:</form:label> 
						<form:password path="password" value="Rivak12345" cssClass="form-control" id="password" placeholder="Enter Your Name" />
						<form:errors cssClass="error text-danger" path="password"/> 
					 </div>
				     <div class="form-group">
						<form:label path="confirmPassword">Confirm Password:</form:label> 
						<form:password path="confirmPassword"  value="Rivak12345"  cssClass="form-control" id="confirmPassword" placeholder="Enter Your Name" />
						<form:errors cssClass="error text-danger" path="confirmPassword"/> <br>
						<form:errors path="${confirmPassword}" class="error" />
					 </div>
				    <div class="form-group">
						<form:label path="mobileNumber">Mobile Number</form:label> 
						<form:input path="mobileNumber" value="1234567890"  cssClass="form-control" id="mobileNumber" placeholder="Enter Your Name" />
						<form:errors cssClass="error text-danger" path="mobileNumber"/> 
					 </div>
				    <div class="form-group">
				      <form:label path="gender">Gender:&nbsp &nbsp</form:label>
				      <label><form:radiobutton path="gender" value="Male"/>Male</label>&nbsp &nbsp
				      <label><form:radiobutton path="gender" value="Female"/>Female</label>&nbsp &nbsp
				      <label><form:radiobutton path="gender" value="Other"/>Other</label>&nbsp &nbsp
				      <form:errors cssClass="error text-danger" path="gender"/> 
				    </div>
				    
				    <div class="form-group">
				    	<form:select id="organisation" path="organisation" class="form-control">
				    		<form:option value="none"  disabled="true">Select Your Organization</form:option>
				    		<form:option value="METACUBE">MetaCube</form:option>
				    		<form:option value="TCS">TCS</form:option>
				    		<form:option value="INFOSYS">INFOSYS</form:option>
				    		<form:option value="SHARVIS">SHARVIS</form:option>
				    		<form:errors cssClass="error text-danger" path="organisation"/> 
				   		</form:select>
				    </div>
				    <button type="submit" class="btn btn-primary">Update</button>
				  </form:form>
			   </div>
			</div>
			<div class="col-md-3">
			</div>
		</div>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
</body>
</html>