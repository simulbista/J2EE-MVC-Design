//controller - gets all the data from the db by calling the read method in the DAO (uses Model)
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
