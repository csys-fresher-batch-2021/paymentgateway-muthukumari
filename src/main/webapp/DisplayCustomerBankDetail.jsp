<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Customer Bank Detail</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2><%out.println("&#129321"); %>Account Created successfully!</h2>
		<table>
			<caption>Customer bank Detail</caption>
			<thead>
				<tr>
					<th scope="col">Customer Bank Detail</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Name :</td>
					<td>
						<%
						String name = (String)session.getAttribute("name");
						String bankName = (String)session.getAttribute("bankName");
						String branchName = (String)session.getAttribute("branchName");
						String ifsc = (String)session.getAttribute("ifsc");
						String accNumber =(String)session.getAttribute("accNumber");
						String atmNum = (String)session.getAttribute("atmNum");
						String atmPinNum =(String)session.getAttribute("atmPinNum");
						String mobileNum = (String)session.getAttribute("mobileNum");
						%> <%=name%></td>
				</tr>
				<tr>
					<td>Bank Name :</td>
					<td><%=bankName%></td>

				</tr>
				<tr>
					<td>Branch Name :</td>
					<td><%=branchName%></td>
				</tr>
				<tr>
					<td>Ifsc Code :</td>
					<td><%=ifsc%></td>
				</tr>
				<tr>
					<td>Account Number :</td>
					<td><%=accNumber%></td>
				</tr>
				<tr>
					<td>ATM Card Number :</td>
					<td><%=atmNum%></td>
				</tr>
				<tr>
					<td>ATM Pin Number :</td>
					<td><%=atmPinNum%></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><%=mobileNum%></td>
				</tr>
			</tbody>
		</table>
	</main>
</body>
</html>