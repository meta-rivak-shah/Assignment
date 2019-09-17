<%@include file="include/navbarTop.jsp" %>

<center>
<div class="coninter space">
	<div class="row">
		<div class="col-md-3">
			<h1></h1>
		</div>
		<div class="col-md-6 space">
				<c:if test="${not empty Success}">
					<h1 class="text-center">${Success}</h1>
					<h4 class="text-center">Your Total Amount is ${price } INR</h4>
				</c:if>
				<c:if test="${ empty Success}">
					<h1>Thanks for Taking pass</h1>
				</c:if>
			</div>
		<div class="col-md-3">
			<h1></h1>
		</div>
		
	</div>
</div>
</center>

<%@include file="include/navbarBottom.jsp" %>