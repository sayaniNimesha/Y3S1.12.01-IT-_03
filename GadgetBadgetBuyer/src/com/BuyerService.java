package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Buyer;


@Path("/Buyer")

public class BuyerService {
	Buyer buyerObj = new Buyer();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readBuyer() {
		return buyerObj.readBuyer();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertBuyer(@FormParam("bName") String bName,
			
	 @FormParam("bAddress") String bAddress,
	 @FormParam("bEmail") String bEmail,
	 @FormParam("bDate") String bDate,
	 @FormParam("pNo") String pNo)
	{
	 String output = buyerObj.insertBuyer(bName, bAddress, bEmail, bDate, pNo);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBuyer(String buyerData)
	{
	//Convert the input string to a JSON object
	 JsonObject buyObject = new JsonParser().parse(buyerData).getAsJsonObject();
	//Read the values from the JSON object
	 String bID = buyObject.get("bID").getAsString();
	 String bName = buyObject.get("bName").getAsString();
	 String bAddress = buyObject.get("bAddress").getAsString();
	 String bEmail = buyObject.get("bEmail").getAsString();
	 String bDate = buyObject.get("bDate").getAsString();
	 String pNo = buyObject.get("pNo").getAsString();
	 String output = buyerObj.updateBuyer(bID, bName, bAddress, bEmail, bDate, pNo);
	return output;
	} 
	

}
