package in.muthukumari.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.muthukumari.service.RecipientService;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accNumStr=request.getParameter("accNum");
		String amountStr=request.getParameter("amount");
		long accNum=Long.parseLong(accNumStr);
		double amount=Double.parseDouble(amountStr);
		boolean isUpdated=RecipientService.updateAmount(accNum,amount);
		if(isUpdated) {
			String infoMsg="Amount Deposited Successfully!!";
			response.sendRedirect("index.jsp?infoMsg="+infoMsg);
		}
		else {
			String errMsg="Sorry! Unable to deposit the amount";
			response.sendRedirect("index.jsp?errMsg="+errMsg);
		}
	}
}