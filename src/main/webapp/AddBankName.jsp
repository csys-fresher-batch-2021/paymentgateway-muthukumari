<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Bank Name</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Bank Name</h3>
		<!-- <form action="addproduct_action.jsp">-->
		<form action="AddBankNameServlet">
			<label for="bankName">Bank Name</label> <input type="text"
				name="bankName" placeholder="Enter Bank Name" required autofocus />
			<br />
			<button type="submit">Submit</button>
		</form>
	</main>
</body>
</html>