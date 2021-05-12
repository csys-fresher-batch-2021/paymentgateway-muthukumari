<<<<<<< HEAD:src/main/webapp/bankNameList.jsp
<%@page import="in.muthukumari.service.OperationsOnBankList"%>
<%@page import="in.muthukumari.model.BankDetail"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
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
					<th id="sno">SNO.</th>
					<th id="bankName">BANK NAME</th>
				</tr>
			<tbody>
				<%
				Set<String> banksName = OperationsOnBankList.getBankList();
				int i = 0;
				for (String bankNameList : banksName) {
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
=======
<%@page import="in.muthukumari.service.OperationsOnBankList"%>
<%@page import="in.muthukumari.model.BankDetail"%>
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
					<th id="sno">SNO.</th>
					<th id="bankName">BANK NAME</th>
				</tr>
			<tbody>
				<%
				Set<String> banksName = OperationsOnBankList.getBankList();
				int i = 0;
				for (String bankNameList : banksName) {
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
>>>>>>> origin:src/main/webapp/bankNameList.jsp
</html>