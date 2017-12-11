package com.argade.sameer.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public interface RESTFull {

	@POST
	@Path("push")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json", "application/x-www-form-urlencoded" })
	public Response push(@FormParam("i1") int i1, @FormParam("i2") int i2) throws Exception;

	@GET
	@Path("list")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json", "application/x-www-form-urlencoded" })
	public Response list() throws Exception;
}
