<!DOCTYPE html>
<%@page import="in.muthukumari.model.BankDetail"%>
<%@page import="java.util.Set"%>
<html xml:lang="java">
<head>
<title>Bank List</title>
<meta content="text/html; charset=utf-8" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<br/>
		<h4>LIST OF BANKS</h4>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th id="sno">SNO.</th>
					<th id="bankname">Bank Name</th>
				</tr>
			</thead>
			<tbody>
				<%
				Set<String> bankList = BankDetail.getBankName();
				int i = 0;
				for (String bankName : bankList) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=bankName%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>