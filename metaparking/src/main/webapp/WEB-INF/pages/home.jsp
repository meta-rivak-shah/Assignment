<%@include file="include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
	<div class="container space">
		<div class="row">
			<div class="col-md-3">
			</div>
			<div class="col-md-6 formPart">
				<div class="space">
					<h5 class="text-center text-muted">Parking Login From</h5>
				</div>
				<div class="container">
				<form:form modelAttribute="employeeCommand">
					<form:errors path="${authenticatedFailed}" class="error" />
					 <div class="form-group">
						<form:label path="email">Email:</form:label> 
						<form:input path="email" cssClass="form-control" id="email" placeholder="Enter Your Name" />
						<form:errors cssClass="error text-danger" path="email"/> 
					</div>
				
					<div class="form-group">
						<form:label path="password">Password:</form:label> 
						<form:password path="password" cssClass="form-control" id="password" placeholder="Enter Your Password" />
						<form:errors cssClass="error text-danger" path="password"/>
					</div>
					
					 <button type="submit" class="btn btn-primary">Login</button>
				 </form:form>
				  <div class="space textManage">
					<h5 class="text-center text-muted">If You Not Register</h5>
					<span class="text-center text-muted">For Registration <span><a  href="Register">SignUp</a></span></span>
				</div>
			   </div>
			</div>
			<div class="col-md-3">
			</div>
		</div>
	</div>
	
<%@include file="include/footer.jsp" %>