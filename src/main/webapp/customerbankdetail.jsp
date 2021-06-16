<%@page import="in.muthukumari.controller.BankDetailsController"%>
<%@page import="java.util.Set"%>
<%@page import="in.muthukumari.dao.BankDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Customer Bank Detail</title>
<link rel="stylesheet" href="css/style.css">
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
					BankDetailsController bank = new BankDetailsController();
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
					Amount (Rs.)</label> <input type="tel" name="balanceAmount"
					placeholder="Balance Amount" pattern="[0-9.]{1,}" required>
				<em>Note: Enter Balance amount in your account(Rs.)</em> <br /> <br />
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
				<div class="wrap">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit" class="button" id="submit" disabled>submit</button>
					<br /> <br />
					<p style="text-align: center">
						If the account number<br /> is not validated successfully,<br />The
						button is not clickable
					</p>
				</div>
				<%
				String errorMsg = request.getParameter("errorMsg");
				String encodedErrorMsg = org.owasp.encoder.Encode.forHtml(errorMsg);
				if (errorMsg != null) {
					out.println("<br/><p style='font-size:25px'>&#128542" + encodedErrorMsg);
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