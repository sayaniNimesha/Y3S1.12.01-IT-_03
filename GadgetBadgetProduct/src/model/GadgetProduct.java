package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GadgetProduct {

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
	
	public String readProduct() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Product ID</th><th>Product Name</th><th>Date</th><th>Price</th><th>Description</th></tr>";
			String query = "select * from product1";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String pId = Integer.toString(rs.getInt("pId"));
				String pName = rs.getString("pName");
				String pDate = rs.getString("pDate");
				String pPrice = rs.getString("pPrice");
				String pDes = rs.getString("pDes");

				output += "<tr><td>" + pId + "</td>";
				output += "<td>" + pName + "</td>";
				output += "<td>" + pDate + "</td>";
				output += "<td>" + pPrice + "</td>";
				output += "<td>" + pDes + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the product.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String insertProduct(String pname, String pdate, String price, String pdes) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into product1(`pId`, `pName`, `pDate`, `pPrice`, `pDes`)" + " values ( ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, pname);
			preparedStmt.setString(3, pdate);
			preparedStmt.setString(4, price);
			preparedStmt.setString(5, pdes);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the product.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
