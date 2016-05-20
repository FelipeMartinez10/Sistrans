package rest;

import javax.servlet.ServletContext;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.PuertoAndesMaster;
import vos.Descuento;


@Path("descuentos")
public class PuertoAndesDescuentosServices 
{
	
	
		@Context
		private ServletContext context;


		private String getPath() {
			return context.getRealPath("WEB-INF/ConnectionData");
		}
		
		
		private String doErrorMessage(Exception e){
			return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
		}
		

//		@PUT
//		@Path("/TPC")
//		public void getFacturas() {
//			PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
//			try {
//				tm.twoPhaseCommitRF15("1");
//			} catch (Exception e) {
//				
//			}
//			
//		}
		
		@PUT
		@Path("/TPCR15")
		@Produces(MediaType.APPLICATION_JSON)
		public Response addDescuento(@QueryParam("IdExportador") String idExpo) {
			PuertoAndesMaster tm = new PuertoAndesMaster(getPath());
			Descuento dto = null; 
			try {
			dto = 	tm.twoPhaseCommitRF15(idExpo);
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(dto).build();
		}

}
