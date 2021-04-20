package com;

import model.GadgetProduct;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Product")
public class ServiceProduct {
	GadgetProduct ProductObj = new GadgetProduct();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readProduct() {
		return ProductObj.readProduct();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertProduct(@FormParam("pName") String pName, 
			@FormParam("pDate") String pDate,
			@FormParam("pPrice") String pPrice,
			@FormParam("pDes") String pDes) {
		String output = ProductObj.insertProduct(pName, pDate, pPrice, pDes);
		return output;

	}

}
