package in.muthukumari.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.muthukumari.exception.ServiceException;
import in.muthukumari.service.BankDetailService;

/**
 * Servlet implementation class BakNameListServlet
 */
@WebServlet("/BankNameListServlet")
public class BankNameListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * This servlet used to get the bank name list
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			Set<String> bankNameList = BankDetailService.getBankNameList();
			Gson gson = new Gson();
			String json = gson.toJson(bankNameList);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (ServiceException | IOException e) {
			logger.info(e.getMessage());
		}
	}
}
