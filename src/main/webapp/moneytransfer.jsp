<%@page import="java.text.SimpleDateFormat"%>
<%@page import="in.muthukumari.service.BankService"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Money Transfer</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="UpdateBankDetailServlet">
			<%
			String infoMSG = request.getParameter("infoMsg");
			if (infoMSG != null) {
				out.println("<p><font style=color:green>" + infoMSG + "</font>");
			}
			%>
			<article class="card-body mx-auto" style="max-width: 500px;">
				<div class="form-group">
					<h3>MONEY TRANSFER PAGE</h3>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<label>Sender Account Number :</label>
						</div>
						<div class="col">
							<select onchange="getBalanceAmount()" id="accNum"
								name="senderAccNum" required>
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
					</div>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<label>Sender Balance Amount (Rs.) :</label>
						</div>
						<div class="col">
							<%
							String amount = request.getParameter("amount");
							%>
							<input type="number" name="balanceAmount" id="balanceAmount"
								value="<%=amount%>" readonly required>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<label>Recipient Bank Name :</label>
						</div>
						<div class="col">
							<select id="bank-dropdown" name="bankName" required disabled>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<label>Recipient Account Number :</label>
						</div>
						<div class="col">
							<input type="tel" id="accountNumber" pattern="^\d{5,}$"
								onkeyup="accountNumberValidation()" placeholder="Account Number"
								title="Enter Valid Account Number" name="accNumber" disabled
								required>
						</div>
					</div>
				</div>
				<div class="form-group">
					<span id="MSG"></span>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<label>How much amount you want to transfer? (Rs.)</label>
						</div>
						<div class="col">
							<input type="number" min="1" name="transferAmount"
								id="transferAmount" disabled required
								onkeyup="checkBalanceAmount()">
						</div>
					</div>
				</div>
				<div class="form-group">
					<span id="AmountMsg"></span>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col">
							<button type="button" id="button" onclick="myFun()"
								class="btn btn-primary" disabled>conform</button>
						</div>
						<div class="col">
							<button type="submit" id="moneyButton" class="btn btn-success"
								disabled>Transfer Money</button>
						</div>
					</div>
				</div>
			</article>
			<script>
		//This method used to validate the account number
		function accountNumberValidation(){
			let bankName=document.querySelector("#bank-dropdown").value;
			let accountNumber=document.getElementById("accountNumber").value;
			let senderAccNum=document.getElementById("accNum").value;
			let goodColor="#66cc66";
			let badColor="#ff6666";
			let url="AccountNumberServlet?bankName="+bankName+"&accountNumber="+accountNumber;
			fetch(url).then(res=> res.json()).then(res=>{	
				if(res!=null){
					if(res==true && accountNumber!=senderAccNum){
						document.getElementById("MSG").style.color=goodColor;
						document.getElementById("MSG").innerHTML="Account Number validated Successfully";
						document.querySelector("#transferAmount").disabled=false;						
					}
					else{
						document.getElementById("MSG").style.color=badColor;
						document.getElementById("MSG").innerHTML = "Invalid Account Number";
						document.querySelector("#transferAmount").disabled=true;
					}
				}
				else{
				alert("unable to validate account number");
				}
			});					
		}
		//This method used for confirmation msg
		function myFun(){			
			var r=confirm("Do you want to Continue?");
			if(r==true){
				document.querySelector("#moneyButton").disabled=false;	
			}
			else{
				alert("You are not transfer money");
			}
		}
		function getBankNameList(){
			let url = "BankNameListServlet";
			fetch(url).then(res=> res.json()).then(res=>{
				let banks = res;
				let content = "";
				let i=1;
				for(let bankList of banks){ 
					content += "<option>"+bankList+"</option>";
					i++;
				}
				document.querySelector("#bank-dropdown").innerHTML= content;				
				});
			}
			getBankNameList();
			//This method used to get the sender's balance amount
		function getBalanceAmount(){
			let accNum=document.querySelector("#accNum").value;
			let url="GetBalanceAmountServlet?accNum="+ accNum;
			fetch(url).then(res=> res.json()).then(res=>{
			let amount = res;
			if(res!=null){
			document.querySelector("#balanceAmount").value = amount;
			document.querySelector("#bank-dropdown").disabled=false;
			document.querySelector("#accountNumber").disabled=false;
			}else{
			alert("unable to get balance amount");
			}
			});	
			}
			function checkBalanceAmount(){
				let senderAmount=parseFloat(document.querySelector("#balanceAmount").value);				
				let transferAmount=parseFloat(document.querySelector("#transferAmount").value);
				let goodColor="#66cc66";
				let badColor="#ff6666";				
				if(senderAmount < transferAmount){					
					document.getElementById("AmountMsg").style.color=badColor;
					document.getElementById("AmountMsg").innerHTML="You don't the enough amount";
					document.querySelector("#button").disabled=true;							
				}
				else{
					document.getElementById("AmountMsg").style.color=goodColor;
					document.getElementById("AmountMsg").innerHTML="You have the enough amount";
					document.querySelector("#button").disabled=false;				
				}				
			}
		</script>
		</form>
	</main>
</body>
</html>