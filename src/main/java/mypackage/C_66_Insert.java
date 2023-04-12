//EmployeeController.java - logic for checking if data from view.jsp form matches with the data from the database
package mypackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddController")
public class C_66_Insert extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DAO_66 friendDAO;
	
	public void init() {
		friendDAO = new DAO_66();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String credentials[]= new String[2];
		M_66 friendModel = new M_66();
		String friendName = req.getParameter("friendName");
		String emailAddress = req.getParameter("emailAddress");
		String age = req.getParameter("age");
		String favoriteColor = req.getParameter("favoriteColor");
//		server side validation (null check)
		
		if(friendName.isEmpty() && emailAddress.isEmpty() && age.isEmpty() && favoriteColor.isEmpty()) {
			//return back to the form jsp returning empty error
			System.out.println("One/more of the form fields is empty!");
			req.setAttribute("emptyError", "true");
			RequestDispatcher dispatcher = req.getRequestDispatcher("V_66_Add.jsp");
			dispatcher.forward(req, res);
		}else {
			//empty validation passed
			friendModel.setfName(friendName);
			friendModel.setEmail(emailAddress);
			friendModel.setAge(Integer.parseInt(age));
			friendModel.setFavColor(favoriteColor);
			String[][] friendsInfo;
			try {
				if(friendDAO.AddFriend(friendModel)>0) {
					//friend added succesffuly, now pass all the records from the database back to the jsp to display
					friendsInfo = friendDAO.getFriendsInfo();
					req.setAttribute("friendsInfo", friendsInfo);

					RequestDispatcher dispatcher = req.getRequestDispatcher("V_66_View.jsp");
					dispatcher.forward(req, res);
				}else {
					System.out.println("Friend data not added!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
