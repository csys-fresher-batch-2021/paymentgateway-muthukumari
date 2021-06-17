package in.muthukumari.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.muthukumari.exception.ServiceException;
import in.muthukumari.service.RecipientService;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		String accNumStr = request.getParameter("accNum");
		String amountStr = request.getParameter("amount");
		long accNum;
		double amount;
		try {
			accNum = Long.parseLong(accNumStr);
			amount = Double.parseDouble(amountStr);
			boolean isUpdated = RecipientService.updateAmount(accNum, amount);
			if (isUpdated) {
				String infoMsg = "Amount Deposited Successfully!!";
				response.sendRedirect("index.jsp?infoMsg=" + infoMsg);
			} else {
				String errMsg = "Sorry! Unable to deposit the amount";
				response.sendRedirect("index.jsp?errMsg=" + errMsg);
			}

		} catch (NumberFormatException | IOException | ServiceException e) {
			logger.info(e.getMessage());
		}

	}
}
