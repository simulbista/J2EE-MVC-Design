//controller - checks if the id of the record to be deleted exists and then calls the delete method in the DAO (uses Model)
package mypackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteController")
public class C_66_Delete extends HttpServlet {
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
		M_66 friendModel = new M_66();
		String fId = req.getParameter("id");
		

			//empty validation passed
			friendModel.setfId(Integer.parseInt(fId));
			try {
				if(friendDAO.deleteFriend(friendModel)>0) {
					//friend deleted succesffuly, now pass all the records from the database back to the jsp to display
					req.setAttribute("popUpMsg", "Record has been deleted");
				}else {
					//id doesn't exist in the db
					System.out.println("Friend data not deleted!");
					req.setAttribute("popUpMsg", "Id doesn't exist!");
				}
				//pass the control to the read servlet which then send all the db data back to the view for display
				RequestDispatcher dispatcher = req.getRequestDispatcher("/ReadController");
				dispatcher.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}

	}
	
}
