package com.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hell")
public class Hell {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHello() {

		return "<html><body>helWWloo</body></html>";
	}

}
