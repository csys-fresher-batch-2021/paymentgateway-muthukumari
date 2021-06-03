<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Bank Detail</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>Account Created successfully!</h2>
		<table>

			<tr>
				<td>
					<%
					String name = request.getParameter("name");
					String bankName = request.getParameter("bankName");
					String branchName = request.getParameter("branchName");
					String ifsc = request.getParameter("ifsc");
					String accNumber = request.getParameter("accNumber");
					String atmNum = request.getParameter("atmNum");
					String atmPinNum = request.getParameter("atmPinNum");
					String mobileNum = request.getParameter("mobileNum");
					%> <%=name%></td>
			</tr>
			<tr>
				<td><%=bankName%></td>

			</tr>
			<tr>
				<td><%=branchName%></td>
			</tr>
			<tr>
				<td><%=ifsc%></td>
			</tr>
			<tr>
				<td><%=accNumber%></td>
			</tr>
			<tr>
				<td><%=atmNum%></td>
			</tr>
			<tr>
				<td><%=atmPinNum%></td>
			</tr>
			<tr>
				<td><%=mobileNum%></td>
			</tr>
		</table>
	</main>
</body>
</html>