//DAO_66.java - access database (read,add and delete db data) (access db conn info through dbConn.properties file)
package mypackage;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class DAO_66 {
	Connection conn;

	public DAO_66() {
		// Load db credentials from properties file
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("./resources/dbConn.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);

			// setting db connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = properties.getProperty("db.url");
			String uname = properties.getProperty("db.username");
			String pass = properties.getProperty("db.password");
			conn = DriverManager.getConnection(dburl, uname, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// crud operations

	// read data from the db
	public String[][] getFriendsInfo() throws Exception {
		String selectQry = "Select friendID, friendName, emailAddr, age, favoriteColor from Friends";
		PreparedStatement pstmt = conn.prepareStatement(selectQry);

		ResultSet rs = pstmt.executeQuery();

		// storing values from each rows into a row array and then storing all those
		// rows to a arraylist of strings resultList
		ArrayList<String[]> resultList = new ArrayList<>();
		while (rs.next()) {
			String[] row = new String[5];
			for (int i = 1; i <= 5; i++) {
				row[i - 1] = rs.getString(i);
			}
			resultList.add(row);
		}

		// convert arraylist of strings to 2d array of string
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

	// delete data from the db
	public int deleteFriend(M_66 friendModel) throws SQLException {
		int rowsDeleted = 0;
		// check if the id exists in the db
		String checkQry = "SELECT friendID FROM Friends WHERE friendID = ?";
		PreparedStatement checkPstmt = conn.prepareStatement(checkQry);
		checkPstmt.setInt(1, friendModel.getfId());
		ResultSet rs = checkPstmt.executeQuery();

		// Check if the friend with the specified ID exists in the database
		if (rs.next()) {
			// Friend exists, delete it
			String deleteQry = "DELETE FROM Friends WHERE friendID = ?";
			PreparedStatement deletePstmt = conn.prepareStatement(deleteQry);
			deletePstmt.setInt(1, friendModel.getfId());
			rowsDeleted = deletePstmt.executeUpdate();
			System.out.println("Friend record deleted!");
		} else {
			// Friend doesn't exist
			System.out.println("Friend with ID " + friendModel.getfId() + " doesn't exist in the database.");
		}
		return rowsDeleted;
	}
}
