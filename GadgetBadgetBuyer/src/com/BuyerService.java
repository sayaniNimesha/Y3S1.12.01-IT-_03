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

}
