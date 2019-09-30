<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <a style="float:left;" href="gatepass.jsp">Take Gate Pass</a>
		<a style="float:right;" href ="Profile">Show Profile</a><br>
  	<h2>${formNotFill }</h2>
  	<h2>${Success}</h2>
  	<h2>${Duplicate }</h2>
  	<%
			int count=0;
			ArrayList<String> errorArray = new ArrayList<String>();
			if(request.getAttribute("Error")!=null) {
				errorArray = (ArrayList<String>)request.getAttribute("Error");
				for(int i=0; i<errorArray.size();i++) {
					out.print("<h4 align='center' style='color:red;'>"+errorArray.get(i)+"</h4>");
				}
			}		
	%>
	<h1>Vehicle Register Form</h1>
	<form action="RegisterVehicle" method ="Get">
			<table align="center"  cellspacing="50">

			<tr>
				<th><spam id="invalidVname">Name</spam></th>
				<td> <input id="Vname" type="text" name="name" placeholder="Enter your Vehicle name">
				 &nbsp<span id="requiredVname" style="color: red"></span> 
				</td>
			</tr>

			<tr>
				<th><spam id="invalidType" name="vType">Type</spam></th>
				<td>
					<select id="Type" name="Type">
						<option value="none"  selected>Select Type of Vehicle</option>
						<option value="Cycle">Cycle</option>
						<option value="MotorCycle">Motor Cycle</option>
						<option value="FourWheelers">Four Wheelers</option>
					</select>&nbsp
					<span id="requiredType" style="color: red"></span>
				</td>
			</tr>

			<tr>
				<th>
					<spam id="invalidVN">Vehicle Number</spam>
				</th>
				<td>
					<input id="VehicleNum" type="text" name="VehicleNum" placeholder="Enter your Vehicle Number ">
					&nbsp<span id="requiredvehicleNumber" style="color: red"></span>
				</td>
			</tr>

			<tr>
				<th>
					Employee Id
				</th>
				<td>
					<input id="Employeeid" type="text" value=123 name="Employeeid" readonly>
					&nbsp<span id="requiredEid" style="color: red"></span>
				</td>
			</tr>


			<tr>
				<th><spam id="invalidIdentity">Identification</spam></th>
				<td>
					<textarea id="identity" name="identity" cols="50" rows="5"></textarea>
					&nbsp<span id="requiredIdentity" style="color: red"></span>
				</td>
			</tr>

			<tr>
				<th>
					<button  name="submit" value="submit" type="submit">Register</button>
				</th>
			</tr>

		</table>
		</form>
		<%
  		if(session.getAttribute("user")!=null) {
  			out.print("<script> document.getElementById('Employeeid').value = "+session.getAttribute("user")+"</script>");
  		} else {
  			response.sendRedirect("login.jsp");
  		}
  	%>
  
</body>
</html>