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

}
