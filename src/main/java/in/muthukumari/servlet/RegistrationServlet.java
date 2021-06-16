package in.muthukumari.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.muthukumari.exception.ServiceException;
import in.muthukumari.model.Customer;
import in.muthukumari.service.CustomerService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Customer customer = new Customer();
		String mobileNoStr = request.getParameter("phoneNumber");
		long mobileNo = 0;
		try {
			mobileNo = Long.parseLong(mobileNoStr);
		} catch (NumberFormatException e) {
			logger.info(e.getMessage());
		}
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		customer.setMobileNo(mobileNo);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setUserName(userName);
		customer.setPassword(password);

		try {
			boolean isUserAdded = CustomerService.addCustomer(customer);
			if (isUserAdded) {
				String infoMsg = "Registered Successfully!!!!";
				response.sendRedirect("index.jsp?infoMsg=" + infoMsg);
			} else {
				String errMsg = "Sorry!! Please enter the valid data(username or emailid is already given)";
				response.sendRedirect("registration.jsp?errMsg=" + errMsg);
			}
		} catch (IOException | ServiceException e) {
			logger.info(e.getMessage());
		}
	}
}
