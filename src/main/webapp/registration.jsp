<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="" method="post">
			<article class="card-body mx-auto" style="max-width: 500px;">
				<div class="form-group">
					<h3>Registration Page</h3>
				</div>
				<div class="form-group">
					<input required type="tel" name="phoneNumber" id="phone"
						pattern="^([6-9]{1})+([0-9]{9})$" class="form-control"
						placeholder="Enter Your Mobile Number" autofocus />
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<input type="text" name="firstName" pattern="[A-Za-z].{2,}"class="form-control" placeholder="First name" required>
						</div>
						<div class="col">
							<input type="text" name="lastName" pattern="[A-Za-z].{2,}" class="form-control" placeholder="Last name" required>
						</div>
					</div>
				</div>
				<div class="form-group">
					<input class="form-control" required type="text" name="email"
						id="email" placeholder="Email Address"
						pattern="^[A-Za-z0-9+_.-]+@(.+)$" />
					<div class="status" id="status"></div>
				</div>

				<div class="form-group">
					<input class="form-control" type="text" name="userName" id="userName"
						pattern="[A-Za-z].{3,}"  placeholder="Enter User Name" onkeyup="checkUserName()"required />
						<span id="userNameMsg"></span>
						
					<div id="errLast"></div>
				</div>

				<div class="form-group">
					<input required name="password" type="password"
						placeholder="Password" class="form-control inputpass" pattern="[a-zA-Z0-9/@$#%^&*()!'].{4,10}"
						 id="password" />
						 <em>Note: min 5 characters max 10 characters.</em>
				</div>
				<div class="form-group">
					<input required name="conformPassword" type="password"
						class="form-control inputpass" pattern="[a-zA-Z0-9/@$#%^&*()!'].{4,10}"
						placeholder="Conform Password" id="pass2"
						onkeyup="checkPassword()" /> 
						<span id="confirmMessage"
						class="confirmMessage"></span>
				</div>

				<div class="form-group">
					<input class="btn btn-success" type="submit"
						value="Register">
				</div>
			</article>
		</form>
		<script>
		function checkUserName(){
			let userName=document.querySelector("#userName").value;
			let url="UserNameValidationServlet?userName="+userName;
			fetch(url).then(res=> res.json()).then(res=>{
				let ifscCode = res;
				if(res!=null){
					if(res=="valid"){
						document.getElementById("userNameMsg").innerHTML = "Paragraph changed!";
					}
				}
		}</script>
	</main>
</body>
</html>