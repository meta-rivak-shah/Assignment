<%@include file="include/navbarTop.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div class="container space">
		<div class="row space">
		 <c:if test="${not empty VechileData}">
		    <c:forEach var="vechileData" items="${VechileData}" varStatus="loopcounter">
					<div class="col-md-4">
						<a style="text-decoration: none; color:black;" href="takeGatePass/${vechileData.id}"><h2>Vechile Name</h2><h4>${vechileData.name}</h4></a>
						<a style="text-decoration: none; color:black;" href="takeGatePass/${vechileData.id}"><h2>Vechile Number</h2><h4>${vechileData.number}</h4></a>
						<a style="text-decoration: none;" href="takeGatePass/${vechileData.id}" class="btn btn-primary btn-block">Take Pass</a>
					</div>
			</c:forEach>
	 	 </c:if>
	 	 </div>
	</div>
	
<%@include file="include/navbarBottom.jsp" %>
