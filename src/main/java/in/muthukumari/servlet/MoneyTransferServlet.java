package in.muthukumari.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.muthukumari.exception.ServiceException;
import in.muthukumari.service.BankService;

/**
 * Servlet implementation class MoneyTransferServlet
 */
@WebServlet("/MoneyTransferServlet")
public class MoneyTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		try {
			List<Long> accNum = BankService.getAccountNumber(userName);
			if (!accNum.isEmpty()) {
				session.setAttribute("accNum", accNum);
				RequestDispatcher rd = request.getRequestDispatcher("moneytransfer.jsp");
				rd.forward(request, response);
			} else {
				String infoMsg = "You doesn't create your account!!! So, Please create your account using bank details";
				response.sendRedirect("banknamelist.jsp?infoMsg=" + infoMsg);
			}
		} catch (ServiceException | IOException e) {
			logger.info(e.getMessage());
		}
	}
}
