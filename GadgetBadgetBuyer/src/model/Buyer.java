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
			output = "<table border=\"1\"><tr><th>Buyer Name</th><th>Buyer Address</th><th>Buyer Email</th><th>Date</th><th>Buyer Phone No</th></tr>";
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
				output += "<tr><td>" + bName + "</td>";
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
