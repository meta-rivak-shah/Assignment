<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.metaparking.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${Success}</h2>
	<%if(session.getAttribute("user")==null) {
	response.sendRedirect("index.jsp");
	}%>
	
	<%
			ArrayList<String> errorArray = new ArrayList<String>();
			if(request.getAttribute("Error")!=null) {
				errorArray = (ArrayList<String>)request.getAttribute("Error");
				for(int i=0; i<errorArray.size();i++) {
					out.print("<h4 align='center' style='color:red;'>"+errorArray.get(i)+"</h4>");
				}
			}		
	%>
	
	<%
		int count = 0;
		ArrayList<User> allUserData = new ArrayList<User>();
		if (request.getAttribute("userData") != null) {
			allUserData = (ArrayList<User>) request.getAttribute("userData");
			for(int i=0; i <allUserData.size(); i++) {
				%>
				<form align="center" action="UpdateProfile" method="post">
				Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" value="<%out.print(allUserData.get(i).getName());%>" placeholder = "Enter yout name" required name="name"><br><br>
				Password:&nbsp&nbsp&nbsp&nbsp<input type="text" value="<%out.print(allUserData.get(i).getPassword());%>" placeholder = "Enter your pwd" required name="pwd"><br><br>
				Contact:&nbsp&nbsp&nbsp&nbsp<input type="text" value="<%out.print(allUserData.get(i).getContat());%>" placeholder = "Enter yout number" required name="number"><br><br>
				<button type="submit" value="submit">Update Data</button>
				</form>
					<a  href="http://localhost:8080/MetaparkingSystem/veichleRegister.jsp">Vechile Register</a><br><br>
					<a  href="ShowFriends">Friend List</a><br><br>
				<% 
			}
		} else {
			response.sendRedirect("Profile");
		}
	%>
	<br>
	<br>
</body>
</html>