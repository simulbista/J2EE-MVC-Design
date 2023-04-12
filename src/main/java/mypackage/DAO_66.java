//EmployeeDAO.java - access database
package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO_66 {
	Connection conn;

	public DAO_66() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String dburl = "jdbc:mysql://localhost:3306/W11_simul";
			String uname = "root";
			String pass = "root";
			conn = DriverManager.getConnection(dburl, uname, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// crud operations
	
	
	//read data from the db
	public String[][] getFriendsInfo() throws Exception {
		String selectQry = "Select friendID, friendName, emailAddr, age, favoriteColor from Friends";
		PreparedStatement pstmt = conn.prepareStatement(selectQry);
		
		ResultSet rs = pstmt.executeQuery();
		
		//storing values from each rows into a row array and then storing all those rows to a arraylist of strings resultList
		ArrayList<String[]> resultList = new ArrayList<>();
	    while (rs.next()) {
	        String[] row = new String[5];
	        for (int i = 1; i <= 5; i++) {
	            row[i - 1] = rs.getString(i);
	        }
	        resultList.add(row);
	    }
		
	    //convert  arraylist of strings to 2d array of string
	    String[][] resultArray = new String[resultList.size()][5];
	    for (int i = 0; i < resultList.size(); i++) {
	        resultArray[i] = resultList.get(i);
	    }
		return resultArray;
	}
	
	// insert data into the db
	public int AddFriend(M_66 friendModel) throws Exception {
		int rowsInserted;
		String insertQry = "INSERT INTO Friends (friendName, emailAddr, age, favoriteColor) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(insertQry);
		pstmt.setString(1, friendModel.getfName());
	    pstmt.setString(2, friendModel.getEmail());
	    pstmt.setInt(3, friendModel.getAge());
	    pstmt.setString(4, friendModel.getFavColor());
	    rowsInserted = pstmt.executeUpdate();
	    System.out.println("Friend record added!");
	    return rowsInserted;
	}
}
