package in.muthukumari.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.muthukumari.exception.DBException;
import in.muthukumari.exception.numberException;
import in.muthukumari.model.CustomerBankDetail;
import in.muthukumari.validator.BankDetailValidator;

/**
 * Servlet implementation class AccountCreationServlet
 */
@WebServlet("/AccountNumberServlet")
public class AccountNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @return
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerBankDetail customer = new CustomerBankDetail();
		String accountNumber = request.getParameter("accountNumber");
		long accountNumberLong = Long.parseLong(accountNumber);
		customer.setAccountNumber(accountNumberLong);
		String bankName = request.getParameter("bankName");
		customer.setBankName(bankName);
		String errorMessage;
		Gson gson = new Gson();
		boolean isValidAccountNumber = false;
		try {
			//validate the account number length
			isValidAccountNumber = BankDetailValidator.isValidAccountNumber(customer);
		} catch (DBException e) {
			e.printStackTrace();
		}
		if (isValidAccountNumber) {
			errorMessage = "Account number validated successfully";
			String json = gson.toJson(errorMessage);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} else {
			errorMessage = "Invalid Account Number";
			String json = gson.toJson(errorMessage);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			}

	}

}
