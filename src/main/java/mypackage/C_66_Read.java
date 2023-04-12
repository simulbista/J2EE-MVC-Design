//EmployeeController.java - logic for checking if data from view.jsp form matches with the data from the database
package mypackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadController")
public class C_66_Read extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DAO_66 friendDAO;
	
	public void init() {
		friendDAO = new DAO_66();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//storing data(username, password) from the form in view.jsp to the model 
		//and then passing the model to the DAO to select data from the database based on the username
		String[][] friendsInfo;
		try{
			friendsInfo = friendDAO.getFriendsInfo();
			req.setAttribute("friendsInfo", friendsInfo);

			RequestDispatcher dispatcher = req.getRequestDispatcher("V_66_View.jsp");
			dispatcher.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
