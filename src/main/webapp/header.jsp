<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<header>
<%String loggedInUserName=(String)session.getAttribute("loggedInUserName"); %>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Money-Transfer App</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="banknamelist.jsp">Banks</a>
			</ul>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<% if(loggedInUserName ==null){ %>
				<li class="nav-item active"><a class="nav-link"
					href="LoginJSP.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="registration.jsp">Register</a>
				</li>
				<% } %>
			</ul>
		</div>
	</nav>
</header>