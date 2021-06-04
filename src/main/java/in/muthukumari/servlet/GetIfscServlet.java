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

import in.muthukumari.controller.BankDetailsController;
import in.muthukumari.exception.InvalidException;

/**
 * Servlet implementation class getIfscservlet
 */
@WebServlet("/getIfscServlet")
public class GetIfscServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger =  Logger.getLogger(this.getClass().getName());
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		BankDetailsController controller=new BankDetailsController();
		String bankName = request.getParameter("bankName");//get bank name
		String branchName = request.getParameter("branchName");//get branch name
		Gson gson = new Gson();
		String ifsc;
		try {
			ifsc = controller.getIfscCode(bankName, branchName);//get ifsc code
			String json = gson.toJson(ifsc);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (InvalidException | IOException e) {
			logger.info(e.getMessage());
		}

	}

}
