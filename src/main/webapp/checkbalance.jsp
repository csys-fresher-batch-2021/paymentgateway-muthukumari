<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Checking page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form>
			<article class="card-body mx-auto" style="max-width: 500px;">
				<div class="form-group">
					<h3>Balance Amount Checking Page</h3>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<label>Select your account number :</label>
						</div>
						<div class="col">
							<select id="accNum" name="senderAccNum" required>
								<option disabled selected>--SELECT--</option>
								<%
								List<Long> accNumList = (ArrayList<Long>) session.getAttribute("accNum");
								for (long accNum : accNumList) {
								%>
								<option><%=accNum%></option>
								<%
								}
								%>
							</select>
						</div>
						<em>Note: The given account number(s) is/are connected with
							your phone number</em>
					</div>
				</div>
				<article class="card-body mx-auto" style="max-width: 200px;">
					<div class="form-group">
						<button type="button" onclick="getBalanceAmount()"
							class="btn btn-primary">Submit</button>
					</div>
				</article>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<label>Your Balance Amount is: (Rs.)</label>
						</div>
						<div class="col">
							<%
							String amount = request.getParameter("amount");
							String encodedAmount = org.owasp.encoder.Encode.forHtml(amount);
							%>
							<input type="number" name="balanceAmount" id="balanceAmount"
								value="<%=encodedAmount%>" readonly required>
						</div>
					</div>
				</div>
			</article>
		<script>
		function getBalanceAmount(){			
		let accNum=document.querySelector("#accNum").value;
		let url="GetBalanceAmountServlet?accNum="+ accNum;
		fetch(url).then(res=> res.json()).then(res=>{
		let amount = res;
		if(res!=null){
		document.querySelector("#balanceAmount").value = amount;
		}else{
		alert("unable to get balance amount");
		}
		});	
		}		
		</script>
		</form>
	</main>
</body>
</html>