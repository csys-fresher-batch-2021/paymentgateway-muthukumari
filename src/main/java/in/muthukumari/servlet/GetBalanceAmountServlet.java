package in.muthukumari.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.muthukumari.exception.ServiceException;
import in.muthukumari.service.BankService;

/**
 * Servlet implementation class GetBalanceAmountServlet
 */
@WebServlet("/GetBalanceAmountServlet")
public class GetBalanceAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String accNumStr = request.getParameter("accNum");
		try {

			long accNum = Long.parseLong(accNumStr);
			double amount = BankService.getBalanceAmount(accNum);
			Gson gson = new Gson();
			String json = gson.toJson(amount);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (ServiceException | NumberFormatException | IOException e) {
			logger.info(e.getMessage());
		}
	}
}
