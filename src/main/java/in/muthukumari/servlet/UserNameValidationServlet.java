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
import in.muthukumari.exception.ValidatorException;
import in.muthukumari.validator.CustomerRepeatedValidator;

/**
 * Servlet implementation class UserNameValidationServlet
 */
@WebServlet("/UserNameValidationServlet")
public class UserNameValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String userName = request.getParameter("userName");
		boolean isValidName;
		Gson gson = new Gson();
		try {
			boolean errorMessage;
			isValidName = CustomerRepeatedValidator.isUserNameExists(userName);
			if (isValidName) {
				errorMessage = true;
			} else {
				errorMessage = false;
			}
			String json = gson.toJson(errorMessage);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (IOException | ValidatorException e) {
			logger.info(e.getMessage());
		}
	}
}