<%@include file="include/header.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
	<div class="container space">
		<div class="row">
			<div class="col-md-3">
			</div>
			<div class="col-md-6 formPart">
				<div class="space">
				<c:if test="${ not empty duplicateEmail}">
					<div class="alert alert-warning alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Warning!</strong> ${duplicateEmail }
				</div>
				</c:if>
				<c:if test="${ not empty sqlException}">
					<div class="alert alert-danger alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>Danger!</strong> ${sqlException }
					</div>
				</c:if>
				
				<h5 class="text-center text-muted">Parking Registration From</h5>
				</div>
				<div class="container">
				  <form:form modelAttribute="employeeRegister">
					 <div class="form-group">
						<form:label path="name">Name:</form:label> 
						<form:input path="name" cssClass="form-control" id="name" placeholder="Enter Your Name" />
						<form:errors cssClass="error text-danger" path="name"/> 
					 </div>
				    <div class="form-group">
						<form:label path="email">Email:</form:label> 
						<form:input path="email" cssClass="form-control" id="email" placeholder="Enter Your Email" />
						<form:errors cssClass="error text-danger" path="email"/> 
					 </div>
				    <div class="form-group">
						<form:label path="password">Password:</form:label> 
						<form:password path="password" cssClass="form-control" id="password" placeholder="Enter Your Password" />
						<form:errors cssClass="error text-danger" path="password"/> 
					 </div>
				     <div class="form-group">
						<form:label path="confirmPassword">Confirm Password:</form:label> 
						<form:password path="confirmPassword" cssClass="form-control" id="confirmPassword" placeholder="Enter Your Confirm Password" />
						<form:errors cssClass="error text-danger" path="confirmPassword"/> <br>
						<form:errors path="${confirmPassword}" class="error" />
					 </div>
				    <div class="form-group">
						<form:label path="mobileNumber">Mobile Number</form:label> 
						<form:input path="mobileNumber" cssClass="form-control" id="mobileNumber" placeholder="Enter Your Mobile Number" />
						<form:errors cssClass="error text-danger" path="mobileNumber"/> 
					 </div>
				    <div class="form-group">
				      <form:label path="gender">Gender:&nbsp &nbsp</form:label>
				      <label><form:radiobutton path="gender" value="Male"/>Male</label>&nbsp &nbsp
				      <label><form:radiobutton path="gender" value="Female"/>Female</label>&nbsp &nbsp
				      <label><form:radiobutton path="gender" value="Other"/>Other</label>&nbsp &nbsp
				      <form:errors cssClass="error text-danger" path="gender"/> 
				    </div>
				    
				    <div class="form-group">
				    	<form:select id="organisation" path="organisation" class="form-control">
				    		<form:option value="none"  disabled="true">Select Your Organization</form:option>
				    		<form:option value="METACUBE">MetaCube</form:option>
				    		<form:option value="TCS">TCS</form:option>
				    		<form:option value="INFOSYS">INFOSYS</form:option>
				    		<form:option value="SHARVIS">SHARVIS</form:option>
				    		<form:errors cssClass="error text-danger" path="organisation"/> 
				   		</form:select>
				    </div>
				    <button type="submit" class="btn btn-primary">Register</button>
				  </form:form>
				  <div class="space textManage">
					<h5 class="text-center text-muted">If You already Register</h5>
					<span class="text-center text-muted">For Login <span><a  href="home">Login</a></span></span>
				</div>
			   </div>
			</div>
			<div class="col-md-3">
			</div>
		</div>
	</div>
	
<%@include file="include/footer.jsp" %>