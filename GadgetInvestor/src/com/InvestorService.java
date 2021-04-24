package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Investor;

@Path("/Investors")
public class InvestorService {
	Investor investorObj = new Investor();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readInvestor() {
		return investorObj.readInvestor();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertInvestor(@FormParam("fid") String fid, @FormParam("ftype") String ftype,

			@FormParam("fsource") String fsource, @FormParam("famount") String famount,
			@FormParam("fdate") String fdate) {
		String output = investorObj.insertInvestor(fid, ftype, fsource, famount, fdate);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateInvestor(String investorData) {
		// Convert the input string to a JSON object
		JsonObject buyObject = new JsonParser().parse(investorData).getAsJsonObject();
		// Read the values from the JSON object
		String fid = buyObject.get("fid").getAsString();
		String ftype = buyObject.get("ftype").getAsString();
		String fsource = buyObject.get("fsource").getAsString();
		String famount = buyObject.get("famount").getAsString();
		String fdate = buyObject.get("fdate").getAsString();

		String output = investorObj.updateInvestor(fid, ftype, fsource, famount, fdate);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteInvestor(String investorData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(investorData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String fid = doc.select("fid").text();
		String output = investorObj.deleteInvestor(fid);
		return output;
	}
	
	//Search a investor details
	@POST
	@Path("/searchInvestor")
	@Produces(MediaType.TEXT_HTML)
	public String viewBuyer(@FormParam("fid") int fid)
	{
		return investorObj.searchInvestor(fid);
	}
}
