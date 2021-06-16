<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="LoginServlet">
			<article class="card-body mx-auto" style="max-width: 500px;">
				<div class="form-group">
					<h3>Login Page</h3>
				</div>
				<div class="form-group">
					<input class="form-control" type="text" name="userName"
						id="userName" pattern="^(?=.*[a-zA-Z])(?=.*[0-9]).{5,10}$"
						placeholder="Enter User Name" required /> <span id="userNameMsg"></span>
					<div id="errLast"></div>
				</div>
				<div class="form-group">
					<input required name="password" type="password"
						placeholder="Password" class="form-control inputpass"
						pattern="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{5,10}$"
						id="password" />
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="submit" />
				</div>
				<div class="form-group">
					<label>New User?</label> <a href="registration.jsp">Register</a>
				</div>
				<%String errMsg=(String)session.getAttribute("errMSG");
				if(errMsg!=null){
					out.println("<p><font style=color:red>" + errMsg + "</font>");
					session.removeAttribute("errMSG");
				}				
				%>
			</article>
		</form>
	</main>
</body>
</html>