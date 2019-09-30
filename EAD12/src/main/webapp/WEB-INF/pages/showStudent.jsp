<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<title>Home page</title>
</head>
<body>
	
<div class="container text-center">
  <div class="row">
    <div class="col-sm-12">
      <h3>Operation 1</h3>
      <p>click on the link to go Home Page</p>
      <p class ="bg-light text-dark" style="text-decoration: none;"><a href="home">Home Page</a></p>
    </div>
  </div>
</div>

<div class="table-responsive">
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>#</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Father Name</th>
          <th>Class</th>
          <th>Email</th>
          <th>Age</th>
        </tr>
      </thead>
      <tbody>
      <c:if test="${not empty studentDetails}">
    	 <c:forEach var="student" items="${studentDetails}" varStatus="loopcounter">
    	
         <tr>
          <td> ${loopcounter.count }</td>
          <td> ${student.firstName }</td>
          <td> ${student.lastName}</td>
          <td> ${student.fatherName} </td>
          <td> ${student.studentClass }</td>
          <td> ${student.email}</td>
          <td> ${student.studentAge}</td>
        </tr>		
 	  	</c:forEach>
	  </c:if>
      </tbody>
    </table>
  </div>
	
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>