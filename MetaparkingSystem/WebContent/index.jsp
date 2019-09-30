<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.ArrayList"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

	<%if(session.getAttribute("user")!=null) {
	response.sendRedirect("veichleRegister.jsp");
	}%>
	<h2>${duplicat}</h2>
	<h1 align="Center">Register For Meta-Parking</h1>
	<%
			int count=0;
			ArrayList<String> errorArray = new ArrayList<String>();
			if(request.getAttribute("Error")!=null) {
				errorArray = (ArrayList<String>)request.getAttribute("Error");
				for(int i=0; i<errorArray.size();i++) {
					out.print("<h4 align='center' style='color:red;'>"+errorArray.get(i)+"</h4>");
				}
			}	
			if(request.getAttribute("Success") == "Rivak") {
				out.print("<h4 align='center' style='color:blue;'>Your Account Created Succefully</h4>");
				%>
				
				<a href="http://localhost:8080/MetaparkingSystem/login.jsp">click hear for Login</a>
				<% 
				
			}
			
			
	%>
	<a href="http://localhost:8080/MetaparkingSystem/login.jsp">click hear for Login</a>
	<form action="UserRegistration" method="post" id="register">
		<table align="center" cellspacing="50">
			<tr>
				<th>Name</th>
				<td><input id="name" type="text" name="name"
					placeholder="Enter your name"> &nbsp<span id="requiredName"
					style="color: red"></span></td>
			</tr>

			<tr>
				<th>Email</th>
				<td><input id="Email" type="Email" name="Email"
					placeholder="Enter your Email"> &nbsp<span
					id="requiredEmail" style="color: red"></span></td>
			</tr>

			<tr>
				<th>Organisation</th>
				<td><select name="organisation">
						<option selected  value="null">Select Organisation</option>
						<option value="tcs">Tcs</option>
						<option value="Metacube">Metacube</option>
						<option value="samsung">Samsung</option>
						<option value="amazon">Amazon</option>
						<option value="microsoft">microsoft</option>
				</select></td>

			</tr>

			<tr>
				<th>Password</th>
				<td><input id="Password" type="Password" name="Password"
					placeholder="Enter your Password"> &nbsp<span
					id="requiredPassword" style="color: red"></span></td>
			</tr>

			<tr>
				<th>Confirm Password</th>
				<td><input id="Password-c" type="Password-c" name="Password-c"
					placeholder="Enter your Password again"> &nbsp<span
					id="requiredPassword1" style="color: red"></span></td>
			</tr>

			<tr>
				<th>Gender</th>

				<td><span> 
				<input value="Male" id="GenderM" type="radio"
						name="Gender">&nbsp Male &nbsp 
				<input id="GenderF"
						type="radio" value="Female"name="Gender">&nbsp Female &nbsp 
				<input
						id="GenderO" value="other" type="radio" name="Gender">&nbsp Other &nbsp
						&nbsp<span id="requiredGender" style="color: red"></span>
				</span></td>

			</tr>

			<tr>
				<th>Contact</th>
				<td><input id="Number" type="text" name="Contact"
					placeholder="Enter your Mobile Number"> &nbsp<span
					id="requiredNumber" style="color: red"></span></td>
			</tr>

			<tr>
				<th>
					<button name="submit" value="submit" type="submit">Register</button>
				</th>
				<th>
					<button id="Reset" type="Reset">Reset</button>
				</th>
			</tr>

		</table>
	</form>
</body>
</html>