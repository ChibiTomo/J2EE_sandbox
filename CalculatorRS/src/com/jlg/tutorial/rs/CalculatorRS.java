package com.jlg.tutorial.rs;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Singleton;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.jlg.tutorial.obj.Vector;

@Singleton
@Path("/calc")
public class CalculatorRS {
	private static Logger logger = Logger.getLogger("CalculatorRS");

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int addPlainText(@QueryParam("a") int a, @QueryParam("b") int b) {
		return a + b;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String addXML(@QueryParam("a") int a, @QueryParam("b") int b) {
		return "<?xml version=\"1.0\"?>" + "<result>" + (a + b) + "</result>";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String addJSON(@QueryParam("a") int a, @QueryParam("b") int b) {
		return "{ \"result\": " + (a + b) + " }";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String addHTML(@QueryParam("a") int a, @QueryParam("b") int b) {
		return "<html> " + "<title>" + "Calculator RS" + "</title>" + "<body>"
				+ (a + b) + "</body>" + "</html> ";
	}

	@GET
	@Path("/addVector")
	@Produces(MediaType.APPLICATION_JSON)
	public Vector addVector(@QueryParam("v1") Vector v1,
			@QueryParam("v2") Vector v2) {

		// logger.log(Level.INFO, "v1=" + v1);
		// logger.log(Level.INFO, "v2=" + v2);
		Vector result = new Vector(10, 11);
		if (v1 != null && v2 != null) {
			result = new Vector(v1.x + v2.x, v1.y + v2.y);
		}
		// logger.log(Level.INFO, "result=" + result);
		return result;
	}

	@POST
	@Path("/scalarVector")
	@Produces(MediaType.TEXT_PLAIN)
	public int scalarVector(@FormParam("v1") Vector v1,
			@FormParam("v2") Vector v2) {
		logger.log(Level.INFO, "v1=" + v1);
		logger.log(Level.INFO, "v2=" + v2);

		return v1.x * v2.x + v1.y * v2.y;
	}

}
