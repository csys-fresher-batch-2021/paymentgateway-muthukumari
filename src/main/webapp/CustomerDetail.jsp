<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="in.muthukumari.model.CustomerDetail"%>
<%@page import="java.util.List"%>
<%@page import="in.muthukumari.service.CustomerDetailServer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="CustomerDetailServlet">
			<h4>REGISTRATION PAGE</h4>
			<table>
				<tbody>
					<tr>
						<td><label>Name</label></td>
						<td><input type="text" name="name"
							pattern="[^0-9@$%^=()./#&+-]{3,}" required
							title="contains only upper and lowercase(min 3 char) without special character and numbers"
							autofocus></td>
					</tr>
					<tr>
						<td><label>Phone Number</label></td>
						<td><input type="number" pattern="[0-9]{10}" name="number"
							title="Mobile Number Must Contains 10 digit number" required></td>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td><input type="password" pattern="[0-9@$%^=()./#&+-]{5}"
							name="password" required></td>
					</tr>
					<tr>
						<td><label>IFSC Code</label></td>
						<td><input id="ifscCode" name="ifscCode"
							onkeyup="enableDropDown()"></td>
					</tr>

					<tr>
						<td><label>Bank Name</label></td>
						<td><select id="bankName" name="bankName" disabled>
								<option>-------SELECT BANK-------</option>
								<option value="IndianBank">Indian Bank</option>
								<option value="IndianOverseasBank">Indian Overseas bank</option>
								<option value="CanaraBank">Canara bank</option></td>
						</select>
					</tr>
					<tr>
						<td><label>Account Number</label></td>
						<td><input type="number" name="accountNumber" required></input></td>
					</tr>
					<tr>
						<td><label>Balance Amount</label></td>
						<td><input type="number" name="balanceAmount" required></td>
					</tr>

					<tr>
						<td><button type="submit" id="btn" class="btn btn-primary">Register</button></td>
						<td><button type="reset" class="btn btn-danger">Reset</button></td>
					</tr>
				</tbody>
			</table>
		</form>
		<script>
			function enableDropDown() {
				let bankName = document.querySelector("#bankName").value;
				//console.log("bank",bankName)
				let ifsc1 = document.querySelector("#ifscCode").value;
				//
				if (ifsc1.trim() != "null" && ifsc1.trim() != "") {
					document.querySelector("#bankName").disabled = false;
				} else {
					document.querySelector("#bankName").disabled = true;
				}

			}
		</script>
	</main>
</body>
</html>