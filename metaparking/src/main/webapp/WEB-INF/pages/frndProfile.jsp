<%@include file="include/navbarTop.jsp" %>


<div  id="card" class="space">
	<div class="container">
		<div class="row">
			<div class="col-md-3 space imageshape">
				<div class="userdetails text-center">
					<div class="img">
							  <img src="/image/${ProfileImformation.profile}" class="rounded img-fluid" alt="${ProfileImformation.name}"> 
					</div>
					<div class="name">
					 <a href="/frndProfile/${ProfileImformation.id}"><h5>${ProfileImformation.name}</h5></a>
					</div>
				</div>
			</div>	
			
			<div class="col-md-8 space details">
				<div class="card">
					<div class="container">
						<h4>
							<b>Employee Id</b>
						</h4>
						<p>${ProfileImformation.id}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Email</b>
						</h4>
						<p>${ProfileImformation.email }</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Gender</b>
						</h4>
						<p>${ProfileImformation.gender}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Contact Number</b>
						</h4>
						<p>+91 ${ProfileImformation.mobileNumber}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Organisation</b>
						</h4>
						<p>${ProfileImformation.organisation}</p>
					</div>
					<hr>
				</div>
			</div>
		</div>
	</div>
</div>





<%@include file="include/navbarBottom.jsp" %>
