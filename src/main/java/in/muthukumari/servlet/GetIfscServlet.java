package in.muthukumari.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bankName = request.getParameter("bankName");//get bank name
		String branchName = request.getParameter("branchName");//get branch name
		Gson gson = new Gson();
		String ifsc;
		try {
			ifsc = BankDetailsController.getIfscCode(bankName, branchName);//get ifsc code
			String json = gson.toJson(ifsc);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (ClassNotFoundException | InvalidException | SQLException e) {
			e.printStackTrace();
		}

	}

}
