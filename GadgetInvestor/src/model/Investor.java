package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Investor {

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

	public String insertInvestor(String fid, String ftype, String fsource, String famount, String fdate) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into investor(`fid`,`ftype`,`fsource`,`famount`,`fdate`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, ftype);
			preparedStmt.setString(3, fsource);
			preparedStmt.setString(4, famount);
			preparedStmt.setString(5, fdate);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the investor.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readInvestor() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Investor ID</th><th>Investor Type</th><th>Funding Source</th><th>Funding Amount</th><th>Funding Date</th></tr>";
			String query = "select * from investor";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String fid = Integer.toString(rs.getInt("fid"));
				String ftype = rs.getString("ftype");
				String fsource = rs.getString("fsource");
				String famount = Float.toString(rs.getFloat("famount"));
				String fdate = rs.getString("fdate");

				// Add into the html table
				output += "<tr><td>" + fid + "</td>";
				output += "<td>" + ftype + "</td>";
				output += "<td>" + fsource + "</td>";
				output += "<td>" + famount + "</td>";
				output += "<td>" + fdate + "</td>";
			}
			con.close();

			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the investor.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateInvestor(String fid, String ftype, String fsource, String famount, String fdate) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE investor SET ftype=?,fsource=?,famount=?,fdate=?" + "WHERE fid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, ftype);
			preparedStmt.setString(2, fsource);
			preparedStmt.setFloat(3, Float.parseFloat(famount));
			preparedStmt.setString(4, fdate);
			preparedStmt.setInt(5, Integer.parseInt(fid));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the investor.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteInvestor(String fid) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from investor where fid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(fid));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the investor.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	//search a investor
	public String searchInvestor(int fID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			output = "<table border=\"1\"><tr><th>Investor ID</th><th>Investor Type</th><th>Funding Source</th><th>Funding Amount</th><th>Funding Date</th></tr>";
			
			String query = "select * from investor where fid=? ";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setInt(1, fID);
			ResultSet rs = preparedStmt.executeQuery();
			
			while (rs.next()) {
				String fid = Integer.toString(rs.getInt("fid"));
				String ftype = rs.getString("ftype");
				String fsource = rs.getString("fsource");
				String famount = Float.toString(rs.getFloat("famount"));
				String fdate = rs.getString("fdate");

				// Add into the html table
				output += "<tr><td>" + fid + "</td>";
				output += "<td>" + ftype + "</td>";
				output += "<td>" + fsource + "</td>";
				output += "<td>" + famount + "</td>";
				output += "<td>" + fdate + "</td>";
			}
			con.close();
			output += "</table>";
		}catch (Exception e) {
			output = "Error while reading the buyer.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
