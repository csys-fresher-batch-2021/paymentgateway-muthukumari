package in.muthukumari.servlet;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.muthukumari.exception.ServiceException;
import in.muthukumari.model.Customer;
import in.muthukumari.service.CustomerService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Customer customer = new Customer();
		customer.setUserName(userName);
		customer.setPassword(password);
		try {
			boolean isLoggedIn = CustomerService.loginUser(customer);
			if (isLoggedIn) {
				session.setAttribute("userName", userName);
				String infoMessage = "Successfully logged In";
				session.setAttribute("infoMSG", infoMessage);
				response.sendRedirect("index.jsp");
			} else {
				String errorMessage = "Invalid Data";
				session.setAttribute("errMSG", errorMessage);
				response.sendRedirect("login.jsp");
			}
		} catch (IOException | ServiceException e) {
			logger.info(e.getMessage());
		}
	}
}
