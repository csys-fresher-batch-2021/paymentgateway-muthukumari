package in.muthukumari.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.model.CustomerDetail;
import in.muthukumari.service.CustomerDetailServer;

/**
 * Servlet implementation class CustomerDetailServlet
 */
@WebServlet("/CustomerDetailServlet")
public class CustomerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This servlet usd to get all the user details
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDetail customer = new CustomerDetail();
		CustomerBankDetail bank = new CustomerBankDetail();
		String userName = request.getParameter("name");
		String mobileNumber = request.getParameter("number");
		String password = request.getParameter("password");
		String bankName = request.getParameter("bankName");
		String accountNumber = request.getParameter("accountNumber");
		String ifsc = request.getParameter("ifscCode");
		CustomerDetail.customerName = userName;
		CustomerDetail.mobileNumber = Long.parseLong(mobileNumber);
		CustomerDetail.password = password;
		CustomerBankDetail.bankName = bankName;
		CustomerBankDetail.accountNumber = Long.parseLong(accountNumber);
		CustomerBankDetail.ifscCode = ifsc;
		boolean isAdded = CustomerDetailServer.addCustomerDetail(customer, bank);
		// Check d the Customer details is added or not
		if (isAdded) {
			String errorMessage = "Successfully Added";
			response.sendRedirect("AtmCardDetail.jsp?" + errorMessage);
		} else {
			String errorMessage = "Invalid Data";
			response.sendRedirect("CustomerDetail.jsp?" + errorMessage);
		}
	}

}
