<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.metaparking.model.Price"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int count = 0;
		ArrayList<Price> priceOfVechile = new ArrayList<Price>();
		if (request.getAttribute("priceOfVechile") != null) {
			priceOfVechile = (ArrayList<Price>) request.getAttribute("priceOfVechile");
	%>
	
	<%if(session.getAttribute("user")==null) {
	response.sendRedirect("index.jsp");
	}%>
	
	<form method="Post" action="PrintGatePass">
	<table align="center" cellspacing="10" cellpadding="20">
		<tr id="ac">
			<th><h3>Type</h3></th>
			<th><h3>Daily</h3></th>
			<th><h3>Mothly</h3></th>
			<th><h3>Yearly</h3></th>
		</tr>
		<%
			for (int i = 0; i < priceOfVechile.size(); i++) {
				
		%>
		<tr>
			<td id="Type" style="display: none"><%out.print(priceOfVechile.get(i).getType()); %></td>
		</tr>
		<tr id="<%out.print(priceOfVechile.get(i).getType());%>">
			<th><h4><%out.print(priceOfVechile.get(i).getType());%></h4></th>
			<td><input class="p"
				value="<%out.print(priceOfVechile.get(i).getDaily());%>"
				type="radio" name="price"><span class="sign">USD</span>
			<p class="money"><%out.print(priceOfVechile.get(i).getDaily());%></p></td>
			<td><input class="p"
				value="<%out.print(priceOfVechile.get(i).getMonthly());%>"
				type="radio" name="price"><span class="sign">USD</span>
			<p class="money"><%out.print(priceOfVechile.get(i).getMonthly());%></p></td>
			<td><input class="p"
				value="<%out.print(priceOfVechile.get(i).getYearly());%>"
				type="radio" name="price"><span class="sign">USD</span>
			<p class="money"><%out.print(priceOfVechile.get(i).getMonthly());%></p></td>
		</tr>
		<%
			}
		%>
	  <tr id="button">
			<th><button  type="submit">Gate
					Pass</button></th>
			<th><select id="price" onchange="changeCurrency()">
					<option disabled selected>Change Currency</option>
					<option value="USD">USD</option>
					<option value="YEN">YEN</option>
					<option value="INR">INR</option>
			</select></th>
			<th id="error"></th>
		</tr>
	</table>
	</form>
	<%
		}
	%>
	<script>

	function changeCurrency() {
		var sign  = document.getElementsByClassName('sign');
		for (var i = 0; i < sign.length; i++) {
			sign[i].innerText = document.getElementById('price').value
		}
		var type = document.getElementById("Type").innerHTML;
		alert(type)
		var money  =  document.getElementById(type).querySelectorAll('.money');	
		var x = document.getElementById(type).querySelectorAll(".p");
		switch(document.getElementById('price').value) {
				case "USD":
					for (var i = 0; i < money.length; i++) {
						money[i].innerText = x[i].value;
					}
					break;
				case "YEN":
				    for (var i = 0; i < money.length; i++) {
						money[i].innerText =x[i].value *1.47
					}
					break;
				case "INR":
					for (var i = 0; i < money.length; i++) {
						money[i].innerText =x[i].value * 71.9491;
					}
					break;
		}
	}

	</script>
</body>
</html>