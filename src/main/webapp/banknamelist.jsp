<%@page import="in.muthukumari.dao.BankDAO"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style2.css">
<title>Bank List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<br />
		<%
		String infoMsg = request.getParameter("infoMsg");
		String encodedMsg = org.owasp.encoder.Encode.forHtml(infoMsg);
		if (encodedMsg != null) {
			out.println("<p><font style=color:red>" + encodedMsg + "</font>");
		}
		%>
		<h3 class="h2">LIST OF BANKS</h3>
		<br />

		<div class="table-wrapper">
			<table class="fl-table">
				<caption>List of Banks</caption>
				<thead>
					<tr>
						<th scope="col">SNO.</th>
						<th scope="col">BANK NAME</th>
						<th scope="col">ACCOUNT CREATION</th>
					</tr>
				<tbody id="bank-table">
				</tbody>
			</table>
		</div>
	</main>
	<script>
		//This method used to get the bank name list
		function getBankNameList(){
		let url = "BankNameListServlet";
		fetch(url).then(res=> res.json()).then(res=>{
			let banks = res;
			let content = "";
			let i=1;
			for(let bankList of banks){ 
				content += "<tr><td>"+i+
				"</td><td>"+bankList+
				"</td><td><a class=\"button\"href=\"customerbankdetail.jsp?bankName="+bankList+"\">Create Account</a></td></tr>";
				i++;
			}
			document.querySelector("#bank-table").innerHTML= content;
			});
		}
		getBankNameList();
		</script>
</body>
</html>