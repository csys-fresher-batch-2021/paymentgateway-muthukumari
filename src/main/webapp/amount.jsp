<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Deposit Amount</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="DepositServlet">
			<article class="card-body mx-auto" style="max-width: 500px;">
				<article class="card-body mx-auto" style="max-width: 300px;">
					<%
					String errMsg = request.getParameter("errMsg");
					String encodedMsg = org.owasp.encoder.Encode.forHtml(errMsg);
					if (errMsg != null) {
						out.println("<p><font style=color:green>" + encodedMsg + "</font>");
					}
					%>
					<h3>*** DEPOSIT***</h3>
				</article>
				<%
				String accNum = request.getParameter("accNum");
				String encodedAccNum = org.owasp.encoder.Encode.forHtml(accNum);
				%>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<label>Account Number :</label>
						</div>
						<div class="col">
							<input type="number" name="accNum" value="<%=encodedAccNum%>" readonly>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<label>Howmuch amount you want to transfer ?</label>
						</div>
						<div class="col">
							<input type="number" name="amount" required min=1 step=".001" max=10000000 required>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Deposit</button>
				&nbsp;
				<button type="reset" class="btn btn-danger">Cancel</button>
			</article>
		</form>
	</main>
</body>
</html>