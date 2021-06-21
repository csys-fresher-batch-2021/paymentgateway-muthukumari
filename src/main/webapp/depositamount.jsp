
<%@page import="in.muthukumari.model.CustomerBankDetail"%>
<%@page import="java.util.List"%>
<%@page import="in.muthukumari.controller.ExistCustomerController"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Deposit Page</title>
<style>
* {
	box-sizing: border-box;
}

#myInput {
	background-image: url('/css/searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}

#myTable {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #ddd;
	font-size: 18px;
}

#myTable th, #myTable td {
	text-align: left;
	padding: 12px;
}

#myTable tr {
	border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
	background-color: #f1f1f1;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<article class="card-body mx-auto" style="max-width: 400px;">
		<h3>*****Deposit Amount*****</h3>
		</article>
		<input type="text" id="myInput" onkeyup="myFunction()"
			placeholder="Search By Account Number...">
		<div class="form-group">		
		<%String infoMsg="Please Create an account"; %>
			<a class="btn btn-primary float-right" href="banknamelist.jsp?infoMsg=<%=infoMsg%>">+
				New</a>
		</div>
		<table id="myTable">
		<caption>Deposit Amount</caption>
			<tr class="header">
				<th style="width: 40%;" scope="col">Account Holders Name</th>
				<th style="width: 40%;" scope="col">Account Number</th>
				<th style="width: 30%;" scope="col">Deposit</th>
			</tr>
			<tbody>
				<%
				ExistCustomerController existCustomer=new ExistCustomerController();
				List<CustomerBankDetail> nameAndAccNumList = existCustomer.getNameAndAccNumList();
				int i = 0;
				for (CustomerBankDetail customer : nameAndAccNumList) {
					i++;
				%>
				<tr>
					<td><%=customer.getUserName()%></td>
					<td><%=customer.getAccountNumber()%></td>
					<td><a class="btn btn-success"
						href="amount.jsp?accNum=<%=customer.getAccountNumber()%>">Deposit</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<script>
		function myFunction() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[1];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>
	</main>
</body>
</html>