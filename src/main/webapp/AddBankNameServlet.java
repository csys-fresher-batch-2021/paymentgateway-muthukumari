package in.muthukumari.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.muthukumari.service.OperationsOnBankList;

/**
 * Servlet implementation class AddBankName
 */
@WebServlet("/AddBankNameServlet")
public class AddBankNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//System.out.println("AddBankNameServlet");
		// Step 1: Get Form Values
		String bankName = request.getParameter("bankName");
		out.println(bankName);
		// Step 2: Call Service => add Product
		boolean isAdded = OperationsOnBankList.addBankList(bankName);
		// Step 3: Decide to which page we should redirect ?
		if (isAdded) {
			
			String errorMessage = "valid Bank Name";
			response.sendRedirect("bankNameList.jsp?errorMessage="+errorMessage);
		} else {
			String errorMessage = "Invalid Bank Name";
			response.sendRedirect("bankNameList.jsp?errorMessage=" + errorMessage);
		}
	}

}
