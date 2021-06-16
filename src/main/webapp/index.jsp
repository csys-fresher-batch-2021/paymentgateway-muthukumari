<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>MoneyTransferApp</title>
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
		<br /> <br /> <br /> <br /> <br /> <br />
		<p style="text-align: center;">
			<img
				src="https://www.justrechargenow.com/wp-content/uploads/2018/06/money-transfer-services.png"
				width=100 height=100 alt="money transfer image" />
		</p>
		<h1>
			Welcome<br /> to<br />Online Money Transfer<br /> <br />
		</h1>
	</main>
</body>
</html>