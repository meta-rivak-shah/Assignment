<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.metaparking.model.UserFriendList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("user")==null) {
	response.sendRedirect("index.jsp");
	}%>
<a style="color:blue; text-decoration: none; font-size: 30px;" href="profile.jsp">Go To Profile</a>
<%
		int count = 0;
		ArrayList<UserFriendList> userFriendData = new ArrayList<UserFriendList>();
		if (request.getAttribute("userFriend") != null) {
			userFriendData = (ArrayList<UserFriendList>) request.getAttribute("userFriend");
			for(int i = 0 ; i<userFriendData.size(); i++) {
				%>
				<div style="border:2px solid green; width:30%; ">
					Name <h4><%out.print(userFriendData.get(i).getFull_name()); %></h4>
					Contact Number <h4><%out.print(userFriendData.get(i).getContact_number()); %></h4>
					 Email id <h4><%out.print(userFriendData.get(i).getEmail_id()); %></h4>
					Organisation <h4><%out.print(userFriendData.get(i).getOrganisation()); %></h4>
				</div>
				<% 
			}
		}
	%>

</body>
</html>
