<%@page import="in.muthukumari.controller.BankDetailsController"%>
<%@page import="java.util.Set"%>
<%@page import="in.muthukumari.dao.BankDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<style>
.button {
	min-width: 120px;
	min-height: 10px;
	font-family: 'Nunito', sans-serif;
	font-size: 15px;
	text-transform: uppercase;
	letter-spacing: 1.3px;
	font-weight: 700;
	color: #313133;
	background: #4FD1C5;
	background: linear-gradient(90deg, rgba(129, 230, 217, 1) 0%,
		rgba(79, 209, 197, 1) 100%);
	border: none;
	border-radius: 1000px;
	box-shadow: 12px 12px 24px rgba(79, 209, 197, .64);
	transition: all 0.3s ease-in-out 0s;
	cursor: pointer;
	outline: none;
	position: relative;
	padding: 10px;
}

button::before {
	content: '';
	border-radius: 1000px;
	min-width: calc(120px + 12px);
	min-height: calc(35px + 12px);
	border: 6px solid #00FFCB;
	box-shadow: 0 0 60px rgba(0, 255, 203, .64);
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	opacity: 0;
	transition: all .3s ease-in-out 0s;
}

.button:hover, .button:focus {
	color: #313133;
	transform: translateY(-6px);
}

button:hover::before, button:focus::before {
	opacity: 1;
}

button::after {
	content: '';
	width: 30px;
	height: 30px;
	border-radius: 100%;
	border: 6px solid #00FFCB;
	position: absolute;
	z-index: -1;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	animation: ring 1.5s infinite;
}

button:hover::after, button:focus::after {
	animation: none;
	display: none;
}

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	outline: none;
	transition: all 0.3s ease;
	animation-delay: 0s;
}

body {
	background: #74ebd5;
	background: -webkit-linear-gradient(to bottom, #74ebd5, #acb6e5);
	background: linear-gradient(to bottom, #74ebd5, #acb6e5);
	font-size: 16px;
	line-height: 1.2;
	color: #888;
}

.pagewrap {
	max-width: 100%;
	height: 100vh;
	margin: 0 auto;
	display: flex;
	justify-content: center;
	align-items: center;
}

.form {
	width: 1000px;
	height: 580px;
	top: 0px;
	display: flex;
	align-items: center;
	flex-flow: column wrap;
	background-color: #ecedee;
	border-radius: 5px;
	@media
	(min-width:600px)
{
	max-width:380px;
}

}
@media ( min-width : 980px) and (max-width: 1400px) {
	width:35%;
}
</style>
<title>Customer Bank Detail</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="pagewrap">
			<form class="form" id="form" action="CustomerDetailServlet"
				method="post">
				<br />
				<h2>Customer Bank Detail</h2>
				<label>Name :</label> <input type="text" name="name"
					placeholder="Enter your name" pattern="^[a-zA-Z\s.]{3,}$" required
					autofocus> <em>Note: Name must be valid doesn't
					contains<br> number and special characters
				</em><br />
				<%
				String bankName = request.getParameter("bankName");
				String encodedName = org.owasp.encoder.Encode.forHtml(bankName);
				%>
				<label>Bank Name :</label> <input type="text"
					value="<%=encodedName%>" name="bankName" id="bankName" readonly><br />
				<label>Branch Name :</label> <select id="branchName"
					name="branchName" onchange="getIfscCode()" required>

					<option disabled selected>--------SELECT--------</option>
					<%
					BankDetailsController bank=new BankDetailsController();
					//Get the branch name list
					Set<String> branchNameList = bank.getBranchNameList(bankName);
					int i = 0;
					for (String brachNames : branchNameList) {
						i++;
					%>
					<option><%=brachNames%></option>
					<%
					}
					%>
				</select><br /> <label>IFSC Code :</label>
				<%
				//Get the ifsc code
				String ifsc = request.getParameter("ifsc");
				String encodedIfsc = org.owasp.encoder.Encode.forHtml(ifsc);
				%>
				<input type="text" id="ifsc" name="ifsc" value="<%=encodedIfsc%>"
					readonly required><br /> <label>Account Number :</label> <input
					type="tel" id="accountNumber" pattern="^\d{5,}$"
					onkeyup="accountNumberValidation()" placeholder="Account Number"
					title="Enter Valid Account Number" name="accNumber" required
					autofocus><br /> <span id="MSG"></span><br /> <br /> <label>ATM
					Card Number :</label> <input type="tel" pattern="^\d{16}$" name="atmNum"
					placeholder="ATM card number" required> <em>Note: ATM
					card number must be 16 digits</em><br /> <br /> <label>ATM Pin
					Number :</label> <input type="tel" pattern="^\d{4}$" name="atmPinNum"
					placeholder="ATM pin number" required> <em>Note: ATM
					pin number must be 4 digits</em><br /> <br /> <label>Mobile
					Number :</label> <input type="tel" id="mobileNum" name="mobileNum"
					placeholder="Mobile number" pattern="^\d{10}$" required> <em>Note:
					Mobile number must be 10 digits</em><br /> <br /> <label>Balance
					Amount :</label> <input type="tel" name="balanceAmount"
					placeholder="Balance Amount" pattern="[0-9.]{1,}" required>
				<em>Note: Enter Balance amount in your account</em> <br /> <br />
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
				<div class="wrap">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit" class="button" id="submit" disabled>submit</button><br/><br/>
					<p style="text-align:center">If the account number<br/> is not
						validated successfully,<br/>The button is not clickable</p>
				</div>
				<%
				String errorMsg = request.getParameter("errorMsg");
				String encodedErrorMsg = org.owasp.encoder.Encode.forHtml(errorMsg);
				if (errorMsg != null) {
					out.println("<br/><p style='font-size:25px'>&#128542"
					+ encodedErrorMsg);
				}
				%>
			</form>
		</div>

		<script>
		//This method used to get the ifsc code of the particular branch
		function getIfscCode()
		{
			let bankName=document.querySelector("#bankName").value;
			let branchName=document.querySelector("#branchName").value;
			let url="getIfscServlet?bankName="+ bankName+"&branchName="+branchName;
			fetch(url).then(res=> res.json()).then(res=>{
			let ifscCode = res;
			if(res!=null){
			document.querySelector("#ifsc").value = ifscCode;
			}
			else{
			alert("unable to get IFSC");
			}
			});			
			
		}
		//This method used to validate the account number
		function accountNumberValidation(){
			let bankName=document.querySelector("#bankName").value;
			let accountNumber=document.getElementById("accountNumber").value;
			let goodColor="#66cc66";
			let badColor="#ff6666";
			let url="AccountNumberServlet?bankName="+bankName+"&accountNumber="+accountNumber;
			fetch(url).then(res=> res.json()).then(res=>{	
				if(res!=null){
					if(res==true){
						document.getElementById("accountNumber").style.backgroundColor=goodColor;
						document.getElementById("MSG").style.color=goodColor;
						document.getElementById("MSG").innerHTML="Account Number validated Successfully";
						document.querySelector("#submit").disabled=false;						
					}
					else{
						document.getElementById("accountNumber").style.backgroundColor=badColor;
						document.getElementById("MSG").style.color=badColor;
						document.getElementById("MSG").innerHTML = "Invalid Account Number";
						document.querySelector("#submit").disabled=true;
					}
				}
				else{
				alert("unable to validate account number");
				}
			});					
		}	
		function preventBack(){
			window.history.forward();
		}
		setTimeout("preventBack()",0);
		window.onunload=function(){null};
		</script>
	</main>
</body>
</html>