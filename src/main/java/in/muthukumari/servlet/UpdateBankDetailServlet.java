package in.muthukumari.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.muthukumari.exception.ServiceException;
import in.muthukumari.model.Recipient;
import in.muthukumari.service.RecipientService;

/**
 * Servlet implementation class UpdateBankDetailServlet
 */
@WebServlet("/UpdateBankDetailServlet")
public class UpdateBankDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String senderAccNumStr = request.getParameter("senderAccNum");
		String balanceAmountStr = request.getParameter("balanceAmount");
		String accNumStr = request.getParameter("accNumber");
		String transferAmountStr = request.getParameter("transferAmount");
		String bankName = request.getParameter("bankName");
		long senderAccNum = 0;
		long accNum = 0;
		double balanceAmount = 0;
		double transferAmount = 0;
		try {
			senderAccNum = Long.parseLong(senderAccNumStr);
			accNum = Long.parseLong(accNumStr);
			balanceAmount = Double.parseDouble(balanceAmountStr);
			transferAmount = Double.parseDouble(transferAmountStr);
		} catch (NumberFormatException e) {
			logger.info(e.getMessage());
		}
		Recipient recipient = new Recipient();
		recipient.setReceiverbank(bankName);
		recipient.setBalanceAmount(balanceAmount);
		recipient.setTransferAmount(transferAmount);
		recipient.setReceiverAccNum(accNum);
		recipient.setSenderAccNum(senderAccNum);
		try {
			boolean isAdded = RecipientService.addRecipientDetail(recipient);
			String infoMsg;
			if (isAdded) {
				infoMsg = "Successfully money transfered!!!";
				response.sendRedirect("index.jsp?infoMsg=" + infoMsg);
			} else {
				infoMsg = "Unable to transfer money";
				response.sendRedirect("moneytransfer.jsp?infoMsg=" + infoMsg);
			}
		} catch (IOException | ServiceException e) {
			logger.info(e.getMessage());
		}
	}
}
