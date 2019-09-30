<%@include file="include/navbarTop.jsp" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<div class="container space1">
		<div class="row">
			<div class="col-md-3 ">
			</div>
			<div class="col-md-6 formPart">
				<div class="space">
				<c:if test="${not empty Success}">
				<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>Success!</strong> ${Success}
				</div>
				</c:if>
				<h5 class="text-center text-muted">Vechile Registration From</h5>
				</div>
				<div class="container">
				  <form:form modelAttribute="vechile">
				    <div class="form-group">
				   		<form:label path="name">Name:</form:label> 
						<form:input path="name" cssClass="form-control" id="name" placeholder="Enter Your Vechile name" />
						<form:errors cssClass="error text-danger" path="name"/> 
				    </div>
				   	<div class="form-group">
				   		<label path="type">Type</label>
				    	<form:select id="organisation" path="type" class="form-control">
				    		<form:option value="none"  disabled="true">Select Your Vechile</form:option>
				    		<form:option value="Cycle">Cycle</form:option>
				    		<form:option value="MotorCycle">MotorCycle</form:option>
				    		<form:option value="FourWheelers">Four Wheelers</form:option>
				    		<form:errors cssClass="error text-danger" path="type"/> 
				   		</form:select>
				    </div>
				    <div class="form-group">
				     	<form:label path="number">Vechile Number:</form:label> 
						<form:input path="number" cssClass="form-control" id="number" placeholder="Enter Your Vechile Number" />
						<form:errors cssClass="error text-danger" path="number"/> 
				    </div> 
				    <div class="form-group">
						<form:label path="empId">Name:</form:label> 
						<form:input path="empId" value="43" cssClass="form-control" id="empId" placeholder="Enter Your Employee Id" readonly="true"/>
						<form:errors cssClass="error text-danger" path="empId"/> 				    
					</div>
				 	<div class="form-group">
				      <form:textarea class="form-control" id="identify" rows="5" cols="10" path="identify" placeholder="Enter your Identification"></form:textarea>
				      <form:errors cssClass="error text-danger" path="identify"/> 
				    </div>
				    <button type="submit" class="btn btn-primary">Register</button>
				  </form:form>
			   </div>
			</div>
			<div class="col-md-3 space">
			</div>
		</div>
	</div>
	
<%@include file="include/navbarBottom.jsp" %>
