<%@include file="include/navbarTop.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div id="card" class="space">
	<div class="container">
		<div class="row">
		 <c:if test="${not empty EmployeeFriend}">
    			 <c:forEach var="employeeFrnd" items="${EmployeeFriend}" varStatus="loopcounter">
			<div class="col-md-3 profileCARD">
    			<div class="userdetails text-center">
					<div class="img">
							  <img  src="/image/${employeeFrnd.profile}" class="rounded img-fluid" alt="${employeeFrnd.name}" heigth="150" width=""150">
					</div>
					<div class="name">
					 <a href="frndProfile/${employeeFrnd.id}"><h5>${employeeFrnd.name}</h5></a>
					</div>
				</div>	
			</div>
			</c:forEach>
	 	 </c:if>
		</div>
	</div>
</div>

<%@include file="include/navbarBottom.jsp" %>
