package com.a98labs.reports;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class ExcelResource {

	// TODO: Implement dependency injection
	// https://quarkus.io/guides/cdi-reference
	ExcelService excelService = new ExcelService();
	
	@GET
	@Produces("application/vnd.ms-excel")
    public Response downloadExcel() {

		final String filename = "SampleExcel.xlsx";

		InputStream is = new ByteArrayInputStream(excelService.toByteArray());
		 
        ResponseBuilder responseBuilder = Response.ok(is);
        responseBuilder.header("Content-Disposition", 
        		String.format("attachment; filename=\"%s\"", filename));
        
        return responseBuilder.build();
	}
	

}