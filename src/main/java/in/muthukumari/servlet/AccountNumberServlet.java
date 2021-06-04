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

import org.owasp.encoder.Encode;

import com.google.gson.Gson;
import java.util.logging.Logger;

/**
 * Servlet implementation class AccountCreationServlet
 */
@WebServlet("/AccountNumberServlet")
public class AccountNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * @return
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		CustomerBankDetail customer = new CustomerBankDetail();
		try {
			String accountNumber = request.getParameter("accountNumber");
			long accountNumberLong = Long.parseLong(accountNumber);
			customer.setAccountNumber(accountNumberLong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String bankName = request.getParameter("bankName");
		customer.setBankName(bankName);
		String errorMessage;
		Gson gson = new Gson();
		boolean isValidAccountNumber = false;
		try {
			// validate the account number length
			isValidAccountNumber = BankDetailService.isValidAccountNumber(customer);
		} catch (ServiceException e) {
			logger.info(e.getMessage());
		}
		if (isValidAccountNumber) {
			errorMessage = "Account number validated successfully";
			String encodeMsg=Encode.forHtml(errorMessage);
			String json = gson.toJson(encodeMsg);
			try {
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
			} catch (IOException e) {
				logger.info(e.getMessage());
			}
		} else {
			errorMessage = "Invalid Account Number";
			String encodeMsg=Encode.forHtml(errorMessage);
			String json = gson.toJson(encodeMsg);
			try {
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
			} catch (IOException e) {
				logger.info(e.getMessage());
			}
		}

	}

}
