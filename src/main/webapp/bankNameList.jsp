<%@page import="in.muthukumari.service.BankDetailServer"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>LIST OF BANKS</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">SNO.</th>
					<th scope="col">BANK NAME</th>
				</tr>
			<tbody>
				<%
				Set<String> banks = BankDetailServer.getBankList();
								int i = 0;
								for (String bankNameList : banks) {
									i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=bankNameList%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a class="btn btn-primary" href="AddBankName.jsp">Add Bank</a>
	</main>
</body>
</html>