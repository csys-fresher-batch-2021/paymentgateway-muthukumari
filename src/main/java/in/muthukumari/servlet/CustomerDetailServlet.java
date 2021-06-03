package in.muthukumari.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.muthukumari.model.CustomerBankDetail;

/**
 * Servlet implementation class CustomerDetailServlet
 */
@WebServlet("/CustomerDetailServlet")
public class CustomerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerBankDetail customer = new CustomerBankDetail();
		// Declare customer bank details
		String name = request.getParameter("name");
		String bankName = request.getParameter("bankName");
		String branchName = request.getParameter("branchName");
		String ifsc = request.getParameter("ifsc");
		String accNumber = request.getParameter("accNumber");
		String mobileNumber = request.getParameter("mobileNum");

		String atmPinNumber = request.getParameter("atmPinNum");

		String atmNum = request.getParameter("atmNum");

		String balanceAmount = request.getParameter("balanceAmount");
		try {
		long accNumberLong = Long.parseLong(accNumber);
		long mobileNumberLong = Long.parseLong(mobileNumber);
		int atmPinNumberInt = Integer.parseInt(atmPinNumber);
		long atmNumberLong = Long.parseLong(atmNum);
		double balanceAmonuDob = Double.parseDouble(balanceAmount);
		customer.setBalanceAmount(balanceAmonuDob);
		customer.setAccountNumber(accNumberLong);
		customer.setAtmNumber(atmNumberLong);
		customer.setAtmPinNumber(atmPinNumberInt);
		customer.setMobileNumber(mobileNumberLong);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// set customer bank details to the CustomerBankDetail class
		customer.setUserName(name);
		customer.setBankName(bankName);
		customer.setBranchName(branchName);
		customer.setIfscCode(ifsc);
		
		try {
			response.sendRedirect("DisplayCustomerBankDetail.jsp?" + "name=" + name + "&bankName=" + bankName
					+ "&branchName=" + branchName + "&ifsc=" + ifsc + "&accNumber=" + accNumber + "&atmNum=" + atmNum
					+ "&atmPinNum=" + atmPinNumber + "&mobileNum=" + mobileNumber + "&balanceAmount=" + balanceAmount);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
