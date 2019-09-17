<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
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
	
	<div class="container space">
		<div class="row">
			<div class="col-md-3">
			</div>
			<div class="col-md-6 formPart">
				<div class="space">
					<h5 class="text-center text-muted">Parking Registration From</h5>
				</div>
				<div class="container">
					<form:form modelAttribute="editProfile" enctype="multipart/form-data">
						<div class="form-group">
							<form:label path="name">Name:</form:label>
							<form:input path="name" cssClass="form-control" id="name"
								value="${EmployeeDetails.name }" placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="name" />
						</div>
						<div class="form-group">
							<form:label path="profile">Profile:</form:label>
							<form:input path="profile" type="file" cssClass="form-control"
								id="email" placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="profile" />
							<br>
							<div>
								<img src="/image/${EmployeeDetails.profile}"
									class="rounded img-fluid" alt="${ProfileImformation.name}"
									height="100" width="100">
							</div>
						</div>
						<div class="form-group">
							<form:label path="password">Password:</form:label>
							<form:input path="password" value="${EmployeeDetails.password}"
								cssClass="form-control" id="password"
								placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="password" />
						</div>
						<div class="form-group">
							<form:label path="confirmPassword">Confirm Password:</form:label>
							<form:input path="confirmPassword"
								value="${EmployeeDetails.password}" cssClass="form-control"
								id="confirmPassword" placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="confirmPassword" />
							<br>
							<form:errors path="${confirmPassword}" class="error" />
						</div>
						<div class="form-group">
							<form:label path="mobileNumber">Mobile Number</form:label>
							<form:input path="mobileNumber"
								value="${EmployeeDetails.mobileNumber}" cssClass="form-control"
								id="mobileNumber" placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="mobileNumber" />
						</div>
						<div class="form-group">
							<form:label path="organisation">Organisation</form:label>
							<form:select id="organisation" path="organisation"
								class="form-control">
								<form:option value="none" disabled="true">Select Your Organization</form:option>
								<form:option value="METACUBE">MetaCube</form:option>
								<form:option value="TCS">TCS</form:option>
								<form:option value="INFOSYS">INFOSYS</form:option>
								<form:option value="SHARVIS">SHARVIS</form:option>
								<form:errors cssClass="error text-danger" path="organisation" />
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