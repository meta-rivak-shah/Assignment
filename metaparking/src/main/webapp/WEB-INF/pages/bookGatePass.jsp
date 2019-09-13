<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Gate Pass</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="/css/index.css">
 <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container space">
		<div class="jumbotron bg-light text-black">
			<h1>Book Your Gate Pass</h1>
			<p>Select your choise plain click on gate pass button to book gate pass</p>
			<p>For Return Back click on back button</p>
			<a href="GatePass" class="btn btn-primary btn-lg bg-dark">Back <span class="glyphicon glyphicon-chevron-left"></span> </a>
		</div>
	</div>
	
	<div  class="container">
		<div class="row">
			<div class="col-md-1">
			</div>
			<div class="col-md-10">
				  <table class="table">
					<thead>
						<tr class="table-primary">
							<th>Type</th>
							<th>Daily</th>
							<th>Monthly</th>
							<th>Yearly</th>
						</tr>
					</thead>
					<form:form modelAttribute="gatepass">
						<tbody>
							<tr id="Cycle">
								<td id="Type">Cycle</td>
								 <td><label><form:radiobutton class="p1"  path="price" value="100"/><span class="m">100</span><span class="p">INR</span></label>&nbsp &nbsp</td>
				  			     <td><label><form:radiobutton class="p1" path="price" value="200"/><span class="m">200</span><span class="p">INR</span></label>&nbsp &nbsp</td>
				     			 <td> <label><form:radiobutton class="p1" path="price" value="300"/><span class="m">300</span><span class="p">INR</span></label>&nbsp &nbsp</td>
				     			 <td><form:errors cssClass="error text-danger" path="price"/> </td>
							</tr>
							<tr>
								<td><button type="submit" class="btn btn-success btn-lg">Take Pass</button></td>
								<td>
										<select id="price" onchange="changeCurrency()">
											<option disabled selected>Change Currency</option>
											<option value="USD">USD</option>
											<option value="YEN">YEN</option>
											<option value="INR">INR</option>
										</select>
								</td>
							</tr>
						</tbody>
					</form:form>
				</table>
			</div>
			<div class="col-md-1">
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 <script src="/js/main.js"></script>
</body>
</html>