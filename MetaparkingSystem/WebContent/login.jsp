<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("user")!=null) {
	response.sendRedirect("veichleRegister.jsp");
}%>
	<h3>${messag} ${AuthenicationFailed}</h3>
	<form action="Login" method="Post">
		<table align="center" cellspacing="50">
		
			<tr>
				<th>Email</th>
				<td><input id="Email" type="Email" name="Email"
					placeholder="Enter your Email"> &nbsp<span
					id="requiredEmail" style="color: red"></span></td>
			</tr>
			
			<tr>
				<th>Password</th>
				<td><input id="password" type="password" name="password"
					placeholder="Enter your password"> &nbsp<span id="requiredPassword"
					style="color: red"></span></td>
			</tr>
			<tr>
				<th><button type="submit">Login</button></th>
			</tr>
		</table>
	</form>
</body>
</html>