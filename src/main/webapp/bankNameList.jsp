<%@page import="in.muthukumari.dao.BankDAO"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.h2 {
	font-family: Times new roman;
	font-size: 20px;
	text-align: center;
	text-shadow: 0 2px #999;
	color:#08436e;
}

.button {
	font-family: Times new roman;
	padding: 5px 19px;
	font-size: 20px;
	text-align: center;
	cursor: pointer;
	outline: none;
	color: #fff;
	background-color: #3063d1;
	border: none;
	border-radius: 15px;
	box-shadow: 0 7px #999;
	padding: 5px 19px;
}

.button:hover {
	background-color: #04266e
}

.button:active {
	background-color: #3e8e41;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}

* {
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
}

body {
	-webkit-font-smoothing: antialiased;
	background: rgba(71, 147, 227, 1);
}
/* Table Styles */
.table-wrapper {
	margin: 10px 70px 70px;
	box-shadow: 0px 35px 50px 50px rgba(0, 0, 0.1, 0.2);
}

.fl-table {
	font-family: Times new roman;
	border-radius: 5px;
	font-size: 30px;
	font-weight: normal;
	border: none;
	border-collapse: collapse;
	width: 100%;
	max-width: 100%;
	white-space: nowrap;
	background-color: white;
}

.fl-table td, .fl-table th {
	text-align: center;
	padding: 8px;
}

.fl-table td {
	border-right: 1px solid #f8f8f8;
	font-size: 25px;
}

.fl-table thead th {
	color: #ffffff;
	background: #4FC3A1;
}

.fl-table thead th:nth-child(odd) {
	color: #ffffff;
	background: #324960;
}

.fl-table tr:nth-child(even) {
	background: #F8F8F8;
}

/* Responsive */
@media ( max-width : 767px) {
	.fl-table {
		display: block;
		width: 100%;
	}
	.table-wrapper:before {
		content: "Scroll horizontally >";
		display: block;
		text-align: right;
		font-size: 11px;
		color: white;
		padding: 0 0 10px;
	}
	.fl-table thead, .fl-table tbody, .fl-table thead th {
		display: block;
	}
	.fl-table thead th:last-child {
		border-bottom: none;
	}
	.fl-table thead {
		float: left;
	}
	.fl-table tbody {
		width: auto;
		position: relative;
		overflow-x: auto;
	}
	.fl-table td, .fl-table th {
		padding: 20px .625em .625em .625em;
		height: 60px;
		vertical-align: middle;
		box-sizing: border-box;
		overflow-x: hidden;
		overflow-y: auto;
		width: 120px;
		font-size: 13px;
		text-overflow: ellipsis;
	}
	.fl-table thead th {
		text-align: left;
		border-bottom: 1px solid #f7f7f9;
	}
	.fl-table tbody tr {
		display: table-cell;
	}
	.fl-table tbody tr:nth-child(odd) {
		background: none;
	}
	.fl-table tr:nth-child(even) {
		background: transparent;
	}
	.fl-table tr td:nth-child(odd) {
		background: #F8F8F8;
		border-right: 1px solid #E6E4E4;
	}
	.fl-table tr td:nth-child(even) {
		border-right: 1px solid #E6E4E4;
	}
	.fl-table tbody td {
		display: block;
		text-align: center;
	}
}
</style>
<title>Bank List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br/><br/>
		<h3 class="h2">LIST OF BANKS</h3><br/>

		<div class="table-wrapper">
			<table class="fl-table">
				<thead>
					<tr>
						<th scope="col">SNO.</th>
						<th scope="col">BANK NAME</th>
						<th scope="col">ACCOUNT CREATION</th>
					</tr>
				<tbody>
					<%
					Set<String> banks = BankDAO.getBankNameList();
					int i = 0;
					for (String bankNameList : banks) {
						i++;
					%>
					<tr>
						<td><%=i%></td>
						<td><%=bankNameList%></td>
						<td><a
							href="CustomerBankDetail.jsp?bankName=<%=bankNameList%>"
							class="button">Create Account</a>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</main>
</body>
</html>