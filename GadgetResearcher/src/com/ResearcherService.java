package com;

import model.Researcher;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Researcher")
public class ResearcherService {
	Researcher ResearcherObj = new Researcher();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readResearcher() {
		return ResearcherObj.readResearcher();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertResearcher(@FormParam("rId") String rId, 
			@FormParam("rName") String rName,
			@FormParam("pName") String pName,  
			@FormParam("rDate") String rDate,
			@FormParam("rDes") String rDes) {
		String output = ResearcherObj.insertResearcher(rId, rName, pName, rDate, rDes);
		return output;
	}
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updateResearcher(String ResearcherData) {
		// Convert the input string to a JSON object
		JsonObject ResObject = new JsonParser().parse(ResearcherData).getAsJsonObject();

		// Read the values from the JSON object
		String rId = ResObject.get("rId").getAsString();
		String rName = ResObject.get("rName").getAsString();
		String pName = ResObject.get("pName").getAsString();
		String rDate = ResObject.get("rDate").getAsString();
		String rDes = ResObject.get("rDes").getAsString();

		String output = ResearcherObj.updateResearcher(rId, rName, pName, rDate, rDes);
		return output;
	}
	
	//this is delete part
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteResearcher(String ResearcherData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(ResearcherData, "", Parser.xmlParser());

		// Read the value from the element
		String rId = doc.select("rId").text();
		String output = ResearcherObj.deleteResearcher(rId);
		return output;
	}
}
