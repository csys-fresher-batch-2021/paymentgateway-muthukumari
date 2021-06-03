package in.muthukumari.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.muthukumari.exception.CustomerRepeatedException;
import in.muthukumari.exception.DBException;
import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.service.CustomerBankDetailService;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerBankDetail customer = new CustomerBankDetail();
		// Declare customer bank details
		String name = request.getParameter("name");
		String bankName = request.getParameter("bankName");
		String branchName = request.getParameter("branchName");
		String ifsc = request.getParameter("ifsc");
		String accNumber = request.getParameter("accNumber");
		long accNumberLong = Long.parseLong(accNumber);
		String mobileNumber = request.getParameter("mobileNum");
		long mobileNumberLong = Long.parseLong(mobileNumber);
		String atmPinNumber = request.getParameter("atmPinNum");
		int atmPinNumberInt = Integer.parseInt(atmPinNumber);
		String atmNum = request.getParameter("atmNum");
		long atmNumberLong = Long.parseLong(atmNum);
		String balanceAmount = request.getParameter("balanceAmount");
		double balanceAmonuDob = Double.parseDouble(balanceAmount);
		// set customer bank details to the CustomerBankDetail class
		customer.setUserName(name);
		customer.setBankName(bankName);
		customer.setBranchName(branchName);
		customer.setIfscCode(ifsc);
		customer.setBalanceAmount(balanceAmonuDob);
		customer.setAccountNumber(atmNumberLong);
		customer.setAtmNumber(atmNumberLong);
		customer.setAtmPinNumber(atmPinNumberInt);
		customer.setMobileNumber(mobileNumberLong);
		response.sendRedirect("DisplayCustomerBankDetail.jsp?" + "name=" + name + "&bankName=" + bankName
				+ "&branchName=" + branchName + "&ifsc=" + ifsc + "&accNumber=" + accNumber + "&atmNum=" + atmNum
				+ "&atmPinNum=" + atmPinNumber + "&mobileNum=" + mobileNumber + "&balanceAmount=" + balanceAmount);

	}

}
