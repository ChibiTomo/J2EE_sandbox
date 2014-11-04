package com.jlg.tutorial.rs;

import java.util.HashMap;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/parser")
public class ParserRS {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{value}")
	public String echo(@QueryParam("name") String name,
			@FormParam("type") String type, @PathParam("value") String value) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("type", type);
		map.put("value", value);
		return map.toString();
	}
}
