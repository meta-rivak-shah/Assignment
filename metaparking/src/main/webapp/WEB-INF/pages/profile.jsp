<%@include file="include/navbarTop.jsp" %>


<div  id="card" class="space">
	<div class="container">
		<div class="row">
			<div class="col-md-3 space imageshape">
				<div class="userdetails text-center">
					<div class="img">
							  <img src="/image/${EmployeeDetails.profile}" class="rounded img-fluid" alt="${ProfileImformation.name}"> 
					</div>
					<div class="name">
					 <a href="Profile"><h5>${EmployeeDetails.name}</h5></a>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<a href="editProfile"><button type="button" class="btn btn-primary btn-block">Edit Profile</button></a>
			`		</div>
				</div>
			</div>	
			
			<div class="col-md-8 space details">
				<div class="card">
					<div class="container">
						<h4>
							<b>Employee Id</b>
						</h4>
						<p>${EmployeeDetails.id}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Email</b>
						</h4>
						<p>${EmployeeDetails.email}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Gender</b>
						</h4>
						<p>${EmployeeDetails.gender}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Contact Number</b>
						</h4>
						<p>+91 ${EmployeeDetails.mobileNumber}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Organisation</b>
						</h4>
						<p>${EmployeeDetails.organisation}</p>
					</div>
					<hr>
				</div>
			</div>
		</div>
	</div>
</div>





<%@include file="include/navbarBottom.jsp" %>
