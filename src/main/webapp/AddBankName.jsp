<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Bank Name</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Bank Name</h3>
		<form action="AddBankServlet" method="get">
			<label for="bankName">Bank Name</label> <input type="text"
				pattern="[^0-9@$%^=()./#&+-]{3,}"
				title="contains only upper and lowercase(min 3 char) without special character and numbers"
				name="bankNameValue" placeholder="Enter Bank Name" required
				autofocus /> <br />
			<button type="submit">Submit</button>
		</form>
	</main>
</body>
</html>