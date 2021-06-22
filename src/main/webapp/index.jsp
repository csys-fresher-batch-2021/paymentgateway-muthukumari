<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>PaymentGatewayApp</title>
<STYLE type="text/css">
h1 {
	text-align: center
}
</STYLE>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String infoMsg = (String) session.getAttribute("infoMSG");
		if (infoMsg != null) {
			out.println("<p><font style=color:green>" + infoMsg + "</font>");
			session.removeAttribute("infoMSG");
		}
		String infoMSG = request.getParameter("infoMsg");	
		String encodedMsg = org.owasp.encoder.Encode.forHtml(infoMSG);
		if (infoMSG != null) {
			out.println("<p><font style=color:green>" + encodedMsg + "</font>");
		}
		%>
		<br /> <br /> <br /> <br />
		<p style="text-align: center;">
			<img
				src="https://cdn2.iconfinder.com/data/icons/banking1/128/Banking-Set1-24-512.png"
				width=300 height=200 alt="money transfer image" />
		</p>
		<h1>
			Welcome<br /> to<br />Online Payment Gateway<br /> <br />
		</h1>
	</main>
</body>
</html>