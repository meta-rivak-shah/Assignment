<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.metaparking.model.VehicleDetails"%>
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
	<form align="center" action="GetVehicleNumber" method="post">
		<lable>Employee Number</lable>
		<input type="text" name="empId" placeholder ="Enter your Employee nuber">
		<button type="submit" name="submit" value="submit">Get Vehile</button>
	</form>
	
		<%
			int count=0;
			ArrayList<VehicleDetails> vechileDetails = new ArrayList<VehicleDetails>();
			if(request.getAttribute("vehicleDetails")!=null) {
				vechileDetails = (ArrayList<VehicleDetails>)request.getAttribute("vehicleDetails");
				
				for(int i=0; i<vechileDetails.size();i++) {
					out.print("Vehicle number = <a href='BookGetPass?vtype="+vechileDetails.get(i).getType()+"&id="+vechileDetails.get(i).getId()+"' >"+vechileDetails.get(i).getVnumber()+"</a><br><br>");
				}
			}	
			
	%>
</body>
</html>