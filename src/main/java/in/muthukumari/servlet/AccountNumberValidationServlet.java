package in.muthukumari.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.muthukumari.exception.ServiceException;
import in.muthukumari.model.*;
import in.muthukumari.service.BankDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.logging.Logger;

/**
 * Servlet implementation class AccountCreationServlet
 */
@WebServlet("/AccountNumberServlet")
public class AccountNumberValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * This servlet used to get the account number and transfer the validation rsult
	 * to the jsp page
	 * 
	 * @return
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		CustomerBankDetail customer = new CustomerBankDetail();
		String bankName = request.getParameter("bankName");
		customer.setBankName(bankName);
		boolean errorMessage;
		Gson gson = new Gson();
		boolean isValidAccountNumber = false;
		try {
			String accountNumber = request.getParameter("accountNumber");
			long accountNumberLong = Long.parseLong(accountNumber);
			customer.setAccountNumber(accountNumberLong);
			// validate the account number length
			isValidAccountNumber = BankDetailService.isValidAccountNumber(customer);
			if (isValidAccountNumber) {
				errorMessage = true;
			} else {
				errorMessage = false;
			}
			String json = gson.toJson(errorMessage);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (ServiceException | IOException e) {
			logger.info(e.getMessage());
		}
	}
}
