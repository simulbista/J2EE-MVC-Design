//controller - performs server side validation on the data passed through the form, and calls the insert method in the DAO (uses Model)
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
		M_66 friendModel = new M_66();
		String friendName = req.getParameter("friendName");
		String emailAddress = req.getParameter("emailAddress");
		String age = req.getParameter("age");
		String favoriteColor = req.getParameter("favoriteColor");
		
//		server side validation (null check)
		if(friendName !=null && !friendName.isEmpty() && emailAddress !=null && !emailAddress.isEmpty() && age !=null &&  !age.isEmpty() && favoriteColor!=null && !favoriteColor.isEmpty()) {
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
					req.setAttribute("popUpMsg", "Record has been successfully added!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("V_66_View.jsp");
					dispatcher.forward(req, res);
				}else {
					System.out.println("Friend data not added!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			//return back to the form jsp returning empty error (along with the incomplete values submitted through the form)
			System.out.println("One/more of the form fields is empty!");
			req.setAttribute("popUpMsg", "One/more form field(s) is empty!");
			req.setAttribute("friendName", friendName);
			req.setAttribute("emailAddress",emailAddress );
			req.setAttribute("age", age);
			req.setAttribute("favoriteColor", favoriteColor);
//			redirect back to the form and passing the validation error msg to be displayed
			RequestDispatcher dispatcher = req.getRequestDispatcher("V_66_Add.jsp");
			dispatcher.forward(req, res);
		}

	}
}
