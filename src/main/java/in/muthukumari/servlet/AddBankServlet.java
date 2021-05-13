package in.muthukumari.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.muthukumari.service.BankDetailServer;

/**
 * Servlet implementation class AddBankName
 */
@WebServlet("/AddBankServlet")
public class AddBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		// Step 1: Get Form Values
		String bankName = request.getParameter("bankName");
		out.println(bankName);

		try {
			// Step 2: Call Service => Add Bank Name
			boolean isAdded = BankDetailServer.addBankList(bankName);
			// Step 3: Decide to which page we should redirect ?
			if (isAdded) {
				String errorMessage = "Successfully Added";
				response.sendRedirect("bankNameList.jsp?errorMessage=" + errorMessage);
			}
			else {
				String errorMessage = "Invalid Bank Name";
				response.sendRedirect("bankNameList.jsp?errorMessage=" + errorMessage);
			}
		} catch (Exception e) {

			String errorMessage = e.getMessage();
			response.sendRedirect("bankNameList.jsp?errorMessage=" + errorMessage);

		}
	}

}
