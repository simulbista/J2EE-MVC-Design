//EmployeeController.java - logic for checking if data from view.jsp form matches with the data from the database
package mypackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddFormController")
public class C_66_FormOpen extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
			RequestDispatcher dispatcher = req.getRequestDispatcher("V_66_Add.jsp");
			dispatcher.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
