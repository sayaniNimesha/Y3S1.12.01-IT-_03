package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			/* con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gadgetbadget?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", ""); */
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbadget","root", "");
			//For testing
			System.out.print("Successfully connected");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertPayment(String pyId, String pyDes, String pyDate, String amount) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into pay1(`pyId`,`pyDes`,`pyDate`,`amount`)" + " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, pyDes);
			preparedStmt.setString(3, pyDate);
			preparedStmt.setString(4, amount);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readPayment() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Payment ID</th><th>Description</th><th>Date</th><th>Amount</th></tr>";
			String query = "select * from pay1";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String pyId = Integer.toString(rs.getInt("pyId"));
				String pyDes = rs.getString("pyDes");
				String pyDate = rs.getString("pyDate");
				String amount = Float.toString(rs.getFloat("amount"));

				output += "<tr><td>" + pyId + "</td>";
				output += "<td>" + pyDes + "</td>";
				output += "<td>" + pyDate + "</td>";
				output += "<td>" + amount + "</td>";

			}
			con.close();

			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatePayment(String pyId, String pyDes, String pyDate, String amount) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE pay1 SET pyDes=?,pyDate=?,amount=? WHERE pyId=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values

			preparedStmt.setString(1, pyDes);
			preparedStmt.setString(2, pyDate);
			preparedStmt.setFloat(3, Float.parseFloat(amount));
			preparedStmt.setInt(4, Integer.parseInt(pyId));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the Payment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deletePayment(String pyId) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from pay1 where pyId=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(pyId));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the Payment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
