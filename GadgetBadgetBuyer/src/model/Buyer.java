package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Buyer {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gadgetbadget?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String readBuyer() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Buyer ID</th><th>Buyer Name</th><th>Buyer Address</th><th>Buyer Email</th><th>Date</th><th>Buyer Phone No</th></tr>";
			String query = "select * from buyer1";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String bID = Integer.toString(rs.getInt("bID"));
				String bName = rs.getString("bName");
				String bAddress = rs.getString("bAddress");
				String bEmail = rs.getString("bEmail");
				String bDate = rs.getString("bDate");
				String pNo = rs.getString("pNo");

				// Add into the html table
				output += "<tr><td>" + bID + "</td>";
				output += "<td>" + bName + "</td>";
				output += "<td>" + bAddress + "</td>";
				output += "<td>" + bEmail + "</td>";
				output += "<td>" + bDate + "</td>";
				output += "<td>" + pNo + "</td>";
			}
			con.close();

			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the buyer.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertBuyer(String bname, String baddress, String bemail, String bdate, String pno) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into buyer1(`bID`,`bName`,`bAddress`,`bEmail`,`bDate`,`pNo`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, bname);
			preparedStmt.setString(3, baddress);
			preparedStmt.setString(4, bemail);
			preparedStmt.setString(5, bdate);
			preparedStmt.setString(6, pno);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the buyer.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateBuyer(String bID, String bname, String baddress, String bemail, String bdate, String pno) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE buyer1 SET bName=?,bAddress=?,bEmail=?,bDate=?,pNo=?" + "WHERE bID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, bname);
			preparedStmt.setString(2, baddress);
			preparedStmt.setString(3, bemail);
			preparedStmt.setString(4, bdate);
			preparedStmt.setString(5, pno);
			preparedStmt.setInt(6, Integer.parseInt(bID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the buyer.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteBuyer(String bID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from buyer1 where bID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(bID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the buyer.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// A buyer Details display method
	public String searchBuyerInfo(int bId) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			output = "<table border=\"1\"><tr><th>Buyer ID</th><th>Buyer Name</th><th>Buyer Address</th><th>Buyer Email</th><th>Date</th><th>Buyer Phone No</th></tr>";

			String query = "select * from buyer1 where bID=? ";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, bId);
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				String bID = Integer.toString(rs.getInt("bID"));
				String bName = rs.getString("bName");
				String bAddress = rs.getString("bAddress");
				String bEmail = rs.getString("bEmail");
				String bDate = rs.getString("bDate");
				String pNo = rs.getString("pNo");

				// Add into the html table
				output += "<tr><td>" + bID + "</td>";
				output += "<td>" + bName + "</td>";
				output += "<td>" + bAddress + "</td>";
				output += "<td>" + bEmail + "</td>";
				output += "<td>" + bDate + "</td>";
				output += "<td>" + pNo + "</td>";
			}
			con.close();
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the buyer.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
