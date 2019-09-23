<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" scope="request" value="Home" />
<%@include file="../includes/header.jsp"%>
<div class="container" style="margin-top: 60px" align="center">
	<div class="card">
		<div class="card-header">
			<h1>User Management System</h1>
		</div>
		<div class="card-body">
			<br>
			<button type="submit" class="btn btn-primary"
				onclick="window.location.href = '/getUser';">Get User Details</button>
			<br> <br>
			<button type="submit" class="btn btn-primary"
				onclick="window.location.href = '/updateUser';">Update User Details</button>
			<br> <br>
			<button type="submit" class="btn btn-primary"
				onclick="window.location.href = '/getAdmin';">Get Admin Details</button>
			<br> <br>
			<button type="submit" class="btn btn-primary"
				onclick="window.location.href = '/updateAdmin';">Update Admin Details</button>
			<br> <br>
			<form id="logoutForm" method="POST" action="/logout">
				<button type="submit" class="btn btn-success">Logout</button>
			</form>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>