package com.comparetool.sql;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/status")
public class SqlService {

	@GET
	@Produces(MediaType.TEXT_XML)
	public String getStatus(){
		return "<p> Java is cool</p>";
	}
}
